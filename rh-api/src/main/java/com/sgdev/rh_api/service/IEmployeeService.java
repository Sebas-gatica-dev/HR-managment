package com.sgdev.rh_api.service;

import java.util.List;

import com.sgdev.rh_api.models.Employee;

public interface IEmployeeService {

public List<Employee> listEmpleoyees();

public Employee getByIdEmployee(Integer id);

public Employee saveEmployee(Employee employee);

public Employee updateEmployee(Employee employee);

public void deleteEmployee(Integer id);

}
