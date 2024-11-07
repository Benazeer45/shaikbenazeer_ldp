package com.firstExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoBeanScopeApp {
    public static void main(String[] args) {
        // Load Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");

        // Retrieve the bean from Spring container
        Coach myCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        //check if they are saem
        boolean result = (myCoach == alphaCoach);

        //printing the results
        System.out.println("Pointing to the same object " + result);
        System.out.println(("Memory location of myCoach " + myCoach));
        System.out.println(("Memory location of alphaCoach " + alphaCoach));

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
