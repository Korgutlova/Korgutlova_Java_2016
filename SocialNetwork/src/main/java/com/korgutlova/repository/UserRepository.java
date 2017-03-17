package com.korgutlova.repository;

import com.korgutlova.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{
    User findOneByEmail(String email);

    User findOneById(Long id);
}
