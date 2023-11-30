package com.wsgc.PIMbackend.repositary;
import com.wsgc.PIMbackend.model.Product;
import com.wsgc.PIMbackend.model.Skew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkewRepositary extends JpaRepository<Skew, Long> {

        List<Skew> findByName(String name);
    List<Skew> findByPrice(Long price);

}
