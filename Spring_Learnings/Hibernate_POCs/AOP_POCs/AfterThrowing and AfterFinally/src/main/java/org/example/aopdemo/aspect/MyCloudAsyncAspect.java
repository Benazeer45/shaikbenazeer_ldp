package org.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudAsyncAspect {

    @Before("org.example.aopdemo.aspect.MyAopExpressions.forDaoPakcageNoGetterSetter()")
    public void logToCloudAsync(){
        System.out.println("\nLogging to cloud in async fashion");
    }
}
