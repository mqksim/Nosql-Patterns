package nosql.product.FactoryMethod;

import nosql.product.mongo.BrandM;
import nosql.product.mongo.CategoryM;
import nosql.product.mongo.CompanyM;

public class ProductMongo implements ProductInterface{
    private String tittle;
    private Double price;
    private Integer quantity;
    private CompanyM company;
    private CategoryM category;
    private BrandM brand;

    @Override
    public Double sumAll() {
        return price*quantity;
    }
}
