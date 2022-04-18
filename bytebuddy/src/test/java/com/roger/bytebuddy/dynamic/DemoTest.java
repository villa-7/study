package com.roger.bytebuddy.dynamic;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class DemoTest {

    private final DynamicDemo demo = new DynamicDemo();

    @Test
    public void testHello() throws InstantiationException, IllegalAccessException {
        Assert.assertEquals("Say Hello", demo.hello());
        Assert.assertEquals("simple hello", demo.simpleHello());
    }

    @Test
    public void testDelegating() throws InstantiationException, IllegalAccessException {
        String result = demo.delegating();
        Assert.assertEquals("Hello in Bar!", result);
    }

    @Test
    public void testSave() throws Exception {
        demo.createWithName();
        demo.createWithNameAndMethod();
    }
}
