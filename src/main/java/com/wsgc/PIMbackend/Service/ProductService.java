
package com.wsgc.PIMbackend.Service;

import com.wsgc.PIMbackend.model.Product;
import com.wsgc.PIMbackend.repositary.ProductRepositary;
import com.wsgc.PIMbackend.repositary.SubCategoryRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * A Product Service class is a software component that encapsulates and manages the functionality and data related to product services in an application.
 */




public interface ProductService {
    /**
     * Retrieve all Product from the repository
     */
    public List<Product> getAllProducts();
    /**
     * Retrieve a Product by its ID from the repository
     * @param id objects
     * @return the {@link Product} objects
     */
    public Product getProductById(Long id);
    /**
     * Create a new Product in the repository
     * @param product objects
     * @return the {@link Product} objects
     */
    public Product createProduct(Product product);
    /**
     * Update an existing Product in the repository
     *  @param id the identification number for product
     *  @return the {@link Product} objects
     */
    public Product updateProduct(Long id, Product updatedProduct);
    /**
     * Delete a Product by its ID from the repository
     * @param id
     */
    public boolean deleteProduct(Long id);
}
