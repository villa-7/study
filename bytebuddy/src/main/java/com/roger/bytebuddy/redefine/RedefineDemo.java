package com.roger.bytebuddy.redefine;

import com.roger.bytebuddy.dynamic.bean.Foo;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static net.bytebuddy.matcher.ElementMatchers.*;

public class RedefineDemo {

    public String redefineUser() throws Exception {
        ByteBuddyAgent.install();
        User instance = new ByteBuddy()
                .redefine(User.class)
                //不能定义新方法，会报错class redefinition failed: attempted to add a method
//                .defineMethod("helloName", String.class, Modifier.PUBLIC)
//                .withParameters(String.class)
//                .intercept(FixedValue.argument(0))
                .method(named("sayHello"))
                .intercept(FixedValue.value("redefine hello"))
                .make()
                .load(Foo.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent())
                .getLoaded()
                .newInstance();
//        Method method = instance.getClass().getMethod("helloName", String.class);
//        System.out.println(method.invoke(instance));
        User user = new User();
        return user.sayHello();
    }
}
