
package com.wsgc.PIMbackend.Controller;

import com.wsgc.PIMbackend.Service.SubCategoryService;
import com.wsgc.PIMbackend.Service.SuperCategoryService;
import com.wsgc.PIMbackend.dtos.ProductInfoDto;
import com.wsgc.PIMbackend.model.Category;
import com.wsgc.PIMbackend.model.SubCategory;
import com.wsgc.PIMbackend.model.SuperCategory;
import com.wsgc.PIMbackend.exception.ResourceNotFoundException;

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
    public ResponseEntity<ProductInfoDto> getAllSuperCategories(){
        List<SuperCategory> superCategories = superCategoryService.getAllSuperCategories();
        ProductInfoDto productInfoDto = new ProductInfoDto();
        productInfoDto.setApiDesc("Electronics: Mobiles, Laptops etc");
        productInfoDto.setSupercategories(superCategories);
        return new ResponseEntity<>(productInfoDto, HttpStatus.OK);
    }
    /**
     *Retrieve and return a SuperCategory by its ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<SuperCategory> getSuperCategoryById(@PathVariable Long id) {
        SuperCategory superCategory = superCategoryService.getSuperCategoryById(id);

//        return new ResponseEntity<>(superCategory, HttpStatus.OK);
//        return ResourceNotFoundException(HttpStatus.NOT_FOUND);
//        return ResourceNotFoundException(("Employee not exist with id: "+ id));


        if (superCategory != null) {
            return new ResponseEntity<SuperCategory>(superCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<SuperCategory>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/name")
    public ResponseEntity<List<SuperCategory>> getSuperCategoryByName(@RequestParam String name){
        List<SuperCategory> superCategory = superCategoryService.findByName(name);
        return ResponseEntity.ok(superCategory);
    }
    /**
     *  Create and return a new SuperCategory
     * @param superCategory objects
     * @return the {@link SuperCategory} objects
     */
    @PostMapping
    public SuperCategory createSuperCategory(@RequestBody SuperCategory superCategory) {
        return superCategoryService.createSuperCategory(superCategory);
    }
    /**
     * Update and return the updated SuperCategory
     * @param id the identification number for SuperCategories
     * @param superCategory
     * @return the {@link SuperCategory} objects
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
