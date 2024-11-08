package com.example.controller;

import com.example.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanScopeController {

    private final SingletonBean singletonBean;
    private final PrototypeBean prototypeBean;
    private final RequestScopedBean requestScopedBean;
    private final SessionScopedBean sessionScopedBean;

    @Autowired
    public BeanScopeController(SingletonBean singletonBean, PrototypeBean prototypeBean,
                               RequestScopedBean requestScopedBean, SessionScopedBean sessionScopedBean
                               ) {
        this.singletonBean = singletonBean;
        this.prototypeBean = prototypeBean;
        this.requestScopedBean = requestScopedBean;
        this.sessionScopedBean = sessionScopedBean;
    }

    @GetMapping("/beans")
    public String getBeanScopes() {
        System.out.println("Accessing /beans endpoint");
        System.out.println("Singleton: " + singletonBean.getMessage());
        System.out.println("Prototype: " + prototypeBean.getMessage());
        System.out.println("Request Scoped: " + requestScopedBean.getMessage());
        System.out.println("Session Scoped: " + sessionScopedBean.getMessage());

        return "Singleton: " + singletonBean.getMessage() + "\n" +
                "Prototype: " + prototypeBean.getMessage() + "\n" +
                "Request Scoped: " + requestScopedBean.getMessage() + "\n" +
                "Session Scoped: " + sessionScopedBean.getMessage() + "\n";
    }
}
