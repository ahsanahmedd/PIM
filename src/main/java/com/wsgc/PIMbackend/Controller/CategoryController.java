
package com.wsgc.PIMbackend.Controller;

import com.wsgc.PIMbackend.Service.CategoryService;
import com.wsgc.PIMbackend.Service.SuperCategoryService;
import com.wsgc.PIMbackend.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * The Category Controller class manages and controls interactions with category-related data and functionality within the application.
 */

@RestController
@RequestMapping("/categories")
public class CategoryController {


    private CategoryService categoryService;
    private SuperCategoryService superCategoryService;
    /**
     * Constructor
     */
    @Autowired
    public CategoryController(CategoryService categoryService, SuperCategoryService superCategoryService){
        this.categoryService = categoryService;
        this.superCategoryService = superCategoryService;
    }

    /**
     *Retrieve and return all Category
     */
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    /**
     *Retrieve and return a Category by its ID
     * @param id
     * @return the {@link Category} object
     */
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    /**
     *  Create and return a new Category
     * @param category objects
     * @return the {@link Category} objects
     */
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    /**
     * Update and return the updated Category
     * @param id the identification number for categories
     * @param category
     * @return the {@link Category} objects
     */
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    /**
     * Delete a Category by its ID
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
