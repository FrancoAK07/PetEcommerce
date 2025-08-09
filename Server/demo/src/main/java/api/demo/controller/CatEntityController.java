package api.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.demo.model.CatEntity;
import api.demo.service.CatEntityService;

import java.util.List;

@RestController
@RequestMapping("/api/catentities")
public class CatEntityController {
    @Autowired
    private CatEntityService catEntityService;

    @PostMapping
    public ResponseEntity<CatEntity> createCatEntity(@RequestBody CatEntity catEntity) {
        CatEntity savedEntity = catEntityService.createCatEntity(catEntity);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CatEntity>> getAllMyEntities() {
        List<CatEntity> entities = catEntityService.getAllMyEntities();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/discounts")
    public ResponseEntity<List<CatEntity>> getDiscountProducts() {
        List<CatEntity> discountProducts = catEntityService.getDiscountProducts();
        return new ResponseEntity<>(discountProducts, HttpStatus.OK);
    }

     @GetMapping("/byType")
    public List<CatEntity> getProductsByType(@RequestParam String type) {
        return catEntityService.findProductsByType(type);
    }

    @GetMapping("/catfood")
    public ResponseEntity<List<CatEntity>> getCatFood() {
        List<CatEntity> catFood = catEntityService.getCatFood();
        return new ResponseEntity<>(catFood, HttpStatus.OK);
    }

    @GetMapping("/catgrooming")
    public ResponseEntity<List<CatEntity>> getCatGrooming() {
        List<CatEntity> catGrooming = catEntityService.getCatGrooming();
        return new ResponseEntity<>(catGrooming, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatEntity> getCatEntityById(@PathVariable Long id) {
        CatEntity entity = catEntityService.getCatEntityById(id);
        if (entity != null) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatEntity> updateCatEntity(@PathVariable Long id, @RequestBody CatEntity catEntity) {
        CatEntity updatedEntity = catEntityService.updateCatEntity(id, catEntity);
        if (updatedEntity != null) {
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMyEntity(@PathVariable Long id) {
        catEntityService.deleteCatEntity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
