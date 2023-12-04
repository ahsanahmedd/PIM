package com.wsgc.PIMbackend.Service;

import com.wsgc.PIMbackend.model.Sku;

import java.util.List;

public interface SkuService {
    public List<Sku> getAllSkew();
    /**
     * Retrieve a Skew by its ID from the repository
     * @param id objects
     * @return the {@link Sku} objects
     */
    public Sku getSkuById(Long id);
    public  List<Sku> findByName(String name);
    public List<Sku> findByPrice(Long price);

    /**
     * Create a new Skew in the repository
     * @param sku objects
     * @return the {@link Sku} objects
     */
    public Sku createSku(Sku sku);
    /**
     * Update an existing Skew in the repository
     *  @param id the identification number for Skew
     *  @return the {@link Sku} objects
     */
    public Sku updateSku(Long id, Sku updatedSkew);
    /**
     * Delete a Skew by its ID from the repository
     *
     * @param id
     */
    public void deleteSku(Long id);

    Sku addSkew(Sku skewToAdd);

    List<Sku> getAllSku();

    Sku addSku(Sku skuToAdd);
}
