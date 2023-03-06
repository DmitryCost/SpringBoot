package net.dmitrycost.springboot.SpringBoot.controller;

import jakarta.validation.Valid;
import net.dmitrycost.springboot.SpringBoot.model.User;
import net.dmitrycost.springboot.SpringBoot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "/")
    public String home(ModelMap model) {
        model.addAttribute("users", userServiceImpl.listAll());
        return "index";
    }

    @GetMapping("/new")
    public String createUserForm(ModelMap model, User user) {
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/new")
    public String createUser(@Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "new_user";
        }
        userServiceImpl.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userServiceImpl.getById(id));
        return "edit_user";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userServiceImpl.getById(id));
        return "show_user";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "edit_user";
        }
        userServiceImpl.save(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userServiceImpl.deleteById(id);
        return "redirect:/";
    }

}
