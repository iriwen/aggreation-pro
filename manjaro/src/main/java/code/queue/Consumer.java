package code.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * created by iriwen on 2020/10/22.
 * <p>
 * BlockingQueue的主要方法
 * 添加元素
 * put() //往队列里插入元素,如果队列已经满,则会一直等待直到队列为空插入新元素,或者线程被中断抛出异常;
 * offer() //往队列添加元素如果队列已满直接返回false,队列未满则直接插入并返回true;
 * add() //对offer()方法的简单封装.如果队列已满,抛出异常new IllegalStateException("Queue full");
 * <p>
 * 删除元素
 * remove() //方法直接删除队头的元素;
 * take() //取出并删除队头的元素,当队列为空,则会一直等待直到队列有新元素可以取出,或者线程被中断抛出异常;
 * pool() //取出并删除队头的元素,当队列为空,返回null;
 * peek() //直接取出队头的元素,并不删除;
 * element() //对peek方法进行简单封装,如果队头元素存在则取出并不删除,如果不存在抛出异常NoSuchElementException();
 * <p>
 * <p>
 * 基于内存的队列，队列的大小依赖于JVM内存的大小，一般如果是内存占用不大且处理相对较为及时的都可以采用此种方法。
 * 如果你在队列处理的时候需要有失败重试机制，那么用此种队列就不是特别合适了，可以使用基于数据库的mq。
 */
public class Consumer {

    private static final ScheduledExecutorService executors = Executors.newScheduledThreadPool(1);
    private final int id;
    private final BlockingQueue<String> queue;

    public Consumer(int id, BlockingQueue<String> queue) {
        this.id = id;
        this.queue = queue;
        System.out.println("创建了消费者：" + id + "号");
    }

    public static void main(String[] args) {
        LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>(1000);

        Producer producer = new Producer(1, queue);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 100; i++) {
            producer.produce("@" + i + "@");
        }
        Consumer consumer = new Consumer(1, queue);
        consumer.consume();
    }

    public void consume() {
        executors.scheduleWithFixedDelay(() -> {

            System.out.println("消费者手里的线程池核武器收到了一个命令，此时队列中的任务数" + queue.size() + "个");
            try {
                String message = queue.take();
                System.out.println("消费者：" + id + "号，开始消费了");
                Thread.sleep(2000);
                System.out.println("消费者：" + id + "号， 消费结束了，消息为：" + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 0, 2, TimeUnit.SECONDS);
    }
}
