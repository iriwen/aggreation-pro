package com.manjaro.code.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by iriwen on 2020/07/11.
 */
public class ZookeeperHA {

    private static final String path = "/HA";
    private String role;
    private ZooKeeper zooKeeper;

    public static void main(String[] args) throws Exception {

        ZookeeperHA zkHa = new ZookeeperHA();
        ZooKeeper zookeeper = zkHa.getZookeeper();

        Stat exists = zookeeper.exists(ZookeeperHA.path, event -> {
            if (event.getType().equals(Watcher.Event.EventType.NodeCreated)) {

                System.out.println("I am " + zkHa.getRole());

            } else if (event.getType().equals(Watcher.Event.EventType.NodeDeleted)) {
                System.out.println("master is down !");
                zkHa.setRole("master");
                try {
                    String result = zookeeper.create(ZookeeperHA.path, "first node".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                    System.out.println("I am " + zkHa.getRole()+"; create result :" +result);
                } catch (Exception e) {

                    System.out.println("failed to create znode,exception info :" + e.getMessage());
                    e.printStackTrace();
                    try {
                        zookeeper.exists(ZookeeperHA.path, watchedEvent -> {
                            System.out.println("I want to be master !");
                        });
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });

        if (exists == null) {
            //创建znode,角色变为cluster;
            zkHa.setRole("master");
            zookeeper.create(ZookeeperHA.path, "first node".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } else {
            //znode已经存在，后进来的变为slave
            zkHa.setRole("slave");
            System.out.println("my role is " + zkHa.getRole());
        }

        while (true) {
            if ("quit".equals(getUserInput())) {
                System.exit(0);
            } else {
                System.out.println("输入quit退出程序");
            }
        }
    }

    public static String getUserInput() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return s;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private ZooKeeper getZookeeper() {
        try {
            zooKeeper = new ZooKeeper("127.0.0.1:2181", 1000, item -> {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zooKeeper;
    }
}
