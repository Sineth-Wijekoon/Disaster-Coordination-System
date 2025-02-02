package org.example.disastersystem.Service;

import jakarta.persistence.EntityNotFoundException;
import org.example.disastersystem.Models.Disaster;
import org.example.disastersystem.Models.ReportStatus;
import org.example.disastersystem.Models.User;
import org.example.disastersystem.Objects.RequestStats;
import org.example.disastersystem.Repo.DisasterRepository;
import org.example.disastersystem.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void updateReportStatus(Long id, ReportStatus status) {
        Disaster report = disasterRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Disaster report not found"));

        report.setStatus(status);
        disasterRepository.save(report);
    }
}
