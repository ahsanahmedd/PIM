package com.wsgc.PIMbackend.Controller;

import com.wsgc.PIMbackend.Service.AttributesService;
import com.wsgc.PIMbackend.Service.SubCategoryService;
import com.wsgc.PIMbackend.Service.SwatchService;
import com.wsgc.PIMbackend.model.SubCategory;
import com.wsgc.PIMbackend.model.Swatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supercategories/swatches")
public class SwatchController {


    private SwatchService swatchService;
    private AttributesService attributesService;
    /**
     * Constructor
     * @return
     */
    @Autowired
    public SwatchController(SwatchService swatchService,AttributesService attributesService){
        this.swatchService = swatchService;
        this.attributesService = attributesService;
    }

    /**
     *Retrieve and return all swatches
     */
    @GetMapping
    public List<Swatch> getAllSwatches() {
        return swatchService.getAllSwatches();
    }

    /**
     *Retrieve and return a swatch by its ID
     */

    @GetMapping("/{id}")
    public Optional<Swatch> getSwatchById(@PathVariable Long id) {
        return swatchService.getSwatchById(id);
    }
//    @GetMapping("/name")
//    public ResponseEntity<List<Swatch>> getSwatchByName(@RequestParam String name){
//        List<Swatch> swatch = swatchService.findByName(name);
//        return ResponseEntity.ok(swatch);
//    }

    /**
     *  Create and return a new swatch
     * @param swatch objects
     * @return the {@link Swatch} objects
     */
    @PostMapping
    public Swatch createSwatch(@RequestBody Swatch swatch) {
        return swatchService.createSwatch(swatch);
    }

    /**
     * Update and return the updated swatch
     *  @param id the identification number for categories
     *  @param swatch
     *  @return the {@link Swatch} objects
     */
    @PutMapping("/{id}")
    public Swatch updateSwatch(@PathVariable Long id, @RequestBody Swatch swatch) {
        return swatchService.updateSwatch(id, swatch);
    }

    /**
     * Delete a swatch by its ID
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteSwatch(@PathVariable Long id) {
        swatchService.deleteSwatch(id);
    }
}

