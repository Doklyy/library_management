package library.service;

import java.util.List;
import java.util.Optional;

import library.model.User;

public interface UserService {
    User createUser(User user);
    Optional<User> findByUsername(String username);
    List<User> findAllUsers();
    boolean authenticate(String username, String password);
} 