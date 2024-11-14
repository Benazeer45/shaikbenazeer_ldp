package org.example.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.aopdemo.Account;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {

    @Before("org.example.aopdemo.aspect.MyAopExpressions.forDaoPakcageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\nExecuting @Before advice on addAccount()");


        //join points
        //display method signayture
        MethodSignature methodSig=(MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: "+methodSig);

        //display method arguments
        Object[] args=theJoinPoint.getArgs();
        for(Object tempArg:args){
            System.out.println(tempArg);
            if (tempArg instanceof Account){
                Account theAccount=(Account) tempArg;
                System.out.println("Account Name: "+theAccount.getName());
                System.out.println("Account Level: "+theAccount.getLevel());
            }
        }
    }
}
