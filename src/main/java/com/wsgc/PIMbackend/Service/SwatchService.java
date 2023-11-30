package com.wsgc.PIMbackend.Service;

import com.wsgc.PIMbackend.model.Product;
import com.wsgc.PIMbackend.model.Swatch;
import com.wsgc.PIMbackend.repositary.AttributesRepository;
import com.wsgc.PIMbackend.repositary.SwatchRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SwatchService {
    /**
     * @inheritDoc
     */

    public List<Swatch> getAllSwatches();
    /**
     * @inheritDoc
     */
    public Optional<Swatch> getSwatchById(Long id);
//    public  List<Swatch> findByName(String name);
    /**
     * @inheritDoc
     */
    public Swatch createSwatch(Swatch swatch);
    /**
     * @inheritDoc
     */
    public Swatch updateSwatch(Long id, Swatch updateSwatch);
    /**
     * @inheritDoc
     */
    public void deleteSwatch(Long id);
}
