package com.demo.company.controller;

import com.demo.company.domain.Company;
import com.demo.company.repository.CompanyRepository;
import liquibase.repackaged.org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Класс, предоставляющий REST API для работы с организациями
 */
@RestController
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /**
     * @param id - уникальный идентификатор
     * @return организация по её уникальному идентификатору
     */
    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> getById(@PathVariable UUID id) {
        return ResponseEntity.of(companyRepository.findById(id));
    }

    /**
     * @param template - шаблон для поиска по подстроке
     * @return список организаций, найденных по вхождению без учета регистра в любое из полей шаблона для поиска.
     * Если шаблон для поиска не задан, возвращаются все организации.
     */
    @GetMapping("/companies")
    public List<Company> getAll(@RequestParam(required = false) String template) {
        return StringUtils.isNotEmpty(template)
                ? companyRepository.findByTemplate(template)
                : companyRepository.findAll();
    }
}
