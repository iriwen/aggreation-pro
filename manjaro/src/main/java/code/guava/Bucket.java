package code.guava;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * created by iriwen on 2020/06/05.
 */
public class Bucket {

    private static final int BUCK_LIMIT = 1000;
    private final ConcurrentLinkedQueue<Integer> container = new ConcurrentLinkedQueue();
    //一秒的处理速率是10个
    private final RateLimiter rateLimiter = RateLimiter.create(10);

    private final Monitor putMonitor = new Monitor();

    private final Monitor fetchMonitor = new Monitor();

    public static void main(String[] args) {

        final Bucket bucket = new Bucket();

        final AtomicInteger DATA_CREATOR = new AtomicInteger(0);
        //一秒放5个，一共10个线程,一共是50个
        IntStream.range(0, 10).forEach(i -> {
            new Thread(() -> {
                for ( ; ; ) {
                    int dataAesc = DATA_CREATOR.getAndIncrement();
                    bucket.put(dataAesc);

                    try {
                        TimeUnit.MILLISECONDS.sleep(200L);
                    } catch (Exception e) {
                        if (e instanceof IllegalStateException) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }).start();
        });

        //消费 每秒是5个线程 消费10个/s
        IntStream.range(0, 5).forEach(i -> {

            new Thread(() -> {
                for ( ; ; ) {
                    bucket.fetchAndConsume(x-> System.out.println(Thread.currentThread() + "work " + x ));
                }
            }).start();
        });
    }

    public void put(Integer data) {

        if (putMonitor.enterIf(putMonitor.newGuard(() -> container.size() < BUCK_LIMIT))) {

            try {
                container.offer(data);
                System.out.println(Thread.currentThread() + " submit data:" + data + " , current size: " + container.size());
            } finally {
                putMonitor.leave();
            }
        } else {
            throw new IllegalStateException("the bucket is full");
        }
    }

    public void fetchAndConsume(Consumer<Integer> consumer) {

        if (fetchMonitor.enterIf(fetchMonitor.newGuard(() -> !container.isEmpty()))) {

            try {
                System.out.println(Thread.currentThread() + "waiting " + rateLimiter.acquire());
                consumer.accept(container.poll());
            } finally {
                fetchMonitor.leave();
            }
        }
    }
}
