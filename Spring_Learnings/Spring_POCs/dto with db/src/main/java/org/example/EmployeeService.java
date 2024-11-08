package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createEmployee(EmployeeDTO employee) {
        String sql = "INSERT INTO employees (name, department) VALUES (?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment());
    }
}
