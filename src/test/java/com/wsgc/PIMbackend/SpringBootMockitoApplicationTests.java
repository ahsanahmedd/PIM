package com.wsgc.PIMbackend;

import com.wsgc.PIMbackend.Service.ProductService;
import com.wsgc.PIMbackend.Service.impl.ProductServiceImpl;
import com.wsgc.PIMbackend.model.Product;
import com.wsgc.PIMbackend.repositary.ProductRepositary;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SpringBootMockitoApplicationTests {

    @Mock
    private ProductRepositary productRepository; // Assuming ProductRepository is the repository interface

    @InjectMocks
    private ProductServiceImpl productServiceImpl; // The service that we want to test

    @Test
    public void testAddProduct() {
        Product productToAdd = new Product("1", "Sample Product", 50.0);
        when(productRepository.save(any(Product.class))).thenReturn(productToAdd);

        Product addedProduct = productServiceImpl.addProduct(productToAdd);

        assertEquals("1", addedProduct.getId());
        assertEquals("Sample Product", addedProduct.getName());
        assertEquals(Optional.of(50.0), addedProduct.getPrice());
    }

}