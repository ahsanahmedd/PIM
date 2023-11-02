
package com.wsgc.PIMbackend.Controller;


import com.wsgc.PIMbackend.Service.AttributesService;
import com.wsgc.PIMbackend.Service.ProductService;
import com.wsgc.PIMbackend.model.Attributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
/**
 * The Controller class manages the flow of data and user interactions in an application, often serving as an intermediary between the model and view components in the Model-View-Controller (MVC) architectural pattern.
 */
@RestController
@RequestMapping("/attributes")
public class AttributesController {
    private AttributesService attributesService;
    private ProductService productService;

    @Autowired
    public AttributesController(AttributesService attributeService,ProductService productService) {
        this.attributesService = attributeService;
        this.productService = productService;
    }
    /**
     *Retrieve and return all Attributes
     */
    @GetMapping
    public List<Attributes> getAllAttributes() {
        return attributesService.getAllAttributes();
    }
    /**
     *Retrieve and return a Attributes by its ID
     * @param id objects
     * @return the {@link Attributes} object
     */
    @GetMapping("/{AttributesID}")
    public Optional<Attributes> getAttributesById(@PathVariable Long id) {
        return attributesService.getAttributesById(id);
    }
    /**
     * Create and return a new Attributes
     * @param attributes objects
     * @return the {@link Attributes} object
     */
    @PostMapping
    public Attributes createAttributes(@RequestBody Attributes attributes) {
        return attributesService.createAttribute(attributes);
    }
    /**
     * Update and return the updated Attributes
     * @param id the identification number for attributes
     * @param attributes
     * @return the {@link Attributes} object
     */
    @PutMapping("/{id}")
    public Attributes updateAttributes(@PathVariable Long id, @RequestBody Attributes attributes) {
        return attributesService.createAttribute(attributes);
    }
    /**
     * Delete a Attributes by its ID
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteAttribute(@PathVariable Long id) {
        attributesService.deleteAttribute(id);
    }
}


