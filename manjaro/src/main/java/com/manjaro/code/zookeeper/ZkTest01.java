package com.manjaro.code.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * created by iriwen on 2020/07/11.
 */
public class ZkTest01 implements Watcher {

    public static void main(String[] args) throws Exception {

        ZooKeeper zk = new ZooKeeper("localhost:2181", 300, new ZkTest01(), false);

        ZooKeeper.States state = zk.getState();

        System.out.println(state);


        //zk.delete("/zkData" ,-1);
        Stat exists = zk.exists("/zkData", new ZkTest01());
        zk.create("/zkData", "hello".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        Thread.sleep(200000);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("watcher: " + event.getState());
        if (event.getType().equals(Event.EventType.NodeCreated)) {
            System.out.println("znode created ;" + event.getPath());
        }

    }
}
