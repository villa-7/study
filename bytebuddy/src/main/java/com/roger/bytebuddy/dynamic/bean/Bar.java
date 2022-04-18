package com.roger.bytebuddy.dynamic.bean;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;

public class Bar {

    /**
     * 当委托类中存在多个相似方法时，可以通过@BindingPriority注解设置优先级
     */
    @BindingPriority(3)
    public static String sayHelloBar() {
        return "Hello in Bar!";
    }

    @BindingPriority(2)
    public static String sayBar() {
        return "bar";
    }
}
