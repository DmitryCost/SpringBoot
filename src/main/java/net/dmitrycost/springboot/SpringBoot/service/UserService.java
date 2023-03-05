package net.dmitrycost.springboot.SpringBoot.service;

import net.dmitrycost.springboot.SpringBoot.model.User;
import net.dmitrycost.springboot.SpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }


    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
