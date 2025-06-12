package com.abhishek.hibernatemapping02.repository;

import com.abhishek.hibernatemapping02.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
