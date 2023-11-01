
package com.wsgc.PIMbackend.Controller;

import com.wsgc.PIMbackend.Service.SuperCategoryService;
import com.wsgc.PIMbackend.model.SuperCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * The Super Category Controller class manages and coordinates the behavior of multiple category-related controllers in a software system.
 */
@RestController
@RequestMapping("/supercategories")
public class SuperCategoryController {

    private SuperCategoryService superCategoryService;
    /**
     * Constructor
     * @return
     */
    @Autowired
    public SuperCategoryController(SuperCategoryService superCategoryService) {
        this.superCategoryService = superCategoryService;
    }
    /**
     *Retrieve and return all SuperCategory
     */
    @GetMapping
    public ResponseEntity<List<SuperCategory>> getAllSuperCategories(){
        List<SuperCategory> superCategories = superCategoryService.getAllSuperCategories();
        return new ResponseEntity<>(superCategories, HttpStatus.OK);
    }
    /**
     *Retrieve and return a SuperCategory by its ID
     */
    @GetMapping("/{id}")
    public SuperCategory getSuperCategory(@PathVariable Long id) {
        return superCategoryService.getSuperCategoryById(id);
    }
    /**
     *  Create and return a new SuperCategory
     * @return
     */
    @PostMapping
    public SuperCategory createSuperCategory(@RequestBody SuperCategory superCategory) {
        return superCategoryService.createSuperCategory(superCategory);
    }
    /**
     * Update and return the updated SuperCategory
     * @param id

     * @return
     */
    @PutMapping("/{id}")
    public SuperCategory updateSuperCategory(@PathVariable Long id, @RequestBody SuperCategory superCategory) {
        return superCategoryService.updateSuperCategory(id, superCategory);
    }
    /**
     * Delete a SuperCategory by its ID
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteSuperCategory(@PathVariable Long id) {
        superCategoryService.deleteSuperCategory(id);
    }
}
