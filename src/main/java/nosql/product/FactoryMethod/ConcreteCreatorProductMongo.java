package nosql.product.FactoryMethod;

public class ConcreteCreatorProductMongo extends Creator{
    @Override
    public ProductInterface factoryMethod() {
        return new ProductMongo();
    }
}
