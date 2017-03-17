package com.korgutlova.service;

import com.korgutlova.model.Post;
import com.korgutlova.model.User;

import java.util.List;

public interface PostService {

    void addPost(Post post);

    List<Post> allPostsUser(User user);

    void deletePost(Long id);

    Post getPost(Long id);
}
