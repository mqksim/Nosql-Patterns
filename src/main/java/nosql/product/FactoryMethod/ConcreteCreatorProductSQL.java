package nosql.product.FactoryMethod;

public class ConcreteCreatorProductSQL extends Creator{
    @Override
    public ProductInterface factoryMethod() {
        return new ProductSQL();
    }
}
