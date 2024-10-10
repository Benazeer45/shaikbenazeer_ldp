package Java_Assignments.Assignment12;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentManagement {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8),
                new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2),
                new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3),
                new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80),
                new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70),
                new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70),
                new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70),
                new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80),
                new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85),
                new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82),
                new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83),
                new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4),
                new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6),
                new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8),
                new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4),
                new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4),
                new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5)
        );

        // 1. Print the name of all departments in the college
        System.out.println("Departments:");
        students.stream()
                .map(Student::getEngDepartment)
                .distinct()
                .forEach(System.out::println);

        // 2. Get the names of all students who have enrolled after 2018
        System.out.println("\nStudents enrolled after 2018:");
        students.stream()
                .filter(student -> student.getYearOfEnrollment() > 2018)
                .map(Student::getName)
                .forEach(System.out::println);

        // 3. Get the details of all male students in the Computer Science department
        System.out.println("\nMale students in Computer Science:");
        students.stream()
                .filter(student -> student.getGender().equals("Male"))
                .filter(student -> student.getEngDepartment().equals("Computer Science"))
                .map(Student::getDetails)
                .forEach(System.out::println);

        // 4. Count the number of male and female students
        System.out.println("\nCount of male and female students:");
        Map<String, Long> genderCount = students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        genderCount.forEach((gender, count) -> System.out.println(gender + ": " + count));

        // 5. Average age of male and female students
        System.out.println("\nAverage age of male and female students:");
        Map<String, Double> averageAge = students.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        averageAge.forEach((gender, avg) -> System.out.println(gender + ": " + avg));

        // 6. Details of student with highest percentage
        System.out.println("\nStudent with highest percentage:");
        students.stream()
                .max(Comparator.comparingDouble(Student::getPerTillDate))
                .ifPresent(student -> System.out.println(student.getDetails()));

        // 7. Count the number of students in each department
        System.out.println("\nNumber of students in each department:");
        Map<String, Long> departmentCount = students.stream()
                .collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.counting()));
        departmentCount.forEach((department, count) -> System.out.println(department + ": " + count));

        // 8. Average percentage achieved in each department
        System.out.println("\nAverage percentage in each department:");
        Map<String, Double> averagePercentage = students.stream()
                .collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.averagingDouble(Student::getPerTillDate)));
        averagePercentage.forEach((department, avg) -> System.out.println(department + ": " + avg));

        // 9. Youngest male student in the Electronic department
        System.out.println("\nYoungest male student in Electronic department:");
        students.stream()
                .filter(student -> student.getGender().equals("Male"))
                .filter(student -> student.getEngDepartment().equals("Electronic"))
                .min(Comparator.comparingInt(Student::getAge))
                .ifPresent(student -> System.out.println(student.getDetails()));

        // 10. Count of male and female students in the Computer Science department
        System.out.println("\nCount of male and female students in Computer Science department:");
        Map<String, Long> csGenderCount = students.stream()
                .filter(student -> student.getEngDepartment().equals("Computer Science"))
                .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        csGenderCount.forEach((gender, count) -> System.out.println(gender + ": " + count));
    }
}
