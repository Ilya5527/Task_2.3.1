package ru.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.project.entity.User;
import ru.project.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/userList")
public class WebController {

    private UserService userService;

    public WebController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String usersList (ModelMap modelMap) {

        List<User> userList = userService.getAllUsers();
        modelMap.addAttribute("users", userList);

        return "userList";
    }

    @GetMapping("/addUser")
    public String addUser (ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }


    @PostMapping()
    public String create (@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:userList";
    }

    @GetMapping("/{id}")
    public String deleteUser (@PathVariable("id") long id, ModelMap model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);

        return "deleteUser";
    }

    @DeleteMapping("/{id}")
    public String getUser (@PathVariable("id") long id) {

        System.out.println(id);

        userService.delete(id);

        return "redirect:userList";
    }
}
