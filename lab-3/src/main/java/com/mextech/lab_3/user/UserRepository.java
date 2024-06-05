package com.mextech.lab_3.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();
    private long nextId = 1;

    public User save(User user) {
        User newUser = new User(nextId++, user.name());
        users.add(newUser);
        return newUser;
    }

    public Optional<User> findById(long userId) {
        return users.stream()
                .filter(user -> user.id() == userId)
                .findFirst();
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public void update(User user) {
        users.stream()
                .filter(u -> u.id() == user.id())
                .findFirst()
                .ifPresent(u -> {
                    users.remove(u);
                    users.add(user);
                });
    }

    public void deleteById(long userId) {
        users.removeIf(user -> user.id() == userId);
    }

    public void deleteAll() {
        users.clear();
    }
}
