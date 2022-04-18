package com.roger.bytebuddy.dynamic;

import com.roger.bytebuddy.dynamic.bean.Bar;
import com.roger.bytebuddy.dynamic.bean.Foo;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static net.bytebuddy.matcher.ElementMatchers.*;

/**
 * 动态创建类示例
 */
public class DynamicDemo {

    /**
     * 分步动态创建类对象
     */
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

    /**
     * 流水线式动态创建类对象
     */
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

    /**
     * 创建一个指定名称的类，并将class文件保存到指定目录
     */
    public void createWithName() throws IOException {
        new ByteBuddy()
                .subclass(Foo.class)
                .name("com.roger.bytebuddy.DynamicFooImpl")
                .make()
                .saveIn(new File("C:\\Users\\DELL\\Desktop\\byte"));
    }

    /**
     * 创建一个指定名称的类，该子类中定义了一个sayHello(String param)的方法,方法的返回值就是参数值
     * 并将class文件保存到指定目录
     */
    public void createWithNameAndMethod() throws Exception {
        DynamicType.Unloaded<Foo> unloaded = new ByteBuddy()
                .subclass(Foo.class)
                .name("com.roger.bytebuddy.DynamicFooImpl2")
                .defineMethod("sayHello", String.class, Modifier.PUBLIC)
                .withParameters(String.class)
                .intercept(FixedValue.argument(0))
                .make();
        unloaded.saveIn(new File("C:\\Users\\DELL\\Desktop\\byte"));
        Foo instance = unloaded.load(getClass().getClassLoader())
                .getLoaded()
                .newInstance();
        System.out.println(instance.sayHelloFoo());
        Method method = instance.getClass().getDeclaredMethod("sayHello", String.class);
        System.out.println(method.invoke(instance, "dynamic method"));
    }

    /**
     * 方法委托方式
     */
    public String delegating() throws IllegalAccessException, InstantiationException {
        return new ByteBuddy()
                .subclass(Foo.class)
                .method(ElementMatchers.named("sayHelloFoo")
                        .and(isDeclaredBy(Foo.class))
                        .and(returns(String.class)))
                .intercept(MethodDelegation.to(Bar.class))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance()
                .sayHelloFoo();
    }
}
