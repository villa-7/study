package com.roger.spring.aop;

import org.aspectj.lang.annotation.*;

/**
 * @Aspect: 标注这是一个切面类
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(public int com.roger.spring.aop.MathCalculator.*(..))")
    public void pointCut() {}

    @Before("pointCut()")
    public void logStart() {
        System.out.println("除法运行......@Before，参数列表是：{}");
    }

    // 在目标方法（即div方法）结束时被调用
    @After("pointCut()")
    public void logEnd() {
        System.out.println("除法结束......@After");
    }

    // 在目标方法（即div方法）正常返回了，有返回值，被调用
    @AfterReturning("pointCut()")
    public void logReturn() {
        System.out.println("除法正常返回......@AfterReturning，运行结果是：{}");
    }

    // 在目标方法（即div方法）出现异常，被调用
    @AfterThrowing("pointCut()")
    public void logException() {
        System.out.println("除法出现异常......异常信息：{}");
    }
}
