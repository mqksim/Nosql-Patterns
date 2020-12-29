package nosql.product.sqlRepository;

import nosql.product.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByLoginAndPassword(String login, String password);
}
