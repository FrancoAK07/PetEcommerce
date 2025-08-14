package api.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.demo.model.FishEntity;
import api.demo.service.FishEntityService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/fishproducts")
public class FishEntityController {
    @Autowired
    private FishEntityService fishEntityService;

    @PostMapping
    public ResponseEntity<FishEntity> createFishEntity(@RequestBody FishEntity fishEntity) {
        FishEntity savedEntity = fishEntityService.createFishEntity(fishEntity);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FishEntity>> getAllMyEntities() {
        List<FishEntity> entities = fishEntityService.getAllMyEntities();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/discounts")
    public ResponseEntity<List<FishEntity>> getDiscountProducts() {
        List<FishEntity> discountProducts = fishEntityService.getDiscountProducts();
        return new ResponseEntity<>(discountProducts, HttpStatus.OK);
    }

    @GetMapping("/byType")
    public List<FishEntity> getproductsByCategory(@RequestParam String type) {
        return fishEntityService.getProductsByCategory(type);
    }


    @GetMapping("/catfood")
    public ResponseEntity<List<FishEntity>> getCatFood() {
        List<FishEntity> catFood = fishEntityService.getFishFood();
        return new ResponseEntity<>(catFood, HttpStatus.OK);
    }

    @GetMapping("/catgrooming")
    public ResponseEntity<List<FishEntity>> getCatGrooming() {
        List<FishEntity> catGrooming = fishEntityService.getFishGrooming();
        return new ResponseEntity<>(catGrooming, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FishEntity> getFishEntityById(@PathVariable Long id) {
        FishEntity entity = fishEntityService.getFishEntityById(id);
        if (entity != null) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FishEntity> updateFishEntity(@PathVariable Long id, @RequestBody FishEntity fishEntity) {
        FishEntity updatedEntity = fishEntityService.updateFishEntity(id, fishEntity);
        if (updatedEntity != null) {
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMyEntity(@PathVariable Long id) {
        fishEntityService.deleteFishEntity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
