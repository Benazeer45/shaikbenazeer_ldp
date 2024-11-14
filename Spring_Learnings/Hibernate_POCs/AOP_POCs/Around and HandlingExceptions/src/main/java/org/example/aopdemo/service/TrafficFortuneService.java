package org.example.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune() {
        try {
            // Simulating a long-running process (e.g., calling an external API)
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Expect heavy traffic this morning";
    }

    public String getFortune(boolean tripWire) {
        if(tripWire){
            throw new RuntimeException("Major Accident ...Highway is closed");
        }
        return getFortune();
    }
}
