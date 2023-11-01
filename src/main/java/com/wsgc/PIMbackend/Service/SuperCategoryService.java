
package com.wsgc.PIMbackend.Service;

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
public class SuperCategoryService {


    private final SuperCategoryRepositary superCategoryRepositary;

    /**
     * Constructor
     * @return
     */
    @Autowired

    public SuperCategoryService(SuperCategoryRepositary superCategoryRepository, SuperCategoryRepositary superCategoryRepositary) {
        this.superCategoryRepositary = superCategoryRepositary;

    }
    /**
     * Retrieve all SuperCategory from the repository
     * @return
     */
    public List<SuperCategory> getAllSuperCategories() {
        return superCategoryRepositary.findAll();
    }
    /**
     * Retrieve a SuperCategory by its ID from the repository
     * @param id
     * @return
     */
    public SuperCategory getSuperCategoryById(Long id) {
        Optional<SuperCategory> superCategoryOptional = superCategoryRepositary.findById(id);
        return superCategoryOptional.orElse(null);
    }
    /**
     * Create a new SuperCategory in the repository
     * @return
     */
    public SuperCategory createSuperCategory(SuperCategory superCategory) {
        return superCategoryRepositary.save(superCategory);
    }
    /**
     * Update an existing SuperCategory in the repository
     * @param id
     * @return
     */
    public SuperCategory updateSuperCategory(Long id, SuperCategory superCategory) {
        Optional<SuperCategory> existingSuperCategoryOptional = superCategoryRepositary.findById(id);


        if (existingSuperCategoryOptional.isPresent()) {
            SuperCategory existingSuperCategory = existingSuperCategoryOptional.get();
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
        }
        return false; // SuperCategory with the given ID does not exist
    }
}
