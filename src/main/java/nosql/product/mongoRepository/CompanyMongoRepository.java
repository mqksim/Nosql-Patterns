package nosql.product.mongoRepository;

import nosql.product.mongo.CompanyM;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyMongoRepository extends MongoRepository<CompanyM, String> {

    Optional<CompanyM> findFirstByCompanyName(String s);

    List<CompanyM> findAllByCompanyName(String company_name);
}
