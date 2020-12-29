package nosql.product.Memento;

import nosql.product.sql.Product;

public class Memento {
    private final Product product;

    public Memento(Product p) {
        this.product=new Product( p.getTittle(),p.getPrice(),
                p.getQuantity(),p.getCompany(),p.getCategory(),p.getBrand());
    }

    public Product getProduct() {
        return product;
    }
}
