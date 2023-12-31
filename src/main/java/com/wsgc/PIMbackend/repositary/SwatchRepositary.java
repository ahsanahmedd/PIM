package com.wsgc.PIMbackend.repositary;

import com.wsgc.PIMbackend.model.Product;
import com.wsgc.PIMbackend.model.Swatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for Swatch entity.
 */
@Repository
public interface SwatchRepositary extends JpaRepository<Swatch, Long> {
//    List<Swatch> findByName(String name);

}

