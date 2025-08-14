package api.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import api.demo.model.Product;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findByCategory(String category);

    List<Product> findByPetType(String petType);

    @Query(value = "SELECT * FROM products WHERE discount > 0", nativeQuery = true)
    List<Product> findDiscountProducts();

}
