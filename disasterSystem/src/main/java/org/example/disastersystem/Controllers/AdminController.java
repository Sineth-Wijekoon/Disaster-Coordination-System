package org.example.disastersystem.Controllers;

import org.example.disastersystem.Models.Disaster;
import org.example.disastersystem.Models.ReportStatus;
import org.example.disastersystem.Models.User;
import org.example.disastersystem.Objects.DisasterCount;
import org.example.disastersystem.Repo.DisasterRepository;
import org.example.disastersystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("dmc")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private DisasterRepository disasterRepository;

    @GetMapping("/users")
    public String viewUsers(Model model) {
        List<User> users = userService.getAllUsers();
        List<Disaster> disasters = userService.getAllDisasters();
        model.addAttribute("users", users);
        model.addAttribute("disasters", disasters);

        List<DisasterCount> disasterCounts = disasterRepository.countByDisasterType();
        model.addAttribute("disasterCounts", disasterCounts);

        List<DisasterCount> disasterTypePending = disasterRepository.countByDisasterTypePending();
        model.addAttribute("disasterCountsPending", disasterTypePending);



        return "index";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "adminLogin";
    }

    @RequestMapping("/charts")
    public String charts() {
        return "charts";
    }

    @GetMapping("/low")
    public String low(Model model) {
        List<User> users = userService.getAllUsers();
        List<Disaster> disasters = userService.getAllDisasters();

        List<Disaster> lowUrgencyDisasters = disasters.stream()
                .filter(disaster -> "Low".equals(disaster.getUrgencyLevel()))
                .collect(Collectors.toList());

        List<User> lowUrgencyUsers = new ArrayList<>();
        for (User user : users) {
            for (Disaster disaster : lowUrgencyDisasters) {
                if (user.getId().equals(disaster.getId())) {
                    lowUrgencyUsers.add(user);
                    break;
                }
            }
        }

        List<DisasterCount> disasterCounts = disasterRepository.countByDisasterTypeAndUrgencyLevelLow();
        model.addAttribute("disasterCounts", disasterCounts);

        List<DisasterCount> disasterTypePending = disasterRepository.countByDisasterTypePending();
        model.addAttribute("disasterCountsPending", disasterTypePending);

        model.addAttribute("users", lowUrgencyUsers);
        model.addAttribute("disasters", lowUrgencyDisasters);
        return "low";
    }

    @GetMapping("/medium")
    public String medium(Model model) {
        List<User> users = userService.getAllUsers();
        List<Disaster> disasters = userService.getAllDisasters();

        List<Disaster> mediumUrgencyDisasters = disasters.stream()
                .filter(disaster -> "Medium".equals(disaster.getUrgencyLevel()))
                .collect(Collectors.toList());

        List<User> mediumUrgencyUsers = new ArrayList<>();
        for (User user : users) {
            for (Disaster disaster : mediumUrgencyDisasters) {
                if (user.getId().equals(disaster.getId())) {
                    mediumUrgencyUsers.add(user);
                    break;
                }
            }
        }

        List<DisasterCount> disasterCounts = disasterRepository.countByDisasterTypeAndUrgencyLevelMedium();
        model.addAttribute("disasterCounts", disasterCounts);


        model.addAttribute("users", mediumUrgencyUsers);
        model.addAttribute("disasters", mediumUrgencyDisasters);
        return "medium";
    }

    @GetMapping("/high")
    public String high(Model model) {
        List<User> users = userService.getAllUsers();
        List<Disaster> disasters = userService.getAllDisasters();

        List<Disaster> highUrgencyDisasters = disasters.stream()
                .filter(disaster -> "Critical".equals(disaster.getUrgencyLevel()))
                .collect(Collectors.toList());

        List<User> highUrgencyUsers = new ArrayList<>();
        for (User user : users) {
            for (Disaster disaster : highUrgencyDisasters) {
                if (user.getId().equals(disaster.getId())) {
                    highUrgencyUsers.add(user);
                    break;
                }
            }
        }

        List<DisasterCount> disasterCounts = disasterRepository.countByDisasterTypeAndUrgencyLevelHigh();
        model.addAttribute("disasterCounts", disasterCounts);


        model.addAttribute("users", highUrgencyUsers);
        model.addAttribute("disasters", highUrgencyDisasters);
        return "critical";
    }

    @PutMapping("/{id}/status")
    public String updateReportStatus(
            @PathVariable Long id,
            @RequestParam ReportStatus status) {

        userService.updateReportStatus(id, status);

        return "redirect:/dmc/users";
    }

    @GetMapping("/disasterTypeFlood")
    public String disasterTypeFlood(Model model) {
        List<User> users = userService.getAllUsers();
        List<Disaster> disasters = userService.getAllDisasters();

        List<Disaster> floodDisasters = disasters.stream()
                .filter(disaster -> "Flood".equals(disaster.getDisasterType()))
                .collect(Collectors.toList());

        List<User> floodUsers = new ArrayList<>();
        for (User user : users) {
            for (Disaster disaster : floodDisasters) {
                if (user.getId().equals(disaster.getId())) {
                    floodUsers.add(user);
                    break;
                }
            }
        }

        model.addAttribute("users", floodUsers);
        model.addAttribute("disasters", floodDisasters);
        return "Flood";
    }

    @GetMapping("/disasterTypeEarthquake")
    public String disasterTypeEarthquake(Model model) {
        List<User> users = userService.getAllUsers();
        List<Disaster> disasters = userService.getAllDisasters();

        List<Disaster> earthquakeDisasters = disasters.stream()
                .filter(disaster -> "Earthquake".equals(disaster.getDisasterType()))
                .collect(Collectors.toList());

        List<User> earthquakeUsers = new ArrayList<>();
        for (User user : users) {
            for (Disaster disaster : earthquakeDisasters) {
                if (user.getId().equals(disaster.getId())) {
                    earthquakeUsers.add(user);
                    break;
                }
            }
        }

        model.addAttribute("users", earthquakeUsers);
        model.addAttribute("disasters", earthquakeDisasters);
        return "Earthquake";
    }

    @GetMapping("/disasterTypeLandslide")
    public String disasterTypeLandslide(Model model) {
        List<User> users = userService.getAllUsers();
        List<Disaster> disasters = userService.getAllDisasters();

        List<Disaster> landslideDisasters = disasters.stream()
                .filter(disaster -> "Landslide".equals(disaster.getDisasterType()))
                .collect(Collectors.toList());

        List<User> landslideUsers = new ArrayList<>();
        for (User user : users) {
            for (Disaster disaster : landslideDisasters) {
                if (user.getId().equals(disaster.getId())) {
                    landslideUsers.add(user);
                    break;
                }
            }
        }

        model.addAttribute("users", landslideUsers);
        model.addAttribute("disasters", landslideDisasters);
        return "Landslide";
    }

    @GetMapping("/disasterTypeTsunami")
    public String disasterTypeTsunami(Model model) {
        List<User> users = userService.getAllUsers();
        List<Disaster> disasters = userService.getAllDisasters();

        List<Disaster> tsunamiDisasters = disasters.stream()
                .filter(disaster -> "Tsunami".equals(disaster.getDisasterType()))
                .collect(Collectors.toList());

        List<User> tsunamiUsers = new ArrayList<>();
        for (User user : users) {
            for (Disaster disaster : tsunamiDisasters) {
                if (user.getId().equals(disaster.getId())) {
                    tsunamiUsers.add(user);
                    break;
                }
            }
        }

        model.addAttribute("users", tsunamiUsers);
        model.addAttribute("disasters", tsunamiDisasters);
        return "Tsunami";
    }

    @GetMapping("/disasterTypeCyclone")
    public String disasterTypeCyclone(Model model) {
        List<User> users = userService.getAllUsers();
        List<Disaster> disasters = userService.getAllDisasters();

        List<Disaster> cycloneDisasters = disasters.stream()
                .filter(disaster -> "Cyclone".equals(disaster.getDisasterType()))
                .collect(Collectors.toList());

        List<User> cycloneUsers = new ArrayList<>();
        for (User user : users) {
            for (Disaster disaster : cycloneDisasters) {
                if (user.getId().equals(disaster.getId())) {
                    cycloneUsers.add(user);
                    break;
                }
            }
        }

        model.addAttribute("users", cycloneUsers);
        model.addAttribute("disasters", cycloneDisasters);
        return "Cyclone";
    }
}
