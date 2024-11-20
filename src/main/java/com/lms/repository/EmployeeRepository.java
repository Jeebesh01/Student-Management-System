package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
