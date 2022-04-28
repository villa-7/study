package com.roger.bytebuddy.dynamic.method;

import net.bytebuddy.implementation.bind.annotation.Super;

public class DelegateMooWithSuper {

    public static String Moo1(String param, @Super Moo moo) {
        System.out.println("invoke time:" + System.currentTimeMillis());
        return moo.Moo1(param);
    }
}
