package api.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.demo.model.DogEntity;
import api.demo.repository.DogEntityRepository;
import java.util.List;
import java.util.Optional;

@Service
public class DogEntityServiceImpl implements DogEntityService {
    @Autowired
    private DogEntityRepository myEntityRepository;

    @Override
    public DogEntity createDogEntity(DogEntity myEntity) {
        return myEntityRepository.save(myEntity); // Save the entity in the database
    }

    @Override
    public List<DogEntity> getAllMyEntities() {
        List<DogEntity> entities = myEntityRepository.findAll();
        return entities; // Return all entities
    }

    @Override
    public DogEntity getDogEntityById(Long id) {
        Optional<DogEntity> myEntity = myEntityRepository.findById(id);
        return myEntity.orElse(null); // Return the entity or null if not found
    }

    @Override
    public DogEntity updateDogEntity(Long id, DogEntity myEntity) {
        if (myEntityRepository.existsById(id)) {
            myEntity.setId(id); // Make sure to set the ID for updating
            return myEntityRepository.save(myEntity); // Save the updated entity
        }
        return null; // Entity not found, return null or throw an exception
    }

    @Override
    public void deleteDogEntity(Long id) {
        myEntityRepository.deleteById(id); // Delete the entity by ID
    }

    @Override
    public List<DogEntity> getDiscountProducts() {
        List<DogEntity> discountProducts = myEntityRepository.findDiscountProducts();
        return discountProducts;
    }

    @Override
    public List<DogEntity> getDogFood() {
        List<DogEntity> dogFood = myEntityRepository.getDogFood();
        return dogFood;
    }

    @Override
    public List<DogEntity> getDogGrooming() {
        List<DogEntity> dogGrooming = myEntityRepository.getDogGrooming();
        return dogGrooming;
    }

    @Override
    public List<DogEntity> findProductByType(String type) {
        List<DogEntity> products = myEntityRepository.findByType(type);
        return products;
    }
}
