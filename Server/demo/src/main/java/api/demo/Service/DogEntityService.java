package api.demo.Service;
import api.demo.API.Model.DogEntity;
import java.util.List;

public interface DogEntityService {
    DogEntity createDogEntity(DogEntity myEntity);
    List<DogEntity> getAllMyEntities();
    DogEntity getDogEntityById(Long id);
    DogEntity updateDogEntity(Long id, DogEntity myEntity);
    void deleteDogEntity(Long id);
    List<DogEntity> getDiscountProducts();
    List<DogEntity> getDogFood();
    List<DogEntity> getDogGrooming();
    List<DogEntity> findProductByType(String type);
}
