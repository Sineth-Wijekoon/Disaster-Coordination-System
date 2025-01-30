package org.example.disastersystem.Controllers;

import org.example.disastersystem.Models.Disaster;
import org.example.disastersystem.Models.User;
import org.example.disastersystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("dmc")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String viewUsers(Model model) {
        List<User> users = userService.getAllUsers();
        List<Disaster> disasters = userService.getAllDisasters();
        model.addAttribute("users", users);
        model.addAttribute("disasters", disasters);
        return "index";
    }


    @RequestMapping("/admin")
    public String admin() {
        return "adminLogin";
    }

}
