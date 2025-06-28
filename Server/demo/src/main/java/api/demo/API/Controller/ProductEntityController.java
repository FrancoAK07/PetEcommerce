package api.demo.API.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import api.demo.Service.ProductEntityService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/products")
public class ProductEntityController {
      @Autowired
    private ProductEntityService productService;

    @GetMapping
    public List<Object> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/byType")
    public List<Object> getProductsByType(@RequestParam String type) {
        return productService.getProductsByType(type);
    }
}
