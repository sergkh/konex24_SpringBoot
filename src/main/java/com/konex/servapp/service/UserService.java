package com.konex.servapp.service;

import com.konex.servapp.entity.User;

import java.util.List;

/**
 * Created by kneimad on 28.09.2016.
 */
public interface UserService {

    void save(User user);

    void delete(Long id);

    User findByUsername(String username);

    List<User> listUsers();
}