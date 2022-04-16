package com.roger.zookeeper;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ZkTest {

    private final ZkDemo zkDemo = new ZkDemo();

    @Test
    public void testCreate(){
        zkDemo.createNode("/test", "test data");
        Assert.assertTrue(zkDemo.existNode("/test"));
    }

    @Test
    public void testChildren() {
        List<String> children = zkDemo.getChildren("/");
        Assert.assertTrue(children.size() != 0);
    }
}
