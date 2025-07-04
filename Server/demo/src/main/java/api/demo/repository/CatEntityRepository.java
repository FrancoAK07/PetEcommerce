package api.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import api.demo.API.Model.CatEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CatEntityRepository extends JpaRepository<CatEntity, Long>{
    @Query(value = "SELECT * FROM cat_products WHERE discount > 0", nativeQuery = true)
    List<CatEntity> findDiscountProducts();

    @Query(value = "SELECT * FROM cat_products WHERE type = 'food'", nativeQuery = true)
    List<CatEntity> getCatFood();

    @Query(value = "SELECT * FROM cat_products WHERE type = 'grooming'", nativeQuery = true)
    List<CatEntity> getCatGrooming();

    List<CatEntity> findByType(String type);

}
