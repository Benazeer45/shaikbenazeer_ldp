package org.example.aopdemo.dao;

import org.example.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    //add new method of after returning advice
    public List<Account> findAccounts(){
        List<Account> myAccounts=new ArrayList<>();

        Account temp1=new Account("John","Silver");
        Account temp2=new Account("Doe","Gold");
        Account temp3=new Account("Benny","Platinum");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);
        return myAccounts;
    }

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    // New method for checking match on package
    public boolean doWork() {
        System.out.println(getClass() + " Do Work Properly");
        return false;
    }

    // Getter for name
    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    // Setter for name
    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    // Getter for serviceCode
    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    // Setter for serviceCode
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
