package com.wsgc.PIMbackend.Service.impl;

import com.wsgc.PIMbackend.Service.SkewService;
import com.wsgc.PIMbackend.model.Product;
import com.wsgc.PIMbackend.model.Skew;
import com.wsgc.PIMbackend.repositary.ProductRepositary;
import com.wsgc.PIMbackend.repositary.SkewRepositary;
import com.wsgc.PIMbackend.repositary.SubCategoryRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkewServiceImpl implements SkewService {
    private SkewRepositary skewRepositary;
    private ProductRepositary productRepositary;

    @Autowired
    public SkewServiceImpl(SkewRepositary skewRepositary, ProductRepositary productRepository) {
        this.skewRepositary = skewRepositary;
        this.productRepositary = productRepository;
    }

    public List<Skew> getAllSkew() {
        return skewRepositary.findAll();
    }
    public Skew getSkewById(Long id) {
        return skewRepositary.findById(id).orElse(null);
    }
    public List<Skew> findByName(String name) {
        return skewRepositary.findByName(name);}
    public List<Skew> findByPrice(Long price) {
        return skewRepositary.findByPrice(price);}

    public Skew createSkew(Skew skew) {
        return skewRepositary.save(skew);
    }
    /**
     * @inheritDoc
     */
    public Skew updateSkew(Long id, Skew updatedSkew) {
        Optional<Skew> existingSkew = skewRepositary.findById(id);
        if (existingSkew.isPresent()) {
            Skew skew = existingSkew.get();
            skew.setName(updatedSkew.getName());
            skew.setDescription(updatedSkew.getDescription());
            skew.setDiscount(updatedSkew.getDiscount());
            skew.setMinimum_selling_price(updatedSkew.getMinimum_selling_price());
            skew.setMaximum_selling_price(updatedSkew.getMaximum_selling_price());
            skew.setColour(updatedSkew.getColour());
            skew.setHeight(updatedSkew.getHeight());
            skew.setWidth(updatedSkew.getWidth());
            skew.setDepth(updatedSkew.getDepth());
            skew.setSize(updatedSkew.getSize());
            skew.setWeight(updatedSkew.getWeight());
            skew.setPrice(updatedSkew.getPrice());
            skew.setStock(updatedSkew.getStock());



            return skewRepositary.save(skew);
        } else {
            return null; // Handle not found
        }
    }


    public void deleteSkew(Long id) {
        skewRepositary.deleteById(id);
    }

    @Override
    public Skew addSkew(Skew skewToAdd) {
        return null;
    }

}
