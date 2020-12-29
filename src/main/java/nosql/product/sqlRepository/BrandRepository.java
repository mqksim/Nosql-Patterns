package nosql.product.sqlRepository;

import nosql.product.sql.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Optional<Brand> findFirstByBrandName(String s);


}
