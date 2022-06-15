package com.demo.company.repository;

import com.demo.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("")
    List<Company> findByTemplate(String template);
}
