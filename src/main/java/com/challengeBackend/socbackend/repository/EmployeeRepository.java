package com.challengeBackend.socbackend.repository;

import com.challengeBackend.socbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
