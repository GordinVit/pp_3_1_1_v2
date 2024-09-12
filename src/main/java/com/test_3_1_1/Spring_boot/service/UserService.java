package com.test_3_1_1.Spring_boot.service;

import com.test_3_1_1.Spring_boot.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    List<User> findAll();

    User saveUser(User user);

    void deleteById(Long id);
}


