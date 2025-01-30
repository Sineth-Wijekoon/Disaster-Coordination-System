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
import org.springframework.web.bind.support.SessionStatus;

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

        model.addAttribute("user", new User());
        model.addAttribute("lang", lang); // Add language to model for view access
        return getUserFormViewByLanguage(lang);
    }

    @PostMapping("/userinfo")
    public String saveUserInfo(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                               @RequestParam(value = "lang", required = false, defaultValue = "english")String lang, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("lang", lang);
            return getUserFormViewByLanguage(lang);
        }

        model.addAttribute("user", user);

        return"redirect:/dmc/disasterinfo";
    }

    @GetMapping("/disasterinfo")
    public String disasterInfo(Model model, @RequestParam(value = "lang", required = false, defaultValue = "english") String lang) {

        model.addAttribute("disaster", new Disaster());
        model.addAttribute("lang", lang);
        return getDisasterFormViewByLanguage(lang);
    }


    @PostMapping("/disasterinfo")
    @Transactional
    public String saveDisasterInfo(@Valid @ModelAttribute("disaster") Disaster disaster, BindingResult bindingResult,
                                   @ModelAttribute("user") User user, Model model, SessionStatus sessionStatus) {
        System.out.println("User in session: " + user);
        if (bindingResult.hasErrors()) {
            return "disaster";
        }

        disasterRepository.save(disaster);

        user.setDisaster(disaster);

        userRepository.save(user);

        sessionStatus.setComplete();


        return "redirect:/dmc/success";
    }

    private String getUserFormViewByLanguage(String lang) {
        if ("sinhala".equals(lang)) {
            return "userEntrySinhala";
        } else {
            return "userEntryEnglish";
        }
    }

    private String getDisasterFormViewByLanguage(String lang) {
        if ("sinhala".equals(lang)) {
            return "disasterSinhala";
        } else {
            return "disaster";
        }
    }

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}