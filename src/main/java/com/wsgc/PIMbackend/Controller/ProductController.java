
package com.wsgc.PIMbackend.Controller;

import com.wsgc.PIMbackend.Service.ProductService;
import com.wsgc.PIMbackend.Service.impl.ProductServiceImpl;
import com.wsgc.PIMbackend.Service.SubCategoryService;
import com.wsgc.PIMbackend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Product Controller class manages and handles product-related operations and interactions within a software application.
 */

@RestController
@RequestMapping("/supercategories/products")
public class ProductController {
    private final ProductService productService;
    private final SubCategoryService subCategoryService;

    /**
     * Constructor
     */
    @Autowired
    public ProductController(ProductServiceImpl productService, SubCategoryService subCategoryService) {
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
     * @param ProductId objects
     * @return the {@link Product}objects
     */
    @GetMapping("/{ProductId}")
    public Product getProductById(@PathVariable Long ProductId) {
        return productService.getProductById(ProductId);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Product>> getProductByName(@RequestParam String name){
        List<Product> products = productService.findByName(name);
        return ResponseEntity.ok(products);
    }
    @GetMapping("/price")
    public ResponseEntity<List<Product>> getProductByPrice(@RequestParam Long price){
        List<Product> products = productService.findByPrice(price);
        return ResponseEntity.ok(products);
    }
    @GetMapping("/priceRange")
    public ResponseEntity<List<Product>> getProductsByPriceRange(
            @RequestParam(name = "minPrice", required = true) long minprice,
            @RequestParam(name = "maxPrice", required = true) long maxprice) {

        List<Product> products = productService.findByPriceRange(minprice, maxprice);
        return ResponseEntity.ok(products);
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
