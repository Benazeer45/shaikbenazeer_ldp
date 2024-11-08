//
//package org.example;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class EmployeeRepository {
//    private final JdbcTemplate jdbcTemplate;
//
//    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<EmployeeDTO> findAll() {
//        String sql = "SELECT * FROM employees"; // Change 'employees' to your table name
//        return jdbcTemplate.query(sql, new EmployeeRowMapper());
//    }
//
//    public EmployeeDTO findById(int id) {
//        String sql = "SELECT * FROM employees WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
//    }
//
//    public void save(EmployeeDTO employee) {
//        String sql = "INSERT INTO employees (name, department) VALUES (?, ?)";
//        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment());
//    }
//
//    public void update(EmployeeDTO employee) {
//        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
//        jdbcTemplate.update(sql, employee.getName(), employee.getDepartment(), employee.getId());
//    }
//
//    public void delete(int id) {
//        String sql = "DELETE FROM employees WHERE id = ?";
//        jdbcTemplate.update(sql, id);
//    }
//}
