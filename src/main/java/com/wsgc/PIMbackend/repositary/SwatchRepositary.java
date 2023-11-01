package com.wsgc.PIMbackend.repositary;

import com.wsgc.PIMbackend.model.Swatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for Swatch entity.
 */
@Repository
public interface SwatchRepositary extends JpaRepository<Swatch, Long> {
}

