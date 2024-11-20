package org.example.aopdemo;

import org.example.aopdemo.dao.AccountDAO;
import org.example.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {
        // Load the Spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // Retrieve the bean for TrafficFortuneService
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Main Program: AroundDemoApp");
        System.out.println("Calling getFortune");

        // Call the method, which will be intercepted by the around advice
        String data = theFortuneService.getFortune();
        System.out.println("My Fortune is: " + data);

        System.out.println("Finished...!");

        // Close the context
        context.close();
    }
}

