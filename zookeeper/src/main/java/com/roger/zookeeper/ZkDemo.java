package com.roger.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.ArrayList;
import java.util.List;

public class ZkDemo {
    private static final String connectString = "roger5:2181,roger6:2181,roger7:2181";
    private static final int sessionTimeout = 2000;
    private ZooKeeper zkClient;

    public ZkDemo() {
        init();
    }

    public void init() {
        try {
            zkClient = new ZooKeeper(connectString, sessionTimeout, event -> {
                //打印事件的一些信息
                System.out.println(event.getType() + "-----" + event.getState() + "-----" + event.getPath());
                try {
                    zkClient.getChildren("/", true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建持久节点
     *
     * @param name 节点名称
     * @param data 节点内容
     */
    public void createNode(String name, String data){
        try {
            Stat stat = zkClient.exists(name, true);
            if (stat != null) {
                zkClient.delete(name, stat.getVersion());
            }
            zkClient.create(name, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 节点是否存在
     *
     * @param path 节点路径
     * @return 节点是否存在
     */
    public boolean existNode(String path) {
        try {
            return zkClient.exists(path, true) != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取子节点
     *
     * @param path 路劲
     * @return 该路径下的子节点
     */
    public List<String> getChildren(String path) {
        try {
            List<String> children = zkClient.getChildren(path, true);
            children.forEach(System.out::println);
            return children;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
