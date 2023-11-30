package com.wsgc.PIMbackend.repositary;

import com.wsgc.PIMbackend.model.Attributes;
import com.wsgc.PIMbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for Attributes entity.
 */
@Repository
public interface AttributesRepository extends JpaRepository<Attributes, Long> {
    // You can add custom query methods here if needed
    List<Attributes> findByName(String name);
}

