package api.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.demo.model.DogEntity;
import api.demo.service.DogEntityService;

import java.util.List;

@RestController
@RequestMapping("/api/dogproducts")
public class DogEntityController {
    @Autowired
    private DogEntityService myEntityService;

    @PostMapping
    public ResponseEntity<DogEntity> createDogEntity(@RequestBody DogEntity myEntity) {
        DogEntity savedEntity = myEntityService.createDogEntity(myEntity);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DogEntity>> getAllMyEntities() {
        List<DogEntity> entities = myEntityService.getAllMyEntities();
        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

    @GetMapping("/discounts")
    public ResponseEntity<List<DogEntity>> getDiscountProducts() {
        List<DogEntity> discountProducts = myEntityService.getDiscountProducts();
        return new ResponseEntity<>(discountProducts, HttpStatus.OK);
    }

     @GetMapping("/byType")
    public List<DogEntity> getProductsByCategory(@RequestParam String type) {
        return myEntityService.findProductByCategory(type);
    }

    @GetMapping("/dogfood")
    public ResponseEntity<List<DogEntity>> getDogFood() {
        List<DogEntity> dogFood = myEntityService.getDogFood();
        return new ResponseEntity<>(dogFood, HttpStatus.OK);
    }

    @GetMapping("/doggrooming")
    public ResponseEntity<List<DogEntity>> getDogGrooming() {
        List<DogEntity> dogGrooming = myEntityService.getDogGrooming();
        return new ResponseEntity<>(dogGrooming, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DogEntity> getDogEntityById(@PathVariable Long id) {
        DogEntity entity = myEntityService.getDogEntityById(id);
        if (entity != null) {
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DogEntity> updateDogEntity(@PathVariable Long id, @RequestBody DogEntity myEntity) {
        DogEntity updatedEntity = myEntityService.updateDogEntity(id, myEntity);
        if (updatedEntity != null) {
            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDogEntity(@PathVariable Long id) {
        myEntityService.deleteDogEntity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
