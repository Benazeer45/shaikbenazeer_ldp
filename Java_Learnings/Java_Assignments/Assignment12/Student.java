package Java_Assignments.Assignment12;

import java.util.Objects;

public class Student {
    public int id;
    public String name;
    public int age;
    public String gender;
    public String engDepartment;
    public int yearOfEnrollment;
    public double perTillDate;

    public Student(int id, String name, int age, String gender, String engDepartment, int yearOfEnrollment, double perTillDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.engDepartment = engDepartment;
        this.yearOfEnrollment = yearOfEnrollment;
        this.perTillDate = perTillDate;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEngDepartment() {
        return engDepartment;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    public double getPerTillDate() {
        return perTillDate;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Age: %d, Gender: %s, Department: %s, Year: %d, Percentage: %.2f",
                id, name, age, gender, engDepartment, yearOfEnrollment, perTillDate);
    }
}
