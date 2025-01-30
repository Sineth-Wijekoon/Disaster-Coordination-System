package org.example.disastersystem.Service;

import org.example.disastersystem.Models.Disaster;
import org.example.disastersystem.Models.User;
import org.example.disastersystem.Repo.DisasterRepository;
import org.example.disastersystem.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private DisasterRepository disasterRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Disaster> getAllDisasters() {
        return disasterRepository.findAll();
    }
}