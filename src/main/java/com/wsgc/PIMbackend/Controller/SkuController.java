package com.wsgc.PIMbackend.Controller;

import com.wsgc.PIMbackend.Service.ProductService;
import com.wsgc.PIMbackend.Service.SkuService;
import com.wsgc.PIMbackend.Service.impl.SkuServiceImpl;
import com.wsgc.PIMbackend.model.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/supercategories/sku")
public class SkuController {
    private final SkuService skuService;
    private final ProductService productService;

    @Autowired
    public SkuController(SkuServiceImpl skuService, ProductService productService) {
        this.skuService = skuService;
        this.productService = productService;
    }
    @GetMapping
    public List<Sku> getAllSku() {
        return skuService.getAllSku();
    }
    /**
     *Retrieve and return a Skew by its ID
     * @param SkuId objects
     * @return the {@link Sku}objects
     */

    @GetMapping("/{SkuId}")
    public Sku getSkuById(@PathVariable Long SkuId) {
        return skuService.getSkuById(SkuId);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Sku>> getSkuByName(@RequestParam String name){
        List<Sku> sku = skuService.findByName(name);
        return ResponseEntity.ok(sku);
    }
    @GetMapping("/price")
    public ResponseEntity<List<Sku>> getSkuByPrice(@RequestParam Long price){
        List<Sku> sku = skuService.findByPrice(price);
        return ResponseEntity.ok(sku);
    }
    /**
     *  Create and return a new Skew
     * @param sku objects
     * @return the {@link Sku} objects
     */

    @PostMapping
    public Sku createSku(@RequestBody Sku sku) {
        return skuService.createSku(sku);
    }
    /**
     * Update and return the updated Skew
     *  @param id the identification number for skew
     *  @param sku
     *  @return the {@link Sku} objects
     */
    @PutMapping("/{id}")
    public Sku updateSku(@PathVariable Long id, @RequestBody Sku sku) {
        return skuService.updateSku(id, sku);
    }
    /**
     * Delete a Skew by its ID
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteSku(@PathVariable Long id) {
        skuService.deleteSku(id);
    }
}



