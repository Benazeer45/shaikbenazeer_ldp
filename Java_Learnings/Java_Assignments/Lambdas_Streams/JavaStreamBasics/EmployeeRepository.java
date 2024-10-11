package Java_Assignments.Lambdas_Streams.JavaStreamBasics;

import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository {
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public EmployeeRepository() {
        // Sample employees
        employeeMap.put(1, new Employee(1, "Bill Gates", 200000.0));
        employeeMap.put(2, new Employee(2, "Jeff Bezos", 250000.0));
        employeeMap.put(3, new Employee(3, "Mark Zuckerberg", 300000.0));
    }

    public Employee findById(Integer id) {
        return employeeMap.get(id);
    }
}

