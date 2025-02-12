package com.sgdev.rh_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgdev.rh_api.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
