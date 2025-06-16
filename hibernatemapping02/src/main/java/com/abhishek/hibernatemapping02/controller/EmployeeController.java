package com.abhishek.hibernatemapping02.controller;

import com.abhishek.hibernatemapping02.entity.Employees;
import com.abhishek.hibernatemapping02.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/company/{companyId}")
    public ResponseEntity<Employees> create(@PathVariable Long companyId, @RequestBody Employees employee) {
        return ResponseEntity.ok(employeeService.createEmployee(companyId, employee));
    }

    @GetMapping
    public ResponseEntity<List<Employees>> getAll() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<Employees>> getByCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(employeeService.getEmployeesByCompanyId(companyId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employees> update(@PathVariable Long id, @RequestBody Employees employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
