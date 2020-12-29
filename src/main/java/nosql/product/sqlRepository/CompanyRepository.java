package nosql.product.sqlRepository;


import nosql.product.sql.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findFirstByCompanyName(String s);
    @Transactional
    void deleteAll();

    List<Company> findAllByCompanyName(String company_name);
}
