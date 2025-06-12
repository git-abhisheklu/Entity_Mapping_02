package com.abhishek.hibernatemapping02.service;

import com.abhishek.hibernatemapping02.entity.Company;
import com.abhishek.hibernatemapping02.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Company addCompany(Company company)
    {
        return companyRepository.save(company);
    }

    public Optional<Company> getCompanyById( Long id)
    {
        return companyRepository.findById(id);
    }

    public List<Company> getCompany()
    {
        return companyRepository.findAll();
    }

    public

}
