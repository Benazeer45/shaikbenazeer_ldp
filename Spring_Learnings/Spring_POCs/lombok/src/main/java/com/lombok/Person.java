package com.lombok;

import lombok.*;

@Data
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private String email;

}
