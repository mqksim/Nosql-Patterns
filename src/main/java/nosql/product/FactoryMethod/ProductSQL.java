package nosql.product.FactoryMethod;

import nosql.product.sql.Brand;
import nosql.product.sql.Category;
import nosql.product.sql.Company;

public class ProductSQL implements ProductInterface {
    private String tittle;
    private Double price;
    private Integer quantity;
    private Company company;
    private Category category;
    private Brand brand;
    @Override
    public Double sumAll() {
        return price*quantity;
    }
}
