package nosql.product.mongo;


import nosql.product.sql.Brand;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "brand")
public class BrandM {
    @Id
    private String id;

    @Field(name = "brandName")
    private String brandName;

    @Field(name = "yearFormation")
    private Integer yearFormation;



    public BrandM() {
    }
    public BrandM(String brandName) {
        this.brandName = brandName;
    }
    public BrandM(Brand b) {
        this.brandName = b.getBrandName();
        this.yearFormation = b.getYearFormation();
    }
    public BrandM(String brandName, Integer yearFormation) {
        this.brandName = brandName;
        this.yearFormation = yearFormation;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public static class Builder {
        private final String brandName;
        private Integer yearFormation;

        public Builder(String brandName) {
            this.brandName = brandName;
        }
        public BrandM.Builder yearFormation(Integer yearFormation) {
            this.yearFormation = yearFormation;
            return this;
        }

        public BrandM build() {
            return new BrandM(this);
        }
    }

    private BrandM(BrandM.Builder builder) {
        brandName = builder.brandName;
        yearFormation = builder.yearFormation;
    }

    @Override
    public String toString() {
        return "BrandM{" +
                "id='" + id + '\'' +
                ", brandName='" + brandName + '\'' +
                ", yearFormation=" + yearFormation +
                '}';
    }
}
