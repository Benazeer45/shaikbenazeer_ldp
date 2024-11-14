package org.example.aopdemo.aspect;

import ch.qos.logback.core.joran.conditional.ThenAction;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.aopdemo.Account;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {
    @After("execution(* org.example.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("\nExecuting afterFinally() on method:"+ method);
    }

    @AfterThrowing(pointcut = "execution(* org.example.aopdemo.dao.AccountDAO.findAccounts(..))",throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc){
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("\nExecuting after throwing on method:"+ method);
        System.out.println("Caught exception is: "+theExc);
    }

    //add new advice for @AfterReturning on findAccounts method
    @AfterReturning(pointcut = "execution(* org.example.aopdemo.dao.AccountDAO.findAccounts(..))",returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("\nExecuting AfterReturning Advice on method: "+method);
        System.out.println("\nResult is: "+result);

        //lets post-process the data-convert details to uppercase
        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account tempAccount:result){
            String theUpperName=tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }

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
