
package com.wsgc.PIMbackend.Service.impl;

import com.wsgc.PIMbackend.Service.CategoryService;
import com.wsgc.PIMbackend.Service.SuperCategoryService;
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
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepositary categoryRepository;
    public SuperCategoryService superCategoryService;
    /**
     * @inheritDoc
     */
    @Autowired
    public CategoryServiceImpl(CategoryRepositary categoryRepository, SuperCategoryRepositary superCategoryRepositary) {
        this.categoryRepository = categoryRepository;
        this.superCategoryService = superCategoryService;
    }
    /**
     * @inheritDoc
     */
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    /**
     * @inheritDoc
     */
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }
    public List<Category> findByName(String name) {
        return categoryRepository.findByName(name);}
    /**
     * @inheritDoc
     */
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    /**
     * @inheritDoc
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
     * @inheritDoc
     */
    public boolean deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false; // Category not found
    }
}
