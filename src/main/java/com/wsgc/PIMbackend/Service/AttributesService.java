
package com.wsgc.PIMbackend.Service;

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
public interface AttributesService {

    /**
     * Retrieve all Attributes from the repository
     * @return
     */
    public List<Attributes> getAllAttributes();
    /**
     * Retrieve a Attributes by its ID from the repository
     * @param id objects
     * @return the {@link Attributes} object
     */
    public Optional<Attributes> getAttributesById(Long id);
    public  List<Attributes> findByName(String name);
    /**
     * Create a new Attributes in the repository
     */
    public Attributes createAttribute(Attributes attribute);
    /**
     * Update an existing Attributes in the repository
     * @param id
     */
    public Attributes updateAttributes(Long id, Attributes attributes);
    /**
     * Delete a Attributes by its ID from the repository
     * @param id
     */
    public void deleteAttribute(Long id);
}
