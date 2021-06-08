package com.manjaro.code.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * created by iriwen on 2020/07/12.
 */
public class ZkWatcher implements Watcher {

    private static final String path = "/test";
    private static ZooKeeper zk;

    public static void main(String[] args) throws Exception {

        //这里的watcher不指定好，启动时候会有空异常报错
        zk = new ZooKeeper("localhost:2181", 3000, item -> {
            System.out.println("the zookeeper server up ; the state is " + item.getState());
        });
        ZkWatcher watcher = new ZkWatcher();
        Stat exists = zk.exists(ZkWatcher.path, watcher);
        if (exists == null) {
            zk.create(path, "theFirtZnode".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } else {
            System.out.println("target znode exists !");
        }

        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            System.out.println("用户完成输入： " + input);
            if ("exit".equals(input)) {
                System.exit(0);
            } else {
                System.out.println("请输入 exit 来结束当前进程; 当前输入是:" + input);
            }
        }
    }

    /**
     * 每当一个watcher处理完，被服务端移除之后，执行的对应的process方法会再重新注册新的watcher，
     * 持续对node节点新发生的事件进行关注，注意设置好和zookeeper的会话失效时间（这里是关键，
     * 否则进行watcher注册的时候会提示connection losed，导致注册失败）,连接保持好 则持续注册都会成功
     *
     * @param watchedEvent
     */
    @Override

    public void process(WatchedEvent watchedEvent) {

        if (watchedEvent.getType().equals(Event.EventType.NodeCreated)) {
            System.out.println("znode created !");
        } else if (watchedEvent.getType().equals(Event.EventType.NodeDeleted)) {
            System.out.println("znode deleted !");
        }
        try {
            zk.exists("/test", new ZkWatcher());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception info :" + e.getMessage());
        }
    }

}
