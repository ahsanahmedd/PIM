
package com.wsgc.PIMbackend.Service;
import com.wsgc.PIMbackend.model.Attributes;
import com.wsgc.PIMbackend.model.Category;
import com.wsgc.PIMbackend.repositary.AttributesRepository;


import com.wsgc.PIMbackend.repositary.ProductRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * The Service class encapsulates functionality and resources for providing specific services within a software application or system.
 */
@Service
public class AttributesService {
    private AttributesRepository attributesRepository;
    private ProductRepositary productRepositary;
    /**
     * Constructor
     * @return
     */
    @Autowired
    public AttributesService(AttributesRepository attributeRepository,ProductRepositary productRepositary) {
        this.attributesRepository = attributeRepository;
        this.productRepositary = productRepositary;
    }
    /**
     * Retrieve all Attributes from the repository
     * @return
     */
    public List<Attributes> getAllAttributes() {
        return attributesRepository.findAll();
    }
    /**
     * Retrieve a Attributes by its ID from the repository
     * @param id
     * @return
     */
    public Optional<Attributes> getAttributesById(Long id) {
        return attributesRepository.findById(id);
    }
    /**
     * Create a new Attributes in the repository
     * @return
     */
    public Attributes createAttribute(Attributes attribute) {
        return attributesRepository.save(attribute);
    }
    /**
     * Update an existing Attributes in the repository
     * @param id
     * @return
     */
    public Attributes updateAttributes(Long id, Attributes attributes) {
        if (attributesRepository.existsById(id)) {
            attributes.setId(id);
            attributes.setName(attributes.getName());
            attributes.setSeoCopy(attributes.getSeoCopy());
            attributes.setDescription(attributes.getDescription());
            return attributesRepository.save(attributes);
        }
        return null;
    }
    /**
     * Delete a Attributes by its ID from the repository
     * @param id
     */
    public void deleteAttribute(Long id) {
        attributesRepository.deleteById(id);
    }
}
