package com.firstExample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigApp {
    public static void main(String[] args) {
        // Load Spring configuration file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

//            ApplicationContext context = new ClassPathXmlApplicationContext("spring-servlet.xml");

        // Retrieve the bean from Spring container
        Coach myCoach = context.getBean("swimCoach", SwimCoach.class);

        // Call method on the bean
        System.out.println(myCoach.getDailyWorkout());
        System.out.println(myCoach.getDailyFortune());

        //call new swim coach class methods ..has props values injected
        System.out.println("Email: "+ ((SwimCoach) myCoach).getEmail());
        System.out.println("Team: "+ ((SwimCoach) myCoach).getTeam());
        
        // Close the context
        context.close();
    }
}
