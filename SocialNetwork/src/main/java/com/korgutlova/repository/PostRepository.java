package com.korgutlova.repository;

import com.korgutlova.model.Post;
import com.korgutlova.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserReceiver(User user);
}
