
package com.wsgc.PIMbackend.Service;

import com.wsgc.PIMbackend.model.Category;
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
public class CategoryService {

    private final CategoryRepositary categoryRepository;
    public SuperCategoryService superCategoryService;
    /**
     * Constructor
     * @return
     */
    @Autowired
    public CategoryService(CategoryRepositary categoryRepository, SuperCategoryRepositary superCategoryRepositary) {
        this.categoryRepository = categoryRepository;
        this.superCategoryService = superCategoryService;
    }
    /**
     * Retrieve all Category from the repository
     * @return
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    /**
     * Retrieve a Category by its ID from the repository
     * @param id
     * @return
     */
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }
    /**
     * Create a new Category in the repository
     * @return
     */
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    /**
     * Update an existing Category in the repository
     * @param id
     * @return
     */
    public Category updateCategory(Long id, Category category) {
        if (categoryRepository.existsById(id)) {
            category.setId(id);
            category.setName(category.getName());
            category.setSeoCopy(category.getSeoCopy());
            category.setDescription(category.getDescription());
            return categoryRepository.save(category);
        }
        return null; // Category not found
    }
    /**
     * Delete a Category by its ID from the repository
     * @param id
     */
    public boolean deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false; // Category not found
    }
}
