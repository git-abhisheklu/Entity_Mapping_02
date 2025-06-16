package com.abhishek.hibernatemapping02.service;

import com.abhishek.hibernatemapping02.entity.Company;
import com.abhishek.hibernatemapping02.entity.Employees;
import com.abhishek.hibernatemapping02.repository.CompanyRepository;
import com.abhishek.hibernatemapping02.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeesRepository employeesRepository;

    public Company addCompany(Company company)
    {
        return companyRepository.save(company);
    }

    public Company getCompanyById( Long id)
    {
        return companyRepository.findById(id).orElseThrow(()->new RuntimeException("Company not found with "+ id));
    }

    public List<Company> getCompany()
    {
        return companyRepository.findAll();
    }

    public Company updateCompanyDetails( Long id, Company updated)
    {
        Company company = companyRepository.findById(id).orElseThrow(()-> new RuntimeException("Company not found with "+ id));
        company.setName(updated.getName());
        company.setIndustry(updated.getIndustry());
        company.setLocation(updated.getLocation());
        company.setFoundedDate(updated.getFoundedDate());
        return companyRepository.save(company);
    }

    public void deleteCompanyById(Long id)
    {
        companyRepository.deleteById(id);
    }

    public List<Employees> getEmployeesByCompanyId(Long id)
    {
        Company company=getCompanyById(id);
        return company.getEmployees();
    }

    public Employees addEmployeeByCompany(Long id, Employees employees)
    {
        Company company=getCompanyById(id);
        employees.setCompany(company);
        return employeesRepository.save(employees);
    }

}
