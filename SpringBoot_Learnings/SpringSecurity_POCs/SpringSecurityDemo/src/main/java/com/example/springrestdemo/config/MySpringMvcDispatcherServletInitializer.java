package com.example.springrestdemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // No root-level configurations are required for this example
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { DemoAppConfig.class }; // Register servlet configuration class
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" }; // Map all requests to the DispatcherServlet
    }
}