package com.wsgc.PIMbackend.Service.impl;

import com.wsgc.PIMbackend.Service.SkuService;
import com.wsgc.PIMbackend.model.Sku;
import com.wsgc.PIMbackend.repositary.ProductRepositary;
import com.wsgc.PIMbackend.repositary.SkuRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkuServiceImpl implements SkuService {
    private SkuRepositary skuRepositary;
    private ProductRepositary productRepositary;

    @Autowired
    public SkuServiceImpl(SkuRepositary skuRepositary, ProductRepositary productRepository) {
        this.skuRepositary = skuRepositary;
        this.productRepositary = productRepository;
    }

    public List<Sku> getAllSku() {
        return skuRepositary.findAll();
    }

    @Override
    public List<Sku> getAllSkew() {
        return null;
    }

    public Sku getSkuById(Long id) {
        return skuRepositary.findById(id).orElse(null);
    }
    public List<Sku> findByName(String name) {
        return skuRepositary.findByName(name);}
    public List<Sku> findByPrice(Long price) {
        return skuRepositary.findByPrice(price);}

    public Sku createSku(Sku sku) {
        return skuRepositary.save(sku);
    }
    /**
     * @inheritDoc
     */
    public Sku updateSku(Long id, Sku updatedSku) {
        Optional<Sku> existingSku = skuRepositary.findById(id);
        if (existingSku.isPresent()) {
            Sku sku = existingSku.get();
            sku.setName(updatedSku.getName());
            sku.setDescription(updatedSku.getDescription());
            sku.setDiscount(updatedSku.getDiscount());
            sku.setMinimum_selling_price(updatedSku.getMinimum_selling_price());
            sku.setMaximum_selling_price(updatedSku.getMaximum_selling_price());
            sku.setColour(updatedSku.getColour());
            sku.setHeight(updatedSku.getHeight());
            sku.setWidth(updatedSku.getWidth());
            sku.setDepth(updatedSku.getDepth());
            sku.setSize(updatedSku.getSize());
            sku.setWeight(updatedSku.getWeight());
            sku.setPrice(updatedSku.getPrice());
            sku.setStock(updatedSku.getStock());
//            skew.setPrimary(updatedSkew.getPrimary());



            return skuRepositary.save(sku);
        } else {
            return null; // Handle not found
        }
    }

    @Override
    public void deleteSku(Long id) {

    }

    @Override
    public Sku addSkew(Sku skewToAdd) {
        return null;
    }


    public void deleteSkew(Long id) {
        skuRepositary.deleteById(id);
    }

    @Override
    public Sku addSku(Sku skuToAdd) {
        return null;
    }

}
