package api.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import api.demo.API.Model.DogEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DogEntityRepository extends JpaRepository<DogEntity, Long> {
    @Query(value = "SELECT * FROM dog_products WHERE discount > 0", nativeQuery = true)
    List<DogEntity> findDiscountProducts();

    @Query(value = "SELECT * FROM dog_products WHERE type = 'food'", nativeQuery = true)
    List<DogEntity> getDogFood();

    @Query(value = "SELECT * FROM dog_products WHERE type = 'grooming'", nativeQuery = true)
    List<DogEntity> getDogGrooming();

    @Query(value = "SELECT * FROM dog_products WHERE type = 'toys'", nativeQuery = true)
    List<DogEntity> getDogToys();

    List<DogEntity> findByType(String type);
}
