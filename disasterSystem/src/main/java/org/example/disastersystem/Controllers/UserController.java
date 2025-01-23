package org.example.disastersystem.Controllers;


import jakarta.validation.Valid;
import org.example.disastersystem.Models.User;
import org.example.disastersystem.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("dmc")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/home")
    public String home(){
        return "homepage";
    }

    @GetMapping("/userinfo")
    public String newUser(Model model, @RequestParam(value = "lang", required = false, defaultValue = "english") String lang) {
        User user = new User();
        String formView = "userEntryEnglish"; // Default form view

        if ("sinhala".equals(lang)) {
            formView = "userEntrySinhala";
        }

        model.addAttribute("user", user);
        model.addAttribute("lang", lang); // Add language to model for view access
        return formView;
    }

    @PostMapping("/save")
    public String save(@Valid User user, BindingResult bindingResult, @RequestParam(value = "lang", required = false, defaultValue = "english") String lang, Model model) {
        System.out.println("has validation issues: " + bindingResult.hasErrors());

        if (bindingResult.hasErrors()) {
            // Retain selected language and user data in model for re-displaying the form
            model.addAttribute("lang", lang);
            model.addAttribute("user", user);
            return getFormViewByLanguage(lang); // Use a method to determine form view
        } else {
            userRepository.save(user);
            return "success";
        }
    }

    private String getFormViewByLanguage(String lang) {
        if ("sinhala".equals(lang)) {
            return "userEntrySinhala";
        } else {
            return "userEntryEnglish";
        }
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
