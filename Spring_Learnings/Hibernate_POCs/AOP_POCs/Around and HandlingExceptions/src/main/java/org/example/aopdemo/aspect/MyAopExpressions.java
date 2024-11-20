package org.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAopExpressions {
    @Pointcut("execution(* org.example.aopdemo.dao.*.*(..))")
    public void forDaoPackage() { }

    //create pointcut for getter and setter methods
    @Pointcut("execution(* org.example.aopdemo.dao.*.get*(..))")
    public void getter() { }

    @Pointcut("execution(* org.example.aopdemo.dao.*.set*(..))")
    public void setter() { }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPakcageNoGetterSetter() {}
}
