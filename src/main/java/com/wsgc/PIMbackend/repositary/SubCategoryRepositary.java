package com.wsgc.PIMbackend.repositary;

import com.wsgc.PIMbackend.model.Category;
import com.wsgc.PIMbackend.model.Product;
import com.wsgc.PIMbackend.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A sub-category repository is a specialized collection of digital assets or information within a larger repository, focusing on a specific topic or theme.
 */
@Repository
public interface SubCategoryRepositary extends JpaRepository<SubCategory, Long> {
    List<SubCategory> findByName(String name);
}
