package org.example.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public boolean addAccount(){
        System.out.println(getClass()+" Doing stuff: Adding a membership Account");
        return false;
    }

    //adding new method for checking match on package
    public void goToSleep(){
        System.out.println(getClass()+" Iam going to sleep now....!");
    }
}
