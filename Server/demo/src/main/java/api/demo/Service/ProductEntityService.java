package api.demo.service;
import java.util.List;
import api.demo.model.Product;

public interface ProductEntityService {
    List<Product> getProductsByPetType(String petType);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getDiscountProducts();
}
