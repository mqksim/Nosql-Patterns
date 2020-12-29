package nosql.product.sql;

import nosql.product.mongo.CompanyM;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "companyName", nullable = false)
    private String companyName;

    @Column(name = "country", nullable = false)
    private String country;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Product> productList;

    public Company() {
    }
    public Company(CompanyM c) {
        this.companyName = c.getCompanyName();
        this.country = c.getCountry();
    }
    public Company(Long id, String company_name, String country) {
        this.id = id;
        this.companyName = company_name;
        this.country = country;
    }

    public Company(String company_name, String country) {
        this.companyName = company_name;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", company_name='" + companyName + '\'' +
                ", country='" + country +
                '}';
    }
}
