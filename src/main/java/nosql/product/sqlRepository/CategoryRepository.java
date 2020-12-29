package nosql.product.sqlRepository;


import nosql.product.sql.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findFirstByCategoryName(String name);
}
