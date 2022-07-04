package io.spring.demo.services;

import org.springframework.stereotype.Service;

import io.spring.demo.models.User;
import io.spring.demo.repositories.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int userId) {
        User user = userRepository.getById(String.valueOf(userId));
        return user;
    }

    public User saveUser(User user) {
        User userCreated = userRepository.save(user);
        return userCreated;
    }

    public User updateUser(User user) {
        User userCreated = userRepository.save(user);
        return userCreated;
    }

    public boolean checkIfUserExist(String nif, String email) {
        if (userRepository.checkNif(nif) == 1) {
            return true;
        } else if (userRepository.checkEmail(email) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
