package org.example.aopdemo;

import org.example.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundHandlingExcApp {
    public static void main(String[] args) {
        // Load the Spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // Retrieve the bean for TrafficFortuneService
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Main Program: AroundDemoApp");
        System.out.println("Calling getFortune");

        boolean tripWire=true; // this will throw an error becoz it is true
        // Call the method, which will be intercepted by the around advice
//        String data = theFortuneService.getFortune();
        String data = theFortuneService.getFortune(tripWire);
        System.out.println("My Fortune is: " + data);

        System.out.println("Finished...!");

        // Close the context
        context.close();
    }
}

