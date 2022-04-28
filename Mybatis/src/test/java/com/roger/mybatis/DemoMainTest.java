package com.roger.mybatis;

import com.roger.mybatis.bean.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DemoMainTest {

    private final DemoMain demo = new DemoMain();

    @Test
    public void testInsertUser() {
        Assert.assertEquals(1, demo.insertUser());
    }

    @Test
    public void testSelectById() {
        int id = 1;
        User user = demo.selectById(id);
        Assert.assertEquals(1, user.getId());
    }

    @Test
    public void testSelectAll() {
        List<User> users = demo.selectAll();
        System.out.println(users);
        Assert.assertNotNull(users);
    }

    @Test
    public void pageSelect() {
        List<User> users = demo.pageSelect(1, 4);
        users.forEach(System.out::println);
        Assert.assertEquals(4, users.size());
    }
}
