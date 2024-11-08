package com.firstExample;

import com.firstExample.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    //defualt constructor
    public TennisCoach(){
        System.out.println("TennisCoach inside default constructor");
    }

    //define init method
    @PostConstruct
    public void doMyStartUpStuff(){
        System.out.println("Tennis coach inside of doMyStartUpStuff() method");
    }

    //define destroy method
    @PreDestroy
    public void doMyCkeaUpStuff(){
        System.out.println("Tennis coach inside of doMyCleanUpStuff() method");
    }


//    // setter Injection- we can call it by using any method name(Method Injection)
//    @Autowired
//    public void setFortuneService(FortuneService fortuneService){
//        System.out.println("TennisCoach inside setFortuneService() Method");
//        this.fortuneService = fortuneService;
//    }

//    // Constructor injection
//    @Autowired
//    public TennisCoach(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand for 30 minutes.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();  // Getting fortune from injected service
    }
}
