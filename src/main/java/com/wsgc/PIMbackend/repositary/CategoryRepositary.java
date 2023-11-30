package com.wsgc.PIMbackend.repositary;

import com.wsgc.PIMbackend.model.Category;
import com.wsgc.PIMbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 A Category Repository is a centralized storage system for organizing and managing various items, data, or content based on specific categories or classifications.
 */
@Repository
public interface CategoryRepositary extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);
}
