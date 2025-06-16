package com.abhishek.hibernatemapping02.repository;

import com.abhishek.hibernatemapping02.entity.Employees;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    List<Employees> findByCompanyId(Long companyId);
}
