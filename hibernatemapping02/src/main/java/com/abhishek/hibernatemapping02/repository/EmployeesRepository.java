package com.abhishek.hibernatemapping02.repository;

import com.abhishek.hibernatemapping02.entity.Employees;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

}
