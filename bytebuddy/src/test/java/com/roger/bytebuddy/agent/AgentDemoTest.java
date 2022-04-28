package com.roger.bytebuddy.agent;

import com.roger.bytebuddy.agent.bean.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AgentDemoTest {

    @Before
    public void before() {
        AgentDemo.install();
    }

    @Test
    public void testAgent() {
        User user = new User();
        Assert.assertEquals("helloTransform", user.sayHello("test"));

        AgentDemo.unInstall();
        User user1 = new User();
        System.out.println(user1.sayHello("test"));
    }
}
