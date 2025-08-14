package api.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.demo.repository.ProductRepository;
import api.demo.model.Product;
import java.util.List;


@Service
public class ProductEntityServiceImpl implements ProductEntityService {

    @Autowired
    private ProductRepository productRepo;


    @Override
    public List<Product> getProductsByPetType(String petType) {
        List<Product> allProductsOfPet = productRepo.findByPetType(petType);
        return allProductsOfPet;

    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        List<Product> allProductsOfCategory = productRepo.findByCategory(category);
        System.out.println("this is all products of category: " + category + "=" + allProductsOfCategory);
        return allProductsOfCategory;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = productRepo.findAll();
        return allProducts;
    }

    @Override
    public List<Product> getDiscountProducts() {
        List<Product> discountProducts = productRepo.findDiscountProducts();
        return discountProducts;
    }

}
