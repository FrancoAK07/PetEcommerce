package api.demo.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.demo.repository.BirdEntityRepository;
import api.demo.repository.FishEntityRepository;
import api.demo.repository.DogEntityRepository;
import api.demo.repository.CatEntityRepository;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductEntityServiceImpl implements ProductEntityService {
    @Autowired
    private DogEntityRepository dogRepo;

    @Autowired
    private CatEntityRepository catRepo;

    @Autowired
    private FishEntityRepository fishRepo;

    @Autowired
    private BirdEntityRepository birdRepo;


    @Override
    public List<Object> getProductsByType(String type) {
        List<Object> allProductsOfType = new ArrayList<>();

        allProductsOfType.addAll(dogRepo.findByType(type));
        allProductsOfType.addAll(catRepo.findByType(type));
        allProductsOfType.addAll(fishRepo.findByType(type));
        allProductsOfType.addAll(birdRepo.findByType(type));

        return allProductsOfType;

    }

    @Override
    public List<Object> getAllProducts() {
        List<Object> allProducts = new ArrayList<>();

        allProducts.addAll(dogRepo.findAll());
        allProducts.addAll(catRepo.findAll());
        allProducts.addAll(birdRepo.findAll());
        allProducts.addAll(fishRepo.findAll());

        return allProducts;
    }

}
