package nosql.product.sql;

import nosql.product.mongo.CategoryM;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categoryName", nullable = false)
    private String categoryName;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> productList;

    public Category() {
    }
    public Category(CategoryM c) {
        this.categoryName = c.getCategoryName();
        this.description = c.getDescription();
    }

    public Category(Long id, String category_name, String description) {
        this.id = id;
        this.categoryName = category_name;
        this.description = description;
    }

    public Category(String category_name, String description) {
        this.categoryName = category_name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category_name='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
