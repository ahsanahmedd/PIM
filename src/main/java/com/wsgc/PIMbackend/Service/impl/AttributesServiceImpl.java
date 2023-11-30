
package com.wsgc.PIMbackend.Service.impl;

import com.wsgc.PIMbackend.Service.AttributesService;
import com.wsgc.PIMbackend.model.Attributes;
import com.wsgc.PIMbackend.model.Product;
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
public class AttributesServiceImpl implements AttributesService {
    private AttributesRepository attributesRepository;
    private ProductRepositary productRepositary;
    /**
     * @inheritDoc
     */
    @Autowired
    public AttributesServiceImpl(AttributesRepository attributeRepository, ProductRepositary productRepositary) {
        this.attributesRepository = attributeRepository;
        this.productRepositary = productRepositary;
    }
    /**
     * @inheritDoc
     */
    public List<Attributes> getAllAttributes() {
        return attributesRepository.findAll();
    }
    /**
     * @inheritDoc
     */
    public Optional<Attributes> getAttributesById(Long id) {
        return attributesRepository.findById(id);
    }
    public List<Attributes> findByName(String name) {
        return attributesRepository.findByName(name);}
    /**
     * @inheritDoc
     */
    public Attributes createAttribute(Attributes attribute) {
        return attributesRepository.save(attribute);
    }
    /**
     * @inheritDoc
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
     * @inheritDoc
     */
    public void deleteAttribute(Long id) {
        attributesRepository.deleteById(id);
    }
}
