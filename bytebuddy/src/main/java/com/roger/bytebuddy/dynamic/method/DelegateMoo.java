package com.roger.bytebuddy.dynamic.method;

public class DelegateMoo {
    public static String Moo(String param1, Integer param2) {
        return "my name is " + param1 + ",my age is " + param2;
    }

    public static String Moo1(String param1) {
        return "my name is " + param1;
    }
}