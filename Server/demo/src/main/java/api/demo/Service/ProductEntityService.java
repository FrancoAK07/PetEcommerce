package api.demo.Service;
import java.util.List;

public interface ProductEntityService {
    List<Object> getProductsByType(String type);
    List<Object> getAllProducts();
}
