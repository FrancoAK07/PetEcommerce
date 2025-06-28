package api.demo.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.demo.API.Model.BirdEntity;
import api.demo.repository.BirdEntityRepository;


import java.util.List;
import java.util.Optional;

@Service
public class BirdEntityServiceImpl implements BirdEntityService {
    @Autowired
    private BirdEntityRepository birdEntityRepository;

    @Override
    public BirdEntity createBirdEntity(BirdEntity birdEntity) {
        return birdEntityRepository.save(birdEntity); // Save the entity in the database
    }

    @Override
    public List<BirdEntity> getAllMyEntities() {
        List<BirdEntity> entities = birdEntityRepository.findAll();
        return entities; // Return all entities
    }

    @Override
    public BirdEntity getBirdEntityById(Long id) {
        Optional<BirdEntity> birdEntity = birdEntityRepository.findById(id);
        return birdEntity.orElse(null); // Return the entity or null if not found
    }

    @Override
    public BirdEntity updateBirdEntity(Long id, BirdEntity birdEntity) {
        if (birdEntityRepository.existsById(id)) {
            birdEntity.setId(id); // Make sure to set the ID for updating
            return birdEntityRepository.save(birdEntity); // Save the updated entity
        }
        return null; // Entity not found, return null or throw an exception
    }

    @Override
    public void deleteBirdEntity(Long id) {
        birdEntityRepository.deleteById(id); // Delete the entity by ID
    }

    @Override
    public List<BirdEntity> getDiscountProducts() {
        List<BirdEntity> discountProducts = birdEntityRepository.findDiscountProducts();
        return discountProducts;
    }

    @Override
    public List<BirdEntity> getBirdFood() {
        List<BirdEntity> birdFood = birdEntityRepository.getBirdFood();
        return birdFood;
    }

    @Override
    public List<BirdEntity> getBirdGrooming() {
        List<BirdEntity> birdGrooming = birdEntityRepository.getBirdGrooming();
        return birdGrooming;
    }

    @Override
    public List<BirdEntity> getProductsByType(String type) {
        List<BirdEntity> products = birdEntityRepository.findByType(type);
        return products;
    }
}
