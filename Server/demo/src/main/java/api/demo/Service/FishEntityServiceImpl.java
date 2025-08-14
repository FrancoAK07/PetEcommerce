package api.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.demo.model.FishEntity;
import api.demo.repository.FishEntityRepository;
import java.util.List;
import java.util.Optional;

@Service
public class FishEntityServiceImpl implements FishEntityService {
     @Autowired
    private FishEntityRepository fishEntityRepository;

    @Override
    public FishEntity createFishEntity(FishEntity fishEntity) {
        return fishEntityRepository.save(fishEntity); // Save the entity in the database
    }

    @Override
    public List<FishEntity> getAllMyEntities() {
        List<FishEntity> entities = fishEntityRepository.findAll();
        return entities; // Return all entities
    }

    @Override
    public FishEntity getFishEntityById(Long id) {
        Optional<FishEntity> fishEntity = fishEntityRepository.findById(id);
        return fishEntity.orElse(null); // Return the entity or null if not found
    }

    @Override
    public FishEntity updateFishEntity(Long id, FishEntity fishEntity) {
        if (fishEntityRepository.existsById(id)) {
            fishEntity.setId(id); // Make sure to set the ID for updating
            return fishEntityRepository.save(fishEntity); // Save the updated entity
        }
        return null; // Entity not found, return null or throw an exception
    }

    @Override
    public void deleteFishEntity(Long id) {
        fishEntityRepository.deleteById(id); // Delete the entity by ID
    }

    @Override
    public List<FishEntity> getDiscountProducts() {
        List<FishEntity> discountProducts = fishEntityRepository.findDiscountProducts();
        return discountProducts;
    }

    @Override
    public List<FishEntity> getFishFood() {
        List<FishEntity> fishFood = fishEntityRepository.getFishFood();
        return fishFood;
    }

    @Override
    public List<FishEntity> getFishGrooming() {
        List<FishEntity> fishGrooming = fishEntityRepository.getFishGrooming();
        return fishGrooming;
    }

    @Override
    public List<FishEntity> getProductsByCategory(String type) {
        List<FishEntity> products = fishEntityRepository.findByCategory(type);
        return products;
    }
}
