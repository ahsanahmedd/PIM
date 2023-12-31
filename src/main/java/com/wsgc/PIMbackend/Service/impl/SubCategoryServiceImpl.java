
package com.wsgc.PIMbackend.Service.impl;

import com.wsgc.PIMbackend.Service.CategoryService;
import com.wsgc.PIMbackend.Service.SubCategoryService;
import com.wsgc.PIMbackend.model.Product;
import com.wsgc.PIMbackend.model.SubCategory;
import com.wsgc.PIMbackend.repositary.SubCategoryRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A Sub-Category Service class is a specialized component that manages and provides services related to a specific sub-category within a larger system or application.
 */
@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private CategoryService categoryService;
    private final SubCategoryRepositary subCategoryRepository;
    /**
     * Constructor
     * @return
     */
    @Autowired
    public SubCategoryServiceImpl(SubCategoryRepositary subCategoryRepository, CategoryService categoryService) {
        this.categoryService = categoryService;
        this.subCategoryRepository = subCategoryRepository;
    }



    /**
     * Retrieve all SubCategory from the repository
     */
        public List<SubCategory> getAllSubCategories() {
            return subCategoryRepository.findAll();
        }
    /**
     * Retrieve a SubCategory by its ID from the repository
     * @param id
     */
        public SubCategory getSubCategoryById(Long id) {
            return subCategoryRepository.findById(id).orElse(null);
        }
    public List<SubCategory> findByName(String name) {
        return subCategoryRepository.findByName(name);}
    /**
     * Create a new SubCategory in the repository
     * @param subCategory objects
     * @return the {@link SubCategory} objects
     */
        public SubCategory createSubCategory(SubCategory subCategory) {
            return subCategoryRepository.save(subCategory);
        }
    /**
     * Update an existing SubCategory in the repository
     * @param id the identification number for subCategory
     * @return the {@link SubCategory} objects
     */
        public SubCategory updateSubCategory(Long id, SubCategory updatedSubCategory) {
            SubCategory existingSubCategory = subCategoryRepository.findById(id).orElse(null);
            if (existingSubCategory != null) {
                existingSubCategory.setName(updatedSubCategory.getName());
                existingSubCategory.setSeoCopy(updatedSubCategory.getSeoCopy());
                existingSubCategory.setCategory(updatedSubCategory.getCategory());
                existingSubCategory.setDescription(updatedSubCategory.getDescription());
                // Update other attributes as needed
                return subCategoryRepository.save(existingSubCategory);
            }
            return null; // Handle not found case
        }
    /**
     * Delete a SubCategory by its ID from the repository
     * @param id
     */
        public void deleteSubCategory(Long id) {
            subCategoryRepository.deleteById(id);
        }
    }




