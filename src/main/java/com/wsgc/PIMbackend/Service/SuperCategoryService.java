
package com.wsgc.PIMbackend.Service;

import com.wsgc.PIMbackend.model.Product;
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
public interface SuperCategoryService {
    /**
     * @inheritDoc
     */
    public List<SuperCategory> getAllSuperCategories();
    /**
     * @inheritDoc
     */
    public SuperCategory getSuperCategoryById(Long id);
    public  List<SuperCategory> findByName(String name);
    /**
     * @inheritDoc
     */
    public SuperCategory createSuperCategory(SuperCategory superCategory);
    /**
     * @inheritDoc
     */
    public SuperCategory updateSuperCategory(Long id, SuperCategory superCategory);
    /**
     * @inheritDoc
     */
    public boolean deleteSuperCategory(Long id);
}
