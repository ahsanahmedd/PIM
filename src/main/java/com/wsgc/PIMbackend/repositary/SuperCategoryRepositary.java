package com.wsgc.PIMbackend.repositary;

import com.wsgc.PIMbackend.model.Product;
import com.wsgc.PIMbackend.model.SuperCategory;
//import net.javaguides.PIMbackend.model.SuperCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * A superCategory Repository is a centralized storage and management system for organizing and categorizing various repositories, facilitating efficient data and resource management.
 */

@Repository
public interface SuperCategoryRepositary extends JpaRepository<SuperCategory, Long> {
    List<SuperCategory> findByName(String name);
    // all crude database methods
    Optional<SuperCategory> findById(Long number);
    void deleteById(Long id);
}

