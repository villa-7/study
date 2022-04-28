package com.roger.bytebuddy.redefine;

import org.junit.Assert;
import org.junit.Test;

public class RedefineDemoTest {

    private final RedefineDemo demo = new RedefineDemo();

    @Test
    public void testRedefineUser() throws Exception {
        Assert.assertEquals("redefine hello", demo.redefineUser());
    }
}
