package api.demo.Service;
import api.demo.API.Model.BirdEntity;
import java.util.List;

public interface BirdEntityService {
    BirdEntity createBirdEntity(BirdEntity birdEntity);
    List<BirdEntity> getAllMyEntities();
    BirdEntity getBirdEntityById(Long id);
    BirdEntity updateBirdEntity(Long id, BirdEntity birdEntity);
    void deleteBirdEntity(Long id);
    List<BirdEntity> getDiscountProducts();
    List<BirdEntity> getBirdFood();
    List<BirdEntity> getBirdGrooming();
    List<BirdEntity> getProductsByType(String type);

}
