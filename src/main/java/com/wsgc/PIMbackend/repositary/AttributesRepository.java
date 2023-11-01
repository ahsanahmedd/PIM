package com.wsgc.PIMbackend.repositary;

import com.wsgc.PIMbackend.model.Attributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Spring Data JPA repository for Attributes entity.
 */
@Repository
public interface AttributesRepository extends JpaRepository<Attributes, Long> {
    // You can add custom query methods here if needed
}

