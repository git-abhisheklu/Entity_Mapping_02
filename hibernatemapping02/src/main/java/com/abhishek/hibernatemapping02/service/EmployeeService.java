package com.abhishek.hibernatemapping02.service;

import com.abhishek.hibernatemapping02.entity.Company;
import com.abhishek.hibernatemapping02.entity.Employees;
import com.abhishek.hibernatemapping02.repository.CompanyRepository;
import com.abhishek.hibernatemapping02.repository.EmployeesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeesRepository employeeRepository;
    private final CompanyRepository companyRepository;

    public Employees createEmployee(Long companyId, Employees employee) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + companyId));
        employee.setCompany(company);
        return employeeRepository.save(employee);
    }

    public List<Employees> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employees> getEmployeesByCompanyId(Long companyId) {
        return employeeRepository.findByCompanyId(companyId);
    }

    public Employees updateEmployee(Long id, Employees updated) {
        Employees emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        emp.setName(updated.getName());
        emp.setPosition(updated.getPosition());
        return employeeRepository.save(emp);
    }

    public void deleteEmployee(Long id) {
        Employees emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        employeeRepository.delete(emp);
    }
}
