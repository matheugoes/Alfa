package ages.alfa.service.impl;

import ages.alfa.model.entity.User;
import ages.alfa.repository.UserRepository;
import ages.alfa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByEmail(User user) {
        return userRepository.findOne(Example.of(user));
    }
}
