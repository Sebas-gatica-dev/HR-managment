package com.sgdev.rh_api.controllers;

import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sgdev.rh_api.exceptions.ResourceNotFoundException;
import com.sgdev.rh_api.models.Employee;
import com.sgdev.rh_api.service.IEmployeeService;

@RestController
@RequestMapping("rh-api")
@CrossOrigin(value = "http://localhost:5173")
public class EmployeeController {

    private static final Logger logger = 
        LoggerFactory.getLogger(EmployeeController.class);


        @Autowired
        private IEmployeeService employeeService;

        @GetMapping("/employees")
        public Iterable<Employee> getEmployees() {
            var employees =  employeeService.listEmpleoyees();
            employees.forEach((employee -> logger.info(employee.toString())));
            return employees;
        }


        @PostMapping("/employees")
        public Employee saveEmployee(@RequestBody Employee employee) {
            logger.info("Saving employee: " + employee.toString());
            return employeeService.saveEmployee(employee);
        }



        @GetMapping("/employees/{id}")
        public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){

            Employee employee = employeeService.getByIdEmployee(id);
            if(employee == null){
               throw new ResourceNotFoundException("Employee with id " + id + " not found");
            }else{
                return ResponseEntity.ok(employee);   
            } 
            
        }


        @PutMapping("/employees/{id}")
        public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee){

            Employee employeeToUpdate = employeeService.getByIdEmployee(id);
            if(employeeToUpdate == null){
                throw new ResourceNotFoundException("Employee with id " + id + " not found");
            }else{

                employeeToUpdate.setName(employee.getName());
                employeeToUpdate.setDepartament(employee.getDepartament());
                employeeToUpdate.setSalary(employee.getSalary());
                employeeService.saveEmployee(employeeToUpdate);
                return ResponseEntity.ok(employeeToUpdate);
            }     
        }



        @DeleteMapping("/employees/{id}")
        public ResponseEntity<Map<String, Boolean>>
        deleteEmployee(@PathVariable Integer id){
            Employee employee = employeeService.getByIdEmployee(id);
            if(employee == null){
                throw new ResourceNotFoundException("Employee with id " + id + " not found");
            }else{
                employeeService.deleteEmployee(id);
                //Json {"eliminado": true}
                Map<String, Boolean> response = new HashMap<>();
                response.put("deleted", Boolean.TRUE);
                return ResponseEntity.ok(response);
            }
        }


}
