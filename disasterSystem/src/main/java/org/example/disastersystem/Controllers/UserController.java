package org.example.disastersystem.Controllers;


import jakarta.validation.Valid;
import org.example.disastersystem.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("dmc")
public class UserController {
    @RequestMapping("/api")
    @ResponseBody
    public String getApiVersion(){
        return "1.0.0";
    }
    @PostMapping("/save")
    public String save(@Valid User user, BindingResult bindingResult) {
        System.out.println("has validation issues: "+bindingResult.hasErrors());
        if(bindingResult.hasErrors()) {
            return "userEntry";
        } else {
            return "userEntry";
        }
    }

    @RequestMapping("/signup")
    public String newUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "userEntry";
    }
}
