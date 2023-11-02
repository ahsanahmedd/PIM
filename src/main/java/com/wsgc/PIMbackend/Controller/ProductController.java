
package com.wsgc.PIMbackend.Controller;

import com.wsgc.PIMbackend.Service.ProductService;
import com.wsgc.PIMbackend.Service.SubCategoryService;
import com.wsgc.PIMbackend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 * The Product Controller class manages and handles product-related operations and interactions within a software application.
 */

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final SubCategoryService subCategoryService;

    /**
     * Constructor
     */
    @Autowired
    public ProductController(ProductService productService, SubCategoryService subCategoryService) {
        this.productService = productService;
        this.subCategoryService = subCategoryService;
    }
    /**
     *Retrieve and return all Product
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    /**
     *Retrieve and return a Product by its ID
     * @param id objects
     * @return the {@link Product}objects
     */
    @GetMapping("/{ProductID}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    /**
     *  Create and return a new Product
     * @param product objects
     * @return the {@link Product} objects
     */
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    /**
     * Update and return the updated Product
     *  @param id the identification number for product
     *  @param product
     *  @return the {@link Product} objects
     */
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
    /**
     * Delete a Product by its ID
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
