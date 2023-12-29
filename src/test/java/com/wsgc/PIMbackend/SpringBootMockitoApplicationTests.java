package com.wsgc.PIMbackend;

import com.wsgc.PIMbackend.Service.impl.*;
import com.wsgc.PIMbackend.model.*;
import com.wsgc.PIMbackend.repositary.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.Attribute;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class SpringBootMockitoApplicationTests {

    @Mock
    private ProductRepositary productRepository;
    @Mock
    private SuperCategoryRepositary superCategoryRepositary;
    @Mock
    private CategoryRepositary categoryRepositary;
    @Mock
    private SubCategoryRepositary subCategoryRepositary;
    @Mock
    private AttributesRepository attributesRepository;


    @InjectMocks
    private ProductServiceImpl productServiceImpl;
    @InjectMocks
    private SuperCategoryServiceImpl superCategoryServiceImpl;
    @InjectMocks
    private CategoryServiceImpl categoryServiceImpl;
    @InjectMocks
    private SubCategoryServiceImpl subCategoryServiceImpl;
    @InjectMocks
    private AttributesServiceImpl attributesServiceImpl;




    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddProduct() {
        Product productToAdd = new Product(1L, "Sample Product", 50L);
        when(productRepository.save(productToAdd)).thenReturn(productToAdd);

        Product addedProduct = productServiceImpl.addProduct(productToAdd);

        assertEquals(1L, addedProduct.getId());
        assertEquals("Sample Product", addedProduct.getName());
        assertEquals(50L, addedProduct.getPrice());
    }

    @Test
    public void testGetProductById() {
        Product sampleProduct = new Product(1L, "Sample Product", 50L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(sampleProduct));

        Product retrievedProduct = productServiceImpl.getProductById(1L);

        assertEquals(1L, retrievedProduct.getId());
        assertEquals("Sample Product", retrievedProduct.getName());
        assertEquals(50L, retrievedProduct.getPrice());
    }

    @Test
    public void testUpdateProduct() {
        Product existingProduct = new Product(1L, "Sample Product", 50L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(existingProduct)).thenReturn(existingProduct);

        Product updatedProduct = productServiceImpl.updateProduct(existingProduct);

        assertEquals(1L, updatedProduct.getId());
        assertEquals("Sample Product", updatedProduct.getName());
        assertEquals(50L, updatedProduct.getPrice());
    }
    @Test
    public void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(1L);

        when(productRepository.existsById(1L)).thenReturn(true);
        productServiceImpl.deleteProduct(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }
    @Test
    public void testGetAllProducts() {
        Product product1 = new Product(1L, "Product 1", 10L);
        Product product2 = new Product(2L, "Product 2", 20L);
        List<Product> productList = Arrays.asList(product1,product2);

        when(productRepository.findAll()).thenReturn(productList);

        List<Product> retrievedProducts = productServiceImpl.getAllProducts();

        assertEquals(2, retrievedProducts.size());
        assertEquals("Product 1", retrievedProducts.get(0).getName());
        assertEquals("Product 2", retrievedProducts.get(1).getName());
    }

@Test
public void testSuperCategoryCreation() {

    long superCategoryId = 1L;
    String superCategoryName = "Electronics";

    SuperCategory superCategory = new SuperCategory(superCategoryId, superCategoryName);

    assertEquals(superCategoryId, superCategory.getId());
    assertEquals(superCategoryName, superCategory.getName());
}
    @Test
    public void testGetSuperCategoryById() {
        SuperCategory sampleSuperCategory = new SuperCategory(1L, "Electronics");
        when(superCategoryRepositary.findById(1L)).thenReturn(Optional.of(sampleSuperCategory));

        SuperCategory retrievedSuperCategory = superCategoryServiceImpl.getSuperCategoryById(1L);

        assertEquals(1L, retrievedSuperCategory.getId());
        assertEquals("Electronics", retrievedSuperCategory.getName());
    }
//    @Test
//    public void testUpdateSuperCategory() {
//        SuperCategory existingSuperCategory = new SuperCategory(1L, "Electronics");
//        when(superCategoryRepositary.existsById(1L)).thenReturn(true);
//        when(superCategoryRepositary.save(any(SuperCategory.class))).thenReturn(existingSuperCategory);
//
//        SuperCategory updatedSuperCategory = superCategoryServiceImpl.updateSuperCategory(1L, "Updated Electronics");
//
//        assertEquals(1L, updatedSuperCategory.getId());
//        assertEquals("Updated Electronics", updatedSuperCategory.getName());
//    }

    @Test
    public void testDeleteSuperCategory() {
        doNothing().when(superCategoryRepositary).deleteById(1L);
        when(superCategoryRepositary.existsById(1L)).thenReturn(true);

        superCategoryServiceImpl.deleteSuperCategory(1L);

        verify(superCategoryRepositary, times(1)).deleteById(1L);
    }
    @Test
    public void testAddCategory() {
        Category categoryToAdd = new Category(1L, "Electronics");
        when(categoryRepositary.save(categoryToAdd)).thenReturn(categoryToAdd);

        Category addedCategory = categoryServiceImpl.addCategory(categoryToAdd);

        assertEquals(1L, addedCategory.getId());
        assertEquals("Electronics", addedCategory.getName());
    }

    @Test
    public void testGetCategoryById() {
        Category sampleCategory = new Category(1L, "Electronics");
        when(categoryRepositary.findById(1L)).thenReturn(Optional.of(sampleCategory));

        Category retrievedCategory = categoryServiceImpl.getCategoryById(1L);

        assertEquals(1L, retrievedCategory.getId());
        assertEquals("Electronics", retrievedCategory.getName());
    }

    @Test
    public void testGetAllCategories() {
        Category category1 = new Category(1L, "Electronics");
        Category category2 = new Category(2L, "Clothing");
        List<Category> categories = Arrays.asList(category1, category2);
        when(categoryRepositary.findAll()).thenReturn(categories);

        List<Category> retrievedCategories = categoryServiceImpl.getAllCategories();

        assertEquals(2L, retrievedCategories.size());
        assertEquals("Electronics", retrievedCategories.get(0).getName());
        assertEquals("Clothing", retrievedCategories.get(1).getName());
    }
//
////    @Test
////    public void testUpdateCategory() {
////        Category existingCategory = new Category(1L, "Electronics");
////        when(categoryRepositary.existsById(1L)).thenReturn(true);
////        when(categoryRepositary.save(any(Category.class))).thenReturn(existingCategory);
////
////        Category updatedCategory = categoryServiceImpl.updateCategory(1L, "Updated Electronics");
////
////        assertEquals(1L, updatedCategory.getId());
////        assertEquals("Updated Electronics", updatedCategory.getName());
////    }
//
//    @Test
//    public void testDeleteCategory() {
//        when(categoryRepositary.existsById(1L)).thenReturn(true);
//
//        categoryServiceImpl.deleteCategory(1L);
//
//        verify(categoryRepositary, Mockito.times(1)).deleteById(1L);
//    }
    @Test
    public void testAddSubCategory() {
        SubCategory subCategoryToAdd = new SubCategory(1L, "SubCategoryName");
        when(subCategoryRepositary.save(any(SubCategory.class))).thenReturn(subCategoryToAdd);

        SubCategory addedSubCategory = subCategoryServiceImpl.createSubCategory(subCategoryToAdd);

        assertEquals(1L, addedSubCategory.getId());
//        assertEquals("CategoryID1", addedSubCategory.getCategoryId());
        assertEquals("SubCategoryName", addedSubCategory.getName());
    }
//
//    @Test
//    public void testGetSubCategoryById() {
//        SubCategory sampleSubCategory = new SubCategory(1L,  "SubCategoryName");
//        when(subCategoryRepositary.findById(1L)).thenReturn(Optional.of(sampleSubCategory));
//
//        SubCategory retrievedSubCategory = subCategoryServiceImpl.getSubCategoryById(1L);
//
//        assertEquals(1L, retrievedSubCategory.getId());
////        assertEquals("CategoryID1", retrievedSubCategory.getCategoryId());
//        assertEquals("SubCategoryName", retrievedSubCategory.getName());
//    }
////    @Test
////    public void testUpdateSubCategory() {
////        SubCategory existingSubCategory = new SubCategory(1L, "SubCategoryName");
////        when(subCategoryRepositary.existsById(1L)).thenReturn(true);
////        when(subCategoryRepositary.save(any(SubCategory.class))).thenReturn(existingSubCategory);
////
////        SubCategory updatedSubCategory = subCategoryServiceImpl.updateSubCategory(1L, "UpdatedSubCategoryName");
////
////        assertEquals("1", updatedSubCategory.getId());
//////        assertEquals("CategoryID1", updatedSubCategory.getCategoryId());
////        assertEquals("UpdatedSubCategoryName", updatedSubCategory.getName());
////    }
//
//    @Test
//    public void testDeleteSubCategory() {
//        when(subCategoryRepositary.existsById(1L)).thenReturn(true);
//
//        subCategoryServiceImpl.deleteSubCategory(1L);
//
//        verify(subCategoryRepositary, Mockito.times(1)).deleteById(1L);
//    }
//    @Test
//    public void testAddAttributes() {
//        Attributes attributesToAdd = new Attributes("Color");
//        when(attributesRepository.save(any(Attributes.class))).thenReturn(attributesToAdd);
//
//        Attributes addedAttribute = attributesServiceImpl.createAttribute(attributesToAdd);
//
//        assertEquals("Color", addedAttribute.getName());
////        assertEquals("Red", addedAttribute.getValue());
//    }
//@Test
//public void testGetAttributesById() {
//    Attributes sampleAttributes = new Attributes("Size");
//    when(attributesRepository.findById(1L)).thenReturn(Optional.of(sampleAttributes));
//
//    Optional<Attributes> retrievedAttributes = attributesServiceImpl.getAttributesById(1L);
//
//    assertEquals("Size", retrievedAttributes.get());
////    assertEquals("Large", retrievedAttribute.getValue());
//}
//
//    @Test
//    public void testUpdateAttributes() {
//        Attributes existingAttributes = new Attributes("Size");
//        when(attributesRepository.existsById(1L)).thenReturn(true);
//        when(attributesRepository.save(any(Attributes.class))).thenReturn(existingAttributes);
//
//        Attributes updatedAttributes = attributesServiceImpl.updateAttributes(1L, "Size");
//
//        assertEquals("Size", updatedAttributes.getName());
////        assertEquals("Small", updatedAttributes.getValue());
//    }
//
//    @Test
//    public void testDeleteAttributes() {
//        when(attributesRepository.existsById(1L)).thenReturn(true);
//
//        attributesServiceImpl.deleteAttribute(1L);
//
//        verify(attributesRepository, Mockito.times(1)).deleteById(1L);
//    }
//
//    @Test
//    public void testGetAllAttributes() {
//        Attributes attributes1 = new Attributes("Material", "Cotton");
//        Attributes attributes2 = new Attributes("Weight", "10 lbs");
//        List<Attributes> attributes = Arrays.asList(attributes1, attributes2);
//
//        when(attributesRepository.findAll()).thenReturn(attributes);
//
//        List<Attributes> retrievedAttributes = attributesServiceImpl.getAllAttributes();
//
//        assertEquals(2L, retrievedAttributes.size());
////        assertEquals("Cotton", retrievedAttributes.get(0).getValue());
//        assertEquals("Weight", retrievedAttributes.get(1).getName());
//    }



}