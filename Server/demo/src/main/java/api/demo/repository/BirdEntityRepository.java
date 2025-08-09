package api.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import api.demo.model.BirdEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BirdEntityRepository extends JpaRepository<BirdEntity, Long> {
     @Query(value = "SELECT * FROM bird_products WHERE discount > 0", nativeQuery = true)
    List<BirdEntity> findDiscountProducts();

    @Query(value = "SELECT * FROM bird_products WHERE type = 'food'", nativeQuery = true)
    List<BirdEntity> getBirdFood();

    @Query(value = "SELECT * FROM bird_products WHERE type = 'grooming'", nativeQuery = true)
    List<BirdEntity> getBirdGrooming();

    List<BirdEntity> findByType(String type);

}
