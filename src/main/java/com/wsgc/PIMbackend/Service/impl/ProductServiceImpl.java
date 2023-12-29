
package com.wsgc.PIMbackend.Service.impl;
import com.wsgc.PIMbackend.Service.ProductService;
import com.wsgc.PIMbackend.model.Product;

import com.wsgc.PIMbackend.repositary.ProductRepositary;

import com.wsgc.PIMbackend.repositary.SubCategoryRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

/**
 * @inheritDoc
 */
@Service
public  class ProductServiceImpl implements ProductService {
    private  ProductRepositary productRepository;
    private final SubCategoryRepositary subCategoryRepositary;
    /**
     * @inheritDoc
     */
    @Autowired
    public ProductServiceImpl(ProductRepositary productRepository, SubCategoryRepositary subCategoryRepositary) {
        this.productRepository = productRepository;
        this.subCategoryRepositary = subCategoryRepositary;
    }
    /**
     * @inheritDoc
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    /**
     * @inheritDoc

     */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);}
    public List<Product> findByPrice(Long price) {
        return productRepository.findByPrice(price);}

//    @Override
//    public List<Product> findByPriceRange(long minprice, long maxprice) {
//        return null;
//    }
@Override
    public List<Product> findByPriceRange(long minprice, long maxprice){
        return productRepository.findByPriceRange(minprice,maxprice);
    }

    /**
     * @inheritDoc
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    /**
     * @inheritDoc
     */
    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
//            product.setSKU(updatedProduct.getSKU());
            product.setSku(updatedProduct.getSku());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            product.setSwatches(updatedProduct.getSwatches());
            product.setAttribute(updatedProduct.getAttribute());
            product.setSeoCopy(updatedProduct.getSeoCopy());
//            product.setAttributes(updatedProduct.getAttributes());


            return productRepository.save(product);
        } else {
            return null; // Handle not found
        }
    }
    /**
     * @inheritDoc
     */
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false; // Handle not found
        }
    }

    @Override
    public Product addProduct(Product productToAdd) {
        return productRepository.save(productToAdd);
    }

    public Product updateProduct(Product updateProduct) {
        return productRepository.save(updateProduct);
    }
}
