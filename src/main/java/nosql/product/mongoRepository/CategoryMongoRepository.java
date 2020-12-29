package nosql.product.mongoRepository;

import nosql.product.mongo.CategoryM;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryMongoRepository extends MongoRepository<CategoryM, String> {
    Optional<CategoryM> findFirstByCategoryName(String name);
}
