package library.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import library.exception.UserAlreadyExistsException;
import library.model.User;
import library.service.UserService;

public class UserServiceImpl implements UserService {
    private Map<String, User> users = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public User createUser(User user) {
        if (users.containsKey(user.getUsername())) {
            throw new UserAlreadyExistsException(user.getUsername());
        }
        user.setUserId(currentId++);
        users.put(user.getUsername(), user);
        return user;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }

    @Override
    public List<User> findAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
}
