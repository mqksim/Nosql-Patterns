package nosql.product.mongo;

import nosql.product.sql.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "product")
public class ProductM {
    @Id
    private String id;

    @Field(name = "tittle")
    private String tittle;

    @Field(name = "price")
    private Double price;

    @Field(name = "quantity")
    private Integer quantity;

    @Field(name = "company")
    private CompanyM company;

    @Field(name = "category")
    private CategoryM category;

    @Field(name = "brand")
    private BrandM brand;

    public ProductM() {
    }
    public ProductM(Product p ) {
        this.tittle = p.getTittle();
        this.price = p.getPrice();
        this.quantity = p.getQuantity();
        this.company = new CompanyM(p.getCompany());
        this.category = new CategoryM(p.getCategory());
        this.brand = new BrandM(p.getBrand());
    }
    public ProductM(String tittle, Double price, Integer quantity, CompanyM company, CategoryM category, BrandM brand) {
        this.tittle = tittle;
        this.price = price;
        this.quantity = quantity;
        this.company = company;
        this.category = category;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public CompanyM getCompany() {
        return company;
    }

    public void setCompany(CompanyM company) {
        this.company = company;
    }

    public CategoryM getCategory() {
        return category;
    }

    public void setCategory(CategoryM category) {
        this.category = category;
    }

    public BrandM getBrand() {
        return brand;
    }

    public void setBrand(BrandM type) {
        this.brand = type;
    }

    @Override
    public String toString() {
        return "ProductM{" +
                "id='" + id + '\'' +
                ", tittle='" + tittle + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", company=" + company +
                ", category=" + category +
                ", brand=" + brand +
                '}';
    }
}
