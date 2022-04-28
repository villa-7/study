package com.roger.bytebuddy.dynamic.method;

/**
 * 委托方式测试Bean
 */
public class Moo {
    public String Moo1(String param1) {return "parm1:" + param1;}

    public String Moo(String param1, Integer param2) {return "param1:" + param1 + ",param2:"+ param2;}
}