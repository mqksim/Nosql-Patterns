package nosql.product.sql;

import nosql.product.Memento.Memento;
import nosql.product.mongo.ProductM;

import javax.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tittle", nullable = false)
    private String tittle;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_company")
    private Company company=new Company();

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_category")
    private Category category=new Category();

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_brand")
    private Brand brand=new Brand();

    public Product() {
    }

    public Product(ProductM p,Company com,Category cat,Brand b) {
        this.tittle = p.getTittle();
        this.price = p.getPrice();
        this.quantity = p.getQuantity();
        this.company = com;
        this.category = cat;
        this.brand = b;
    }
    public Product(String tittle, Double price, Integer quantity, Company company, Category category, Brand brand) {
        this.tittle = tittle;
        this.price = price;
        this.quantity = quantity;
        this.company = company;
        this.category = category;
        this.brand = brand;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", company=" + company.getCompanyName() +
                ", category=" + category.getCategoryName() +
                ", brand=" + brand.getBrandName() +
                '}';
    }

    public void setState(Product p) {
        this.id=p.getId();
        this.tittle = p.getTittle();
        this.price = p.getPrice();
        this.quantity = p.getQuantity();
        this.company = p.getCompany();
        this.category = p.getCategory();
        this.brand = p.getBrand();
    }

    public Memento saveState() {
        return new Memento(this);
    }

    public void restoreState(Memento memento) {
        this.setState(memento.getProduct());
    }

}
