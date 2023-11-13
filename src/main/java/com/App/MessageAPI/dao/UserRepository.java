package com.App.MessageAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.App.MessageAPI.entity.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long>{
    Users findByCommentTo(String name);


}
