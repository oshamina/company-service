package com.demo.company.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Организация
 */
@Entity
@Table(name = "companies")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Company {

    /**
     * ID
     */
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    /**
     * Полное наименование
     */
    private String fullName;

    /**
     * Краткое наименование
     */
    private String shortName;

    /**
     * ИНН
     */
    private String inn;

    /**
     * ОГРН
     */
    private String ogrn;

    /**
     * Почтовый адрес
     */
    private String postalAddress;

    /**
     * Юридический адрес
     */
    private String legalAddress;

    /**
     * Генеральный директор
     */
    @ManyToOne
    @JoinColumn
    private Person generalDirector;

    /**
     * Филиалы
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "head_company_id")
    List<Company> branches = new ArrayList<>();
}
