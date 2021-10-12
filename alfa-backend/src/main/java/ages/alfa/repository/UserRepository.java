package ages.alfa.repository;

import ages.alfa.model.entity.Teacher;
import ages.alfa.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
