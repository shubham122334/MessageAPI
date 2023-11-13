package com.App.MessageAPI.controller;

import com.App.MessageAPI.exception.InValidException;
import com.App.MessageAPI.entity.Users;
import com.App.MessageAPI.service.ServiceImp;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MessageUserController {


    private ServiceImp serviceImp;

    public MessageUserController(ServiceImp serviceImp) {
        this.serviceImp = serviceImp;
    }


    @PostMapping("/addComment")
    public ResponseEntity<String> addCommentByUser(@RequestBody @Valid Users users)
    {
        serviceImp.addComment(users);
        return ResponseEntity.ok("Comment added successfully ");
    }

    @GetMapping("/getComment")
    public List<String> getComment(@RequestParam ("name") String name){

        if(name.trim()=="" || name.isBlank())
            throw new InValidException("Invalid Request");

        List<String> messages=serviceImp.getAllComments(name);

        return messages;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InValidException.class)
    public String handleNotFound(Exception exc){

        return exc.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


}
