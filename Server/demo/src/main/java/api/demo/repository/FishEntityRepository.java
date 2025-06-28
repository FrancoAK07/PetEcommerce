package api.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import api.demo.API.Model.FishEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FishEntityRepository extends JpaRepository<FishEntity, Long> {
     @Query(value = "SELECT * FROM fish_products WHERE discount > 0", nativeQuery = true)
    List<FishEntity> findDiscountProducts();

    @Query(value = "SELECT * FROM fish_products WHERE type = 'food'", nativeQuery = true)
    List<FishEntity> getFishFood();

    @Query(value = "SELECT * FROM fish_products WHERE type = 'grooming'", nativeQuery = true)
    List<FishEntity> getFishGrooming();

    List<FishEntity> findByType(String type);

}
