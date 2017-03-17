package com.korgutlova.controller;


import com.korgutlova.model.Post;
import com.korgutlova.model.User;
import com.korgutlova.service.PostService;
import com.korgutlova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping(value = "/home")
public class UserController {

    private final PostService postService;
    private final UserService userService;

    @Autowired
    public UserController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @RequestMapping("")
    public String home(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Post> posts = postService.allPostsUser(user);
        model.addAttribute("user", user);
        model.addAttribute("userPage", user);
        model.addAttribute("posts", posts);
        model.addAttribute("link", "");
        return "home";
    }

    @RequestMapping("/user/{id}")
    public String userPage(@PathVariable(name = "id") String id, Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userPage = (Objects.equals(user.getId(), Long.valueOf(id))) ? user : userService.getUser(Long.valueOf(id));
        List<Post> posts = postService.allPostsUser(userPage);
        model.addAttribute("user", user);
        model.addAttribute("userPage", userPage);
        model.addAttribute("posts", posts);
        model.addAttribute("link", "/user/" + id);
        return "home";
    }

    @RequestMapping("/user")
    public String allUsers(Model model){
        model.addAttribute("users", userService.getAll());
        model.addAttribute("user", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "users";
    }

}
