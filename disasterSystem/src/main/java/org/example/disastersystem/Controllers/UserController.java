package org.example.disastersystem.Controllers;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.disastersystem.Models.Disaster;
import org.example.disastersystem.Models.User;
import org.example.disastersystem.Repo.DisasterRepository;
import org.example.disastersystem.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("dmc")
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DisasterRepository disasterRepository;

    @ModelAttribute("user")
    public User getUser(@SessionAttribute(value = "user", required = false) User sessionUser) {
        if (sessionUser != null) {
            return sessionUser; // Use the existing session object
        }
        return new User(); // Create a new User object if none exists
    }


    @RequestMapping("/home")
    public String home(){
        return "homepage";
    }

    @GetMapping("/userinfo")
    public String newUser(Model model, @RequestParam(value = "lang", required = false, defaultValue = "english") String lang) {

        model.addAttribute("lang", lang); // Add language to model for view access
        return getFormViewByLanguage(lang);
    }

    @PostMapping("/userinfo")
    public String saveUserInfo(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                               @RequestParam(value = "lang", required = false, defaultValue = "english")String lang, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("lang", lang);
            return getFormViewByLanguage(lang);
        }

        return"redirect:/dmc/disaster";
    }

    @GetMapping("/disaster")
    public String disasterInfo(Model model, @SessionAttribute(value = "user", required = false) User sessionUser) {
        if (sessionUser == null) {
            // Redirect to userinfo if no user is in session
            return "redirect:/dmc/userinfo";
        }
        model.addAttribute("disaster", new Disaster());
        return "disaster";
    }


    @PostMapping("/disasterinfo")
    @Transactional
    public String saveDisasterInfo(@Valid @ModelAttribute("disaster") Disaster disaster, BindingResult bindingResult,
                                   @ModelAttribute("user") User user, Model model) {
        System.out.println("User in session: " + user);
        if (bindingResult.hasErrors()) {
            return "disaster";
        }

        disasterRepository.save(disaster);

        user.setDisaster(disaster);

        userRepository.save(user);

        return "redirect:/dmc/success";
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
