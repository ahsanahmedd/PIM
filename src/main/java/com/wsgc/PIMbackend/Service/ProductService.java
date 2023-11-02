
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



@Service
public class ProductService {
    private  ProductRepositary productRepository;
    private final SubCategoryRepositary subCategoryRepositary;
    /**
     * Constructor
     * @return
     */
    @Autowired
    public ProductService(ProductRepositary productRepository, SubCategoryRepositary subCategoryRepositary) {
        this.productRepository = productRepository;
        this.subCategoryRepositary = subCategoryRepositary;
    }
    /**
     * Retrieve all Product from the repository
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    /**
     * Retrieve a Product by its ID from the repository
     * @param id
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    /**
     * Create a new Product in the repository
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    /**
     * Update an existing Product in the repository
     * @param id
     */
    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setSKU(updatedProduct.getSKU());
//
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            product.setSwatches(updatedProduct.getSwatches());
            product.setAttribute(updatedProduct.getAttribute());


            return productRepository.save(product);
        } else {
            return null; // Handle not found
        }
    }
    /**
     * Delete a Product by its ID from the repository
     * @param id
     */
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false; // Handle not found
        }
    }
}
