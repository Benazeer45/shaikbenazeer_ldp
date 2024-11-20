package org.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyDemoLoggingAspect {

//    @Before("execution(public void addAccount())")
//    @Before("execution(public void org.example.aopdemo.dao.AccountDAO.addAccount())") // this will match accountdao class only
//    @Before("execution(public void add*()") //match method starting with "add" in any class
//    @Before("execution(public void updateAccount())")- it will not call this because of mismatch
//  @Before("execution(void addAccount())")     //will match method name with void return type
//    @Before("execution(* addAccount())")     //will match method name with any return type
//    @Before("execution(* add*(org.example.aopdemo.Account))")     //will match method with account and its param- must use fully qualified name
//    @Before("execution(* add*(org.example.aopdemo.Account, ..))")     //will match method name with any no of params
//    @Before("execution(* add*( ..))")     //will match on any paramet in any method
//    @Before("execution(* org.example.aopdemo.dao.*.*(..))")     //will match on any paramet in any method
//
//    public void beforeAddAccountAdvice(){
//        System.out.println("\nExecuting @Before advice on addAccount()");
//    }

    // pointcut declaraitons-for all
    @Pointcut("execution(* org.example.aopdemo.dao.*.*(..))")
    private void forDaoPackage() { }

    //create pointcut for getter and setter methods
    @Pointcut("execution(* org.example.aopdemo.dao.*.get*(..))")
    private void getter() { }

    @Pointcut("execution(* org.example.aopdemo.dao.*.set*(..))")
    private void setter() { }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPakcageNoGetterSetter() {}

    @Before("forDaoPakcageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\nExecuting @Before advice on addAccount()");
    }

    @Before("forDaoPakcageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n Performing API Analytics");
    }
}
