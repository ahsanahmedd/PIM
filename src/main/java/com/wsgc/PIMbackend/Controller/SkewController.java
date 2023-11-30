package com.wsgc.PIMbackend.Controller;

import com.wsgc.PIMbackend.Service.ProductService;
import com.wsgc.PIMbackend.Service.SkewService;
import com.wsgc.PIMbackend.Service.impl.ProductServiceImpl;
import com.wsgc.PIMbackend.Service.SubCategoryService;
import com.wsgc.PIMbackend.Service.impl.SkewServiceImpl;
import com.wsgc.PIMbackend.model.Product;
import com.wsgc.PIMbackend.model.Skew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/supercategories/skew")
public class SkewController {
    private final SkewService skewService;
    private final ProductService productService;

    @Autowired
    public SkewController(SkewServiceImpl skewService, ProductService productService) {
        this.skewService = skewService;
        this.productService = productService;
    }
    @GetMapping
    public List<Skew> getAllSkew() {
        return skewService.getAllSkew();
    }
    /**
     *Retrieve and return a Skew by its ID
     * @param SkewId objects
     * @return the {@link Skew}objects
     */

    @GetMapping("/{SkewId}")
    public Skew getSkewById(@PathVariable Long SkewId) {
        return skewService.getSkewById(SkewId);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Skew>> getSkewByName(@RequestParam String name){
        List<Skew> skew = skewService.findByName(name);
        return ResponseEntity.ok(skew);
    }
    @GetMapping("/price")
    public ResponseEntity<List<Skew>> getSkewByPrice(@RequestParam Long price){
        List<Skew> skew = skewService.findByPrice(price);
        return ResponseEntity.ok(skew);
    }
    /**
     *  Create and return a new Skew
     * @param skew objects
     * @return the {@link Skew} objects
     */

    @PostMapping
    public Skew createSkew(@RequestBody Skew skew) {
        return skewService.createSkew(skew);
    }
    /**
     * Update and return the updated Skew
     *  @param id the identification number for skew
     *  @param skew
     *  @return the {@link Skew} objects
     */
    @PutMapping("/{id}")
    public Skew updateSkew(@PathVariable Long id, @RequestBody Skew skew) {
        return skewService.updateSkew(id, skew);
    }
    /**
     * Delete a Skew by its ID
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteSkew(@PathVariable Long id) {
        skewService.deleteSkew(id);
    }
}



