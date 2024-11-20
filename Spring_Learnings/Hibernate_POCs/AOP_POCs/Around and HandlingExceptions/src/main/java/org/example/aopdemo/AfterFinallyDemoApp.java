package org.example.aopdemo;

import org.example.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
//        List<Account> theAccounts=theAccountDAO.findAccounts(false); --wont throw error
        List<Account> theAccounts=null; //throw an error
        try {
            boolean tripWire=false;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        }catch (Exception e){
            System.out.println("Main Program caught an exception"+e);
        }

        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println(theAccounts);
        context.close();

    }
}
