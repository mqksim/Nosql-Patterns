package nosql.product.sqlRepository;

import nosql.product.sql.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetween(Double first, Double second);
    @Transactional
    void deleteAll();
    @Transactional
    void deleteAllByTittle(String tittle);


    Optional<Product> findFirstByTittle(String tittle);
}
