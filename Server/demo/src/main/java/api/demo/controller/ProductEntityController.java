package api.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import api.demo.service.ProductEntityService;
import api.demo.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/products")
public class ProductEntityController {
      @Autowired
    private ProductEntityService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/petType")
    public List<Product> getProductsByPetType(@RequestParam String petType) {
        return productService.getProductsByPetType(petType);
    }

    @GetMapping("/category")
    public List<Product> getProductsByCategory(@RequestParam String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/discounts")
    public List<Product> getDiscountProducts() {
        return productService.getDiscountProducts();
    }


}
