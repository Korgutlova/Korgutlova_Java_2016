package com.korgutlova.controller;

import com.korgutlova.model.Post;
import com.korgutlova.model.User;
import com.korgutlova.service.PostService;
import com.korgutlova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import java.util.Date;


@Controller
@RequestMapping(value = "/home")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public RedirectView addPost(@RequestParam(name = "user") String user_id,
                                @RequestParam(name = "userPage") String userPage_id,
                                @RequestParam(name = "text") String text,
                                @RequestParam(name= "link") String link) {
        Post post = new Post();
        post.setText(text);
        post.setUserReceiver(userService.getUser(Long.valueOf(userPage_id)));
        post.setUserSender(userService.getUser(Long.valueOf(user_id)));
        post.setDate(new Date(System.currentTimeMillis()));
        postService.addPost(post);
        return new RedirectView("/home/" + link);
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.POST)
    public RedirectView deletePost(@PathVariable(name = "id") String id, @RequestParam(name= "link") String link) {
        postService.deletePost(Long.valueOf(id));
        return new RedirectView("/home/" + link);
    }

    @RequestMapping(value = "/repost/{id}", method = RequestMethod.POST)
    public RedirectView addRepost(@PathVariable(name = "id") String id, @RequestParam(name = "link") String link){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post postOld = postService.getPost(Long.valueOf(id));
        Post post = new Post();
        post.setText("Reposted by " + user.getSurname() + " " + user.getName() + "\n"
                + postOld.getText() + "\n" + postOld.getDate());
        post.setDate(new Date(System.currentTimeMillis()));
        post.setUserSender(postOld.getUserSender());
        post.setUserReceiver(user);
        postService.addPost(post);
        return new RedirectView("/home/" + link);
    }
}
