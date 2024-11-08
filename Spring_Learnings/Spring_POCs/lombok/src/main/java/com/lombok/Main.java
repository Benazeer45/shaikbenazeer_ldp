package com.lombok;

import com.lombok.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", "Doe", "john.doe@example.com");

        System.out.println(person.getFirstName());  // John
        System.out.println(person.getLastName());   // Doe
        System.out.println(person.getEmail());      // john.doe@example.com

        person.setFirstName("Jane");
        person.setLastName("Smith");
        person.setEmail("jane.smith@example.com");

        System.out.println(person);
    }
}
