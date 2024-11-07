package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClass {
    private static final Logger logger = LoggerFactory.getLogger(MyClass.class);

    public void myMethod() {
        logger.trace("This is a trace message - useful for debugging");
        logger.debug("This is a debug message - more detailed than info");

        logger.info("This is an info message - general information about program execution");

        boolean condition = true;
        if (condition) {
            logger.warn("This is a warning message - something unexpected happened, but it's not critical");
        }

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("This is an error message - an exception occurred: {}", e.getMessage());
        }

        logger.info("Finished executing myMethod");
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }
}
