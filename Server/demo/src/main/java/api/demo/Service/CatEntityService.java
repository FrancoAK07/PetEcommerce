package api.demo.service;
import api.demo.model.CatEntity;
import java.util.List;

public interface CatEntityService {
    CatEntity createCatEntity(CatEntity catEntity);
    List<CatEntity> getAllMyEntities();
    CatEntity getCatEntityById(Long id);
    CatEntity updateCatEntity(Long id, CatEntity catEntity);
    void deleteCatEntity(Long id);
    List<CatEntity> getDiscountProducts();
    List<CatEntity> getCatFood();
    List<CatEntity> getCatGrooming();
    List<CatEntity> findProductsByCategory(String type);
}
