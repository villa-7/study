package com.roger.spring.annotation;

import com.roger.spring.aop.MathCalculator;
import com.roger.spring.aop.config.AopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAop {

    @Test
    public void testAop() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);

        // 不要自己创建这个对象
        // MathCalculator mathCalculator = new MathCalculator();
        // mathCalculator.div(1, 1);

        // 我们要使用Spring容器中的组件
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1, 1);

        // 关闭容器
        applicationContext.close();
    }
}
