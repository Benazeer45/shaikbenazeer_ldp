//package com.example;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class BookApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(BookApplication.class, args);
//    }
//}


package com.example;

import com.example.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring context from the XML configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.getBook();

        // Close the context to trigger the destroy method
        context.close();
    }
}

