//package com.example.springdemo.springcruddemo.service;
//
////import com.example.springdemo.springcruddemo.dao.EmployeeDao;
//import com.example.springdemo.springcruddemo.dao.EmployeeRepository;
//import com.example.springdemo.springcruddemo.entity.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService{
////    private final EmployeeDao employeeDao;
////
////    @Autowired
////    public EmployeeServiceImpl(@Qualifier("employeeDaoJpaImpl") EmployeeDao employeeDao) {
////        this.employeeDao = employeeDao;
////    }
//
//    //using jpa repository
//    private final EmployeeRepository employeeRepository;
//
//    @Autowired
//    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//
//
//    @Override
////    @Transactional - we can remive because jpa provides this funcitonality
//    public List<Employee> findAll() {
//        return employeeRepository.findAll();
//    }
//
//    @Override
////    @Transactional
//    public Employee findById(int employeeId) {
//        Optional<Employee> result=employeeRepository.findById(employeeId);
//        Employee theEmployee=null;
//        if (result.isPresent()){
//            theEmployee=result.get();
//        }
//        else{
//            throw new RuntimeException("Didnt find employee id - "+employeeId);
//        }
//        return theEmployee;
//
////        return employeeRepository.findById(employeeId);
//    }
//
//    @Override
////    @Transactional
//    public void save(Employee theEmployee) {
//        employeeRepository.save(theEmployee);
//    }
//
//    @Override
////    @Transactional
//    public void deleteById(int employeeId) {
//        employeeRepository.deleteById(employeeId);
//    }
//}
