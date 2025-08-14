package api.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "bird_products")
public class BirdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String img;

    private Float price;

    private String category;

    @Column(name = "pet_type")
    private String petType;

    private Integer discount;

    public BirdEntity() {

    }

    public BirdEntity(String name, String description, String img, Float price, String category, String petType, Integer discount) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.price = price;
        this.category = category;
        this.petType = petType;
        this.discount = discount;
    }

    // Getters and setters for each attribute
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImage(String img) {
        this.img = img;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getpetType() {
        return petType;
    }

    public void setpetType(String petType) {
        this.petType = petType;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

}
