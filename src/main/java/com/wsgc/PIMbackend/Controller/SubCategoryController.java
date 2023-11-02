
package com.wsgc.PIMbackend.Controller;

import com.wsgc.PIMbackend.Service.CategoryService;
import com.wsgc.PIMbackend.Service.SubCategoryService;
import com.wsgc.PIMbackend.model.Category;
import com.wsgc.PIMbackend.model.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * The Sub-Category Controller class manages and controls the functionality related to sub-categories within a software application.
 */

@RestController
@RequestMapping("/api/subcategories")
public class SubCategoryController {

    private final CategoryService categoryService;
    private final SubCategoryService subCategoryService;
    /**
     * Constructor
     * @return
     */
    @Autowired
    public SubCategoryController(CategoryService categoryService, SubCategoryService subCategoryService) {
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
    }

    /**
     *Retrieve and return all SubCategory
     */
    @GetMapping
    public List<SubCategory> getAllSubCategories() {
        return subCategoryService.getAllSubCategories();
    }

    /**
     *Retrieve and return a SubCategory by its ID
     * @param subCategoryId objects
     * @return the {@link SubCategory} objects
     */
    @GetMapping("/{subCategoryId}")
    public SubCategory getSubCategoryById(@PathVariable Long subCategoryId) {
        return subCategoryService.getSubCategoryById(subCategoryId);
    }

    /**
     *  Create and return a new SubCategory
     * @param subCategory objects
     * @return the {@link SubCategory} objects
     */
    @PostMapping
    public SubCategory createSubCategory(@RequestBody SubCategory subCategory) {
        return subCategoryService.createSubCategory(subCategory);
    }
    /**
     * Update and return the updated SubCategory
     * @param subCategoryId the identification number for subCategory
     * @return the {@link SubCategory} objects
     */
    @PutMapping("/{subCategoryId}")
    public SubCategory updateSubCategory(@PathVariable Long subCategoryId, @RequestBody SubCategory updatedSubCategory) {
        return subCategoryService.updateSubCategory(subCategoryId, updatedSubCategory);
    }

    /**
     * Delete a SubCategory by its ID
     */
    @DeleteMapping("/{subCategoryId}")
    public void deleteSubCategory(@PathVariable Long subCategoryId) {
        subCategoryService.deleteSubCategory(subCategoryId);
    }
}

