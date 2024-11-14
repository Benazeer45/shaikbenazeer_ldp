package org.example.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

    // Around advice for getFortune() method
    @Around("execution(* org.example.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("Executing around on method: " + method);

        long begin = System.currentTimeMillis();

        Object result = null;
        try {
            // Proceed with the method execution
            result = theProceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("Exception in method: " + method);
            System.out.println("Message: " + e.getMessage());
            // Handle the exception as needed, or rethrow it
            throw e;  // Optionally rethrow the exception after logging
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("\n==== Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    // After advice for the findAccounts method
    @After("execution(* org.example.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\nExecuting afterFinally() on method:" + method);
    }

    // After throwing advice for findAccounts method
    @AfterThrowing(pointcut = "execution(* org.example.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\nExecuting after throwing on method:" + method);
        System.out.println("Caught exception is: " + theExc);
    }

    // After returning advice for findAccounts method
    @AfterReturning(pointcut = "execution(* org.example.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\nExecuting AfterReturning Advice on method: " + method);
        System.out.println("\nResult is: " + result);

        // Post-process the data - convert account names to uppercase
        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account tempAccount : result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }

    // Before advice for the addAccount() method using pointcut expression
    @Before("org.example.aopdemo.aspect.MyAopExpressions.forDaoPakcageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\nExecuting @Before advice on addAccount()");

        // Display method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSig);

        // Display method arguments
        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg : args) {
            System.out.println(tempArg);
            if (tempArg instanceof Account) {
                Account theAccount = (Account) tempArg;
                System.out.println("Account Name: " + theAccount.getName());
                System.out.println("Account Level: " + theAccount.getLevel());
            }
        }
    }
}
