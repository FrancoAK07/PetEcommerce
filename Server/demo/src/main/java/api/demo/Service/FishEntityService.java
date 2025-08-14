package api.demo.service;
import api.demo.model.FishEntity;
import java.util.List;

public interface FishEntityService {
    FishEntity createFishEntity(FishEntity fishEntity);
    List<FishEntity> getAllMyEntities();
    FishEntity getFishEntityById(Long id);
    FishEntity updateFishEntity(Long id, FishEntity fishEntity);
    void deleteFishEntity(Long id);
    List<FishEntity> getDiscountProducts();
    List<FishEntity> getFishFood();
    List<FishEntity> getFishGrooming();
    List<FishEntity> getProductsByCategory(String type);
}
