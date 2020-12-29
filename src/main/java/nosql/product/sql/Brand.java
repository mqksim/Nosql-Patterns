package nosql.product.sql;

import nosql.product.mongo.BrandM;

import javax.persistence.*;
import java.util.List;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brandName", nullable = false)
    private String brandName;

    @Column(name = "yearFormation", nullable = true)
    private Integer yearFormation;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private List<Product> productList;

    public Brand() {
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public Brand(BrandM b) {
        this.brandName = b.getBrandName();
        this.yearFormation = b.getYearFormation();
    }

    public Brand(String brandName, Integer yearFormation) {
        this.brandName = brandName;
        this.yearFormation = yearFormation;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getYearFormation() {
        return yearFormation;
    }

    public void setYearFormation(Integer yearFormation) {
        this.yearFormation = yearFormation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public static class Builder {
        private final String brandName;
        private Integer yearFormation;

        public Builder(String brandName) {
            this.brandName = brandName;
        }
        public Brand.Builder yearFormation(Integer yearFormation) {
            this.yearFormation = yearFormation;
            return this;
        }

        public Brand build() {
            return new Brand(this);
        }
    }

    private Brand(Brand.Builder builder) {
        brandName = builder.brandName;
        yearFormation = builder.yearFormation;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", yearFormation=" + yearFormation +
                '}';
    }
}
