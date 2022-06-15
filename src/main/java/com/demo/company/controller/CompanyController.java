package com.demo.company.controller;

import com.demo.company.entity.Company;
import com.demo.company.repository.CompanyRepository;
import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getById(@PathVariable Integer id) {
        return ResponseEntity.of(companyRepository.findById(id));
    }

    @GetMapping("/company")
    public List<Company> getAll(@RequestParam(required = false) String template) {
        return StringUtils.isNotEmpty(template)
                ? companyRepository.findByTemplate(template)
                : companyRepository.findAll();
    }
}
