package com.sgdev.rh_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgdev.rh_api.models.Employee;
import com.sgdev.rh_api.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService{

     @Autowired 
     private EmployeeRepository employeeRepository; 



 
    @Override
    public Employee getByIdEmployee(Integer id) {
       
        Employee employee = employeeRepository.findById(id).orElse(null);
        return employee;

    }

    @Override
    public List<Employee> listEmpleoyees() {
        
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
       employeeRepository.deleteById(id);
        
    }


}
