package com.abhishek.hibernatemapping02.controller;

import com.abhishek.hibernatemapping02.entity.Company;
import com.abhishek.hibernatemapping02.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.addCompany(company));
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAll() {
        return ResponseEntity.ok(companyService.getCompany());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getCompanyById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@PathVariable Long id, @RequestBody Company company) {
        return ResponseEntity.ok(companyService.updateCompanyDetails(id,company));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
        return ResponseEntity.noContent().build();
    }
}