
package com.wsgc.PIMbackend.Service.impl;

import com.wsgc.PIMbackend.Service.SuperCategoryService;
import com.wsgc.PIMbackend.model.SuperCategory;
import com.wsgc.PIMbackend.repositary.SuperCategoryRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The SuperCategory Service class provides centralized management and operations for high-level categories in a software application.
 */
@Service
public class SuperCategoryServiceImpl implements SuperCategoryService {


    private final SuperCategoryRepositary superCategoryRepositary;

    /**
     * Constructor
     */
    @Autowired

    public SuperCategoryServiceImpl(SuperCategoryRepositary superCategoryRepository, SuperCategoryRepositary superCategoryRepositary) {
        this.superCategoryRepositary = superCategoryRepositary;

    }
    @Override
    public SuperCategory addSuperCategory(SuperCategory superCategoryToAdd) {
        return superCategoryRepositary.save(superCategoryToAdd);
    }



    /**
     * Retrieve all SuperCategory from the repository
     */
    public List<SuperCategory> getAllSuperCategories() {
        return superCategoryRepositary.findAll();
    }
    /**
     * Retrieve a SuperCategory by its ID from the repository
     * @param id
     */
    public SuperCategory getSuperCategoryById(Long id) {
        Optional<SuperCategory> superCategoryOptional = superCategoryRepositary.findById(id);
        return superCategoryOptional.orElse(null);
//        (new ResourceNotFoundException(("Employee not exist with id: "+ id))
    }
    public List<SuperCategory> findByName(String name) {
        return superCategoryRepositary.findByName(name);}
    /**
     * Create a new SuperCategory in the repository
     * @param superCategory objects
     * @return the {@link SuperCategory} objects
     */
    public SuperCategory createSuperCategory(SuperCategory superCategory) {
        return superCategoryRepositary.save(superCategory);
    }
    /**
     * Update an existing SuperCategory in the repository
     * @param id the identification number for SuperCategories
     * @param superCategory
     * @return the {@link SuperCategory} objects
     */
    public SuperCategory updateSuperCategory(Long id ,SuperCategory superCategory) {
        Optional<SuperCategory> existingSuperCategoryOptional = superCategoryRepositary.findById(id);


        if (existingSuperCategoryOptional.isPresent()) {
            SuperCategory existingSuperCategory = existingSuperCategoryOptional.get();
            existingSuperCategory.setCategoryname(superCategory.getCategoryname());
            existingSuperCategory.setName(superCategory.getName());
            existingSuperCategory.setSeoCopy(superCategory.getSeoCopy());
            existingSuperCategory.setDescription(superCategory.getDescription());
            return superCategoryRepositary.save(existingSuperCategory);
        } else {
            return null; // SuperCategory with the given ID does not exist
        }
    }
    /**
     * Delete a SuperCategory by its ID from the repository
     * @param id
     */
    public boolean deleteSuperCategory(Long id) {
        if (superCategoryRepositary.existsById(id)) {
            superCategoryRepositary.deleteById(id);
            return true;
        } else {
            return false; // SuperCategory with the given ID does not exist
        }
    }
}
