package nosql.product.mongoRepository;


import nosql.product.mongo.BrandM;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BrandMongoRepository extends MongoRepository<BrandM, String> {

    Optional<BrandM> findFirstByBrandName(String s);
}
