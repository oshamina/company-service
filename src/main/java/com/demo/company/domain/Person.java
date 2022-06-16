package com.demo.company.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Информация о человеке
 */
@Entity
@Table(name = "persons")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Person {

    /**
     * ID
     */
    @Id
    @EqualsAndHashCode.Include
    private UUID id = UUID.randomUUID();

    /**
     * Фамилия
     */
    private String lastName;

    /**
     * Имя
     */
    private String firstName;

    /**
     * Отчество
     */
    private String middleName;

    /**
     * Дата рождения
     */
    private LocalDate dateOfBirth;
}
