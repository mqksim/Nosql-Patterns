package nosql.product.mongoRepository;


import nosql.product.Result;
import nosql.product.mongo.ProductM;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ProductMongoRepository extends MongoRepository<ProductM, String> {

    Optional<ProductM> findFirstByTittle(String tittle);

    @Transactional
    void deleteAllByTittle(String tittle);

    List<ProductM> findAllByPriceBetween(Double first, Double second);

    @Aggregation("{ $group: {_id :'$category.categoryName', sum : {$min : '$price'}  } }")
    List<Result> minPriceInCategory();

    @Aggregation("{ $group: {_id :'$category.categoryName', count : {$sum : 1}  } }")
    List<Result> countProductInCategory();

    @Aggregation("{ $group: {_id :'$company.companyName', count : {$sum : '$quantity'}  } }")
    List<Result> countProductInCompany();

    @Aggregation("{ $group: {_id :'$brand.brandName', sum : {$max :'$price'}  } }")
    List<Result> maxPriceInBrand();

    @Aggregation("{ $match:{'price':{$lt:10000},'quantity':{$gt:9}}}")
    List<ProductM> matchPriceAndQuantity();

}
