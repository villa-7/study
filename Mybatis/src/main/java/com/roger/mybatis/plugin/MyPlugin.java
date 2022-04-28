package com.roger.mybatis.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Enumeration;
import java.util.Properties;

@Intercepts(
        @Signature(type = StatementHandler.class, method = "parameterize", args = Statement.class)
)
public class MyPlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 执行目标方法
        System.out.println("intercept");
        Object proceed = invocation.proceed();
        // 返回执行后的返回值
        return  proceed;
    }

    @Override
    public Object plugin(Object target) {
        /**
         * Mybatis提供Plugin来为target包装成一个代理对象
         */
        System.out.println("plugin "+target);
        Object wrap = Plugin.wrap(target, this);
        System.out.println(wrap.toString());
        return wrap;
    }

    @Override
    public void setProperties(Properties properties) {
        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            System.out.println(key + ":" + properties.get(key));
        }
    }
}
