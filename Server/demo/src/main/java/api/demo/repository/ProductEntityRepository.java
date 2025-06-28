package api.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import api.demo.API.Model.ProductEntity;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductEntityRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByType(String type);
}
