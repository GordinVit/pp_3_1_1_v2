package com.test_3_1_1.Spring_boot.controller;

import com.test_3_1_1.Spring_boot.model.User;
import com.test_3_1_1.Spring_boot.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.findAll();
        model.addAttribute("users", allUsers);
        return "users";
    }

    @GetMapping("/updateUser")
    public String showUpdateForm(@RequestParam("userId") Long userId, Model model) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(User user) {
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/addUser")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") Long userId) {
        userService.deleteById(userId);
        return "redirect:/";
    }
}

