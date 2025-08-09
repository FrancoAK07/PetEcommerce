package api.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "cat_products")
public class CatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String img;
    private Float price;
    private String type;
    private Integer discount;

    public CatEntity() {

    }

    public CatEntity(String name, String description, String img, Float price, String type, Integer discount) {
        this.name = name;
        this.description = description;
        this.img = img;
        this.price = price;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

}
