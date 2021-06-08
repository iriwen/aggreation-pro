package code.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;

/**
 * 利用zk实现分布式锁
 * ReentranLock（true） 表示是公平锁
 */
public class DistributedLock {

    // 此demo使用的集群，所以有多个ip和端口
    private static final String ZK_SERVER = "localhost:2181";
    // session过期时间
    private static final int SESSION_TIMEOUT = 3000;
    // 连接超时时间
    private static final int CONNECTION_TIMEOUT = 3000;
    // 锁节点
    private static final String LOCK_NODE = "/distributeLock";


    public static void main(String[] args) {

        RetryNTimes retryPolicy = new RetryNTimes(10, 5000);
        CuratorFramework client = CuratorFrameworkFactory.builder().
                connectString(ZK_SERVER).
                connectionTimeoutMs(15 * 1000).
                sessionTimeoutMs(60 * 100).
                retryPolicy(retryPolicy).
                build();
        client.start();



        //CuratorFramework framework = CuratorFrameworkFactory.
         //       newClient(ZK_SERVER, SESSION_TIMEOUT, CONNECTION_TIMEOUT, new RetryNTimes(10,5000));


    }



}
