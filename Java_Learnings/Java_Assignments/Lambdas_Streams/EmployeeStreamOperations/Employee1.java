package Java_Assignments.Lambdas_Streams.EmployeeStreamOperations;

public class Employee1 {
    private int id;
    private String name;
    private double salary;

    public Employee1(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public double getSalary() {
        return salary;
    }

    // Method to increment salary
    public void salaryIncrement(double increment) {
        this.salary += increment;
    }
    @Override
    public String toString() {
        return "Employee1{id=" + id + ", name='" + name + '\'' + ", salary=" + salary + '}';
    }
}

