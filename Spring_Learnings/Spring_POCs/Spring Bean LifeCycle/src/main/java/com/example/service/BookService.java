//package com.example.service;
//
//import com.example.entity.Book;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BookService {
//
//    private final Book book;
//
//    @Autowired
//    public BookService(Book book) {
//        this.book = book;
//    }
//
//    public void printBookDetails() {
//        book.displayInfo();
//    }
//}

package com.example.service;

public class BookService {
    public BookService() {
        System.out.println("BookService: Bean is being created.");
    }

    public void init() {
        System.out.println("BookService: Custom init method called.");
    }

    public void destroy() {
        System.out.println("BookService: Custom destroy method called.");
    }

    public void getBook() {
        System.out.println("Fetching book details...");
    }
}
