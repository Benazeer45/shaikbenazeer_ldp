package Java_Assignments.Lambdas_Streams.JavaStreamBasics;


public class Employee {
    int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void salaryIncrement(double percentage) {
        this.salary += this.salary * percentage / 100;
    }

    @Override
    public String toString() {
        return name + " - " + salary;
    }


}

