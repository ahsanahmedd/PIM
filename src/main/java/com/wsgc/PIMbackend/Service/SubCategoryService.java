
package com.wsgc.PIMbackend.Service;

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
public interface SubCategoryService {
    /**
     * @inheritDoc
     */
        public List<SubCategory> getAllSubCategories();
    /**
     * @inheritDoc
     */
        public SubCategory getSubCategoryById(Long id);
    public List<SubCategory> findByName(String name);
    /**
     * @inheritDoc
     */
        public SubCategory createSubCategory(SubCategory subCategory);
    /**
     * @inheritDoc
     */
        public SubCategory updateSubCategory(Long id, SubCategory updatedSubCategory);
    /**
     * @inheritDoc
     */
        public void deleteSubCategory(Long id);
    }




