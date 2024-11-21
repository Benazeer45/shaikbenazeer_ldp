package com.example.springboot.thymeleafdemo.service;

import com.example.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.example.springboot.thymeleafdemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
//    private final EmployeeDao employeeDao;
//
//    @Autowired
//    public EmployeeServiceImpl(@Qualifier("employeeDaoJpaImpl") EmployeeDao employeeDao) {
//        this.employeeDao = employeeDao;
//    }

    //using jpa repository
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveOrUpdate(Employee employee) {
        employeeRepository.save(employee); // If the employee ID exists, it will update; if not, it will create a new one
    }

    @Override
//    @Transactional - we can remive because jpa provides this funcitonality
    public List<Employee> findAll() {
        return employeeRepository.findAll();
//        return employeeRepository.findAllByOrderBylastnameAsc();
    }

    @Override
//    @Transactional
    public Employee findById(int employeeId) {
        Optional<Employee> result=employeeRepository.findById(employeeId);
        Employee theEmployee=null;
        if (result.isPresent()){
            theEmployee=result.get();
        }
        else{
            throw new RuntimeException("Didnt find employee id - "+employeeId);
        }
        return theEmployee;

//        return employeeRepository.findById(employeeId);
    }

    @Override
//    @Transactional
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
//    @Transactional
    public void deleteById(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
