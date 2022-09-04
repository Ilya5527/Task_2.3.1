package ru.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.project.entity.User;
import ru.project.service.UserService;

import java.util.List;

@Controller
public class WebController {

    private UserService userService;

    public WebController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(name = "/")
    public String indexPage () {

        List<User> userList = userService.getAllUsers();
        System.out.println(userList);

        return "index";
    }
}
