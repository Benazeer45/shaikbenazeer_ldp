package org.example;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<EmployeeDTO> {
    @Override
    public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setDepartment(rs.getString("department"));
        return employee;
    }
}