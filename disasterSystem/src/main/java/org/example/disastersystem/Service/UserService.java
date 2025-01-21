package org.example.disastersystem.Service;

import org.example.disastersystem.Models.User;
import org.example.disastersystem.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User addUser(User user) {
        return userRepository.save(user);
    }
}