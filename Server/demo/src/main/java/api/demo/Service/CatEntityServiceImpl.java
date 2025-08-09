package api.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.demo.model.CatEntity;
import api.demo.repository.CatEntityRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CatEntityServiceImpl implements CatEntityService {
    @Autowired
    private CatEntityRepository catEntityRepository;

    @Override
    public CatEntity createCatEntity(CatEntity catEntity) {
        return catEntityRepository.save(catEntity); // Save the entity in the database
    }

    @Override
    public List<CatEntity> getAllMyEntities() {
        List<CatEntity> entities = catEntityRepository.findAll();
        return entities; // Return all entities
    }

    @Override
    public CatEntity getCatEntityById(Long id) {
        Optional<CatEntity> catEntity = catEntityRepository.findById(id);
        return catEntity.orElse(null); // Return the entity or null if not found
    }

    @Override
    public CatEntity updateCatEntity(Long id, CatEntity catEntity) {
        if (catEntityRepository.existsById(id)) {
            catEntity.setId(id); // Make sure to set the ID for updating
            return catEntityRepository.save(catEntity); // Save the updated entity
        }
        return null; // Entity not found, return null or throw an exception
    }

    @Override
    public void deleteCatEntity(Long id) {
        catEntityRepository.deleteById(id); // Delete the entity by ID
    }

    @Override
    public List<CatEntity> getDiscountProducts() {
        List<CatEntity> discountProducts = catEntityRepository.findDiscountProducts();
        return discountProducts;
    }

    @Override
    public List<CatEntity> getCatFood() {
        List<CatEntity> catFood = catEntityRepository.getCatFood();
        return catFood;
    }

    @Override
    public List<CatEntity> getCatGrooming() {
        List<CatEntity> catGrooming = catEntityRepository.getCatGrooming();
        return catGrooming;
    }

    @Override
    public List<CatEntity> findProductsByType(String type) {
        List<CatEntity> products = catEntityRepository.findByType(type);
        return products;
    }

}
