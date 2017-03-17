package com.korgutlova.service.impl;

import com.korgutlova.model.Post;
import com.korgutlova.model.User;
import com.korgutlova.repository.PostRepository;
import com.korgutlova.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> allPostsUser(User user) {
        return postRepository.findByUserReceiver(user);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.delete(id);
    }

    @Override
    public Post getPost(Long id) {
        return postRepository.findOne(id);
    }
}
