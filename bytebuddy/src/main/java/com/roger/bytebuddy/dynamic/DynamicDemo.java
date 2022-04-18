package com.roger.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;


public class Demo {

    public String hello() throws IllegalAccessException, InstantiationException {
        // 动态创建子类对象，还没被加载到JVM里面
        DynamicType.Unloaded<Object> object = new ByteBuddy()
                .subclass(Object.class) //动态创建的类是继承Object类的
                .method(ElementMatchers.isToString()) //监控的方法
                .intercept(FixedValue.value("Say Hello")) //拦截处理
                .make(); //创建对象

        // 使用类加载器加载将类加载到JVM里面
        DynamicType.Loaded<Object> loaded = object.load(getClass().getClassLoader());
        // 获取并打印类的信息
        Class<?> clazz = loaded.getLoaded();
        System.out.println(clazz + "-----" + clazz.getClassLoader());
        return clazz.newInstance().toString();
    }

    public String simpleHello() throws IllegalAccessException, InstantiationException {
        return new ByteBuddy().subclass(Object.class)
                .method(ElementMatchers.isToString())
                .intercept(FixedValue.value("simple hello"))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance()
                .toString();
    }
}
