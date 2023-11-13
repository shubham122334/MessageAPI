package com.App.MessageAPI.dao;

import com.App.MessageAPI.entity.Comment;
import com.App.MessageAPI.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findAllByUsersId(Long id);


}
