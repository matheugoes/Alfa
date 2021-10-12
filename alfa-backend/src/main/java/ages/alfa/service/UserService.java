package ages.alfa.service;

import ages.alfa.model.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(User user);
}
