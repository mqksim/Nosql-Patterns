package nosql.product.mongo;

import nosql.product.sql.Company;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "company")
public class CompanyM {
    @Id
    private String id;

    @Field(name = "companyName")
    private String companyName;

    @Field(name = "country")
    private String country;

    public CompanyM() {
    }
    public CompanyM(Company c) {
        this.companyName = c.getCompanyName();
        this.country = c.getCountry();
    }
    public CompanyM(String company_name, String country) {
        this.companyName = company_name;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", company_name='" + companyName + '\'' +
                ", country='" + country +
                '}';
    }
}
