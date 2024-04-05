package com.yash.user.service;

import com.yash.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> findAll();
    public User findById(Long userId);
    public User save(User user);
    public User updateUser(User user);
    public boolean deleteUser(Long userId);
}
