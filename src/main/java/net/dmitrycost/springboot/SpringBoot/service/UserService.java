package net.dmitrycost.springboot.SpringBoot.service;

import net.dmitrycost.springboot.SpringBoot.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> listAll();
    User getById(Long id);
    void deleteById(Long id);

}
