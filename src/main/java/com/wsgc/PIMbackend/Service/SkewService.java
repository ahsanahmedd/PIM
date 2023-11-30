package com.wsgc.PIMbackend.Service;

import com.wsgc.PIMbackend.model.Skew;

import java.util.List;

public interface SkewService {
    public List<Skew> getAllSkew();
    /**
     * Retrieve a Skew by its ID from the repository
     * @param id objects
     * @return the {@link Skew} objects
     */
    public Skew getSkewById(Long id);
    public  List<Skew> findByName(String name);
    public List<Skew> findByPrice(Long price);

    /**
     * Create a new Skew in the repository
     * @param skew objects
     * @return the {@link Skew} objects
     */
    public Skew createSkew(Skew skew);
    /**
     * Update an existing Skew in the repository
     *  @param id the identification number for Skew
     *  @return the {@link Skew} objects
     */
    public Skew updateSkew(Long id, Skew updatedSkew);
    /**
     * Delete a Skew by its ID from the repository
     *
     * @param id
     */
    public void deleteSkew(Long id);

    Skew addSkew(Skew skewToAdd);
}
