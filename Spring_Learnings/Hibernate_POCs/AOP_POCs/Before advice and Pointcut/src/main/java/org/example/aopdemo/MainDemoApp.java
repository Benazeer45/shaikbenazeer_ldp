package org.example.aopdemo;

import org.example.aopdemo.dao.AccountDAO;
import org.example.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
        MembershipDAO theMembershipDAO=context.getBean("membershipDAO", MembershipDAO.class);

        Account MyAccount=new Account();

        theAccountDAO.addAccount(MyAccount,true);
        theAccountDAO.doWork();

        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");
        String name=theAccountDAO.getName();
        String code=theAccountDAO.getServiceCode();

        theMembershipDAO.addAccount();
        theMembershipDAO.goToSleep();
//        System.out.println("Lets call it again");
//        theAccountDAO.addAccount();
        context.close();

    }
}
