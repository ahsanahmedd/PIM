package com.wsgc.PIMbackend.Service.impl;

import com.wsgc.PIMbackend.Service.SwatchService;
import com.wsgc.PIMbackend.model.Product;
import com.wsgc.PIMbackend.model.Swatch;
import com.wsgc.PIMbackend.repositary.AttributesRepository;
import com.wsgc.PIMbackend.repositary.SwatchRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SwatchServiceImpl implements SwatchService {

    @Autowired
    private SwatchRepositary swatchRepository;
    private AttributesRepository attributesRepository;
    /**
     * Constructor
     */
    @Autowired

    public SwatchServiceImpl(SwatchRepositary swatchRepositary, AttributesRepository attributesRepository){
        this.swatchRepository = swatchRepositary;
        this.attributesRepository = attributesRepository;
    }


    /**
     * Retrieve all swatches from the repository
     */

    public List<Swatch> getAllSwatches() {
        return swatchRepository.findAll();
    }

    /**
     * Retrieve a swatch by its ID from the repository
     * @param id
     */
    public Optional<Swatch> getSwatchById(Long id) {
        return swatchRepository.findById(id);
    }
//    public List<Swatch> findByName(String name) {
//        return swatchRepository.findByName(name);}

    /**
     * Create a new swatch in the repository
     * @param swatch
     * @return the {@link Swatch} objects
     */
    public Swatch createSwatch(Swatch swatch) {
        return swatchRepository.save(swatch);
    }

    /**
     * Update an existing swatch in the repository
     * @param id
     * @param updateSwatch
     * @return the {@link Swatch} objects
     */
    public Swatch updateSwatch(Long id, Swatch updateSwatch) {
        Optional<Swatch> existingProduct = swatchRepository.findById(id);
        if (existingProduct.isPresent()) {
            Swatch swatch = existingProduct.get();
            swatch.setId(updateSwatch.getId());
            swatch.setImageURL(updateSwatch.getImageURL());
            swatch.setDescription(updateSwatch.getDescription());


            return swatchRepository.save(swatch);
        } else {
            return null; // Handle not found
        }
    }


    /**
     * Delete a swatch by its ID from the repository
     * @param id
     */
    public void deleteSwatch(Long id) {
        swatchRepository.deleteById(id);
    }
}
