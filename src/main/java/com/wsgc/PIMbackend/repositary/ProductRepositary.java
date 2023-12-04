package com.wsgc.PIMbackend.repositary;

import com.wsgc.PIMbackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * A product repository is a centralized database or storage system that houses information and data related to a company's or organization's products, making it easy to manage, access, and track product details.
 */
@Repository
public interface ProductRepositary extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
    List<Product> findByPrice(Long price);
    @Query("SELECT p FROM Product p WHERE p.price >= :minPrice AND p.price <= :maxPrice")
    List<Product> findByPriceRange(@Param("minPrice") long minPrice, @Param("maxPrice") long maxPrice);



//    List<Product> findByPriceRange(long minprice, long maxprice) ;
}
