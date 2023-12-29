
package com.wsgc.PIMbackend.Service;

import com.wsgc.PIMbackend.model.Category;
import com.wsgc.PIMbackend.model.Product;
import com.wsgc.PIMbackend.repositary.CategoryRepositary;
import com.wsgc.PIMbackend.repositary.SuperCategoryRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * A Category Service class facilitates the organization and management of items or entities into distinct categories or groups.
 */
@Service
public interface CategoryService {
    /**
     * Retrieve all Category from the repository
     */
    public List<Category> getAllCategories() ;
    /**
     * Retrieve a Category by its ID from the repository
     * @param id
     * @return the {@link Category} object
     */
    public Category getCategoryById(Long id) ;
    public  List<Category> findByName(String name);
    /**
     * Create a new Category in the repository
     * @param category objects
     * @return the {@link Category} objects
     */
    public Category createCategory(Category category);
    /**
     * Update an existing Category in the repository
     * @param id the identification number for categories
     * @param category
     * @return the {@link Category} objects
     */
    public Category updateCategory(Long id, Category category);
    /**
     * Delete a Category by its ID from the repository
     * @param id
     */
    public boolean deleteCategory(Long id);

    Category addCategory(Category categoryToAdd);
}
