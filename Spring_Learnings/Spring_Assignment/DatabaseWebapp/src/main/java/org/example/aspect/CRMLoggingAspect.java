package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // Pointcut for the Controller package
    @Pointcut("execution(* org.example.Controller.*.*(..))")
    private void forControllerPackage() {}

    // Pointcut for the Service package
    @Pointcut("execution(* org.example.Service.*.*(..))")
    private void forServicePackage() {}

    // Pointcut for the DAO package
    @Pointcut("execution(* org.example.Dao.*.*(..))")
    private void forDaoPackage() {}

    // Combining the pointcuts
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    // Before advice using the combined pointcut
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {
        // Display the method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("======> in @Before: Calling Method: " + theMethod);

        // Display the arguments to the method
        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg : args) {
            myLogger.info("======> argument: " + tempArg);
        }
    }

    // AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint theJoinPoint, Object result) {
        // Display the method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("======> in @AfterReturning: from method: " + theMethod);

        // Display data returned
        myLogger.info("======> result: " + result);
    }
}
