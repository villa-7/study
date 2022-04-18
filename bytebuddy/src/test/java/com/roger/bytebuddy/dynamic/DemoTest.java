package com.roger.bytebuddy;

import org.junit.Assert;
import org.junit.Test;

public class DemoTest {

    private final Demo demo = new Demo();

    @Test
    public void testHello() throws InstantiationException, IllegalAccessException {
        Assert.assertEquals("Say Hello", demo.hello());
        Assert.assertEquals("simple hello", demo.simpleHello());
    }
}
