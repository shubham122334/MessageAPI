package com.App.MessageAPI.service;

import com.App.MessageAPI.dao.CommentRepository;
import com.App.MessageAPI.dao.UserRepository;
import com.App.MessageAPI.entity.Comment;
import com.App.MessageAPI.entity.Users;
import com.App.MessageAPI.exception.InValidException;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ServiceImp {

    private UserRepository userRepository;
    private CommentRepository commentRepository;

    public ServiceImp(UserRepository userRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public void addComment(Users user){

        Users user1= userRepository.findByCommentTo(user.getCommentTo());

        if(user1 !=null){

            user.getComment().forEach(u-> {
                u.setCommentDate(LocalDate.now().toString());
                u.setUsers(user1);
            });
            commentRepository.saveAllAndFlush(user.getComment());

        }
        else {
            user.getComment().forEach(u-> {
                u.setCommentDate(LocalDate.now().toString());
                u.setUsers(user);
            });
            userRepository.save(user);
            commentRepository.saveAll(user.getComment());
        }
    }

    public List<String> getAllComments(String name){

        Users user=userRepository.findByCommentTo(name);
        if(user==null)
            throw new InValidException("user not found");

        List<Comment> commentList=new ArrayList<>();
        commentRepository.findAllByUsersId(user.getId()).forEach(commentList::add);

        return commentList.stream().map(p->p.getMessage()).collect(Collectors.toList());
    }
}
