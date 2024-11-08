package com.firstExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoDemoApp {
    public static void main(String[] args) {
        // Load Spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");

        // Retrieve the bean from Spring container
        Coach myCoach = context.getBean("tennisCoach", Coach.class);

        // Call method on the bean
        System.out.println(myCoach.getDailyWorkout());
        System.out.println(myCoach.getDailyFortune());

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
    }
}
