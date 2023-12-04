package com.wsgc.PIMbackend.repositary;
import com.wsgc.PIMbackend.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuRepositary extends JpaRepository<Sku, Long> {

        List<Sku> findByName(String name);
    List<Sku> findByPrice(Long price);

}
