package api.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.demo.model.BirdEntity;
import api.demo.service.BirdEntityService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/birdproducts")
public class BirdEntityController {
    @Autowired
    private BirdEntityService birdEntityService;

    @PostMapping
    public ResponseEntity<BirdEntity> createBirdEntity(@RequestBody BirdEntity birdEntity) {
        BirdEntity savedEntity = birdEntityService.createBirdEntity(birdEntity);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BirdEntity>> getAllMyEntities() {
        List<BirdEntity> entities = birdEntityService.getAllMyEntities();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/discounts")
    public ResponseEntity<List<BirdEntity>> getDiscountProducts() {
        List<BirdEntity> discountProducts = birdEntityService.getDiscountProducts();
        return new ResponseEntity<>(discountProducts, HttpStatus.OK);
    }

    @GetMapping("/byType")
    public List<BirdEntity> getProductsByType(@RequestParam String type) {
        return birdEntityService.getProductsByCategory(type);
    }


    @GetMapping("/birdfood")
    public ResponseEntity<List<BirdEntity>> getBirdFood() {
        List<BirdEntity> birdFood = birdEntityService.getBirdFood();
        return new ResponseEntity<>(birdFood, HttpStatus.OK);
    }

    @GetMapping("/birdgrooming")
    public ResponseEntity<List<BirdEntity>> getBirdGrooming() {
        List<BirdEntity> birdGrooming = birdEntityService.getBirdGrooming();
        return new ResponseEntity<>(birdGrooming, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BirdEntity> getBirdEntityById(@PathVariable Long id) {
        BirdEntity entity = birdEntityService.getBirdEntityById(id);
        if (entity != null) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BirdEntity> updateBirdEntity(@PathVariable Long id, @RequestBody BirdEntity birdEntity) {
        BirdEntity updatedEntity = birdEntityService.updateBirdEntity(id, birdEntity);
        if (updatedEntity != null) {
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMyEntity(@PathVariable Long id) {
        birdEntityService.deleteBirdEntity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
