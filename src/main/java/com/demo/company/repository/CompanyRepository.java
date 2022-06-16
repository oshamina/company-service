package com.demo.company.repository;

import com.demo.company.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

/**
 * Интерфейс, предоставляющий методы получения организаций из базы данных
 */
public interface CompanyRepository extends JpaRepository<Company, UUID> {

    /**
     * @param template - шаблон для поиска по подстроке
     * @return список организаций, найденных по вхождению без учета регистра в любое из полей шаблона для поиска
     */
    @Query(value = "SELECT c.* " +
            "FROM companies c " +
            "LEFT JOIN persons p on c.general_director_id = p.id " +
            "WHERE c.full_name ilike '%' || ?1 || '%'" +
            " OR c.short_name ilike '%' || ?1 || '%'" +
            " OR c.inn ilike '%' || ?1 || '%'" +
            " OR c.ogrn ilike '%' || ?1 || '%'" +
            " OR c.postal_address ilike '%' || ?1 || '%'" +
            " OR c.legal_address ilike '%' || ?1 || '%'" +
            " OR p.first_name ilike '%' || ?1 || '%'" +
            " OR p.middle_name ilike '%' || ?1 || '%'" +
            " OR p.last_name ilike '%' || ?1 || '%'",
           nativeQuery = true)
    List<Company> findByTemplate(String template);
}
