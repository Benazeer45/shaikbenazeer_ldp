package com.lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Employee {
    private Long id;

    @NonNull // Lombok will generate a NullPointerException if this field is set to null.
    private String name;

    private String department;
    private double salary;
    private String email;

    // Lombok provides a constructor without 'id' (using @NoArgsConstructor and @AllArgsConstructor)
    // Lombok's @Builder annotation allows for a builder pattern implementation
    // Lombok's @EqualsAndHashCode generates equals() and hashCode() methods
}
