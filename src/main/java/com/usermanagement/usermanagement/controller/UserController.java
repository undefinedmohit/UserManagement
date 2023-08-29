package com.usermanagement.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.usermanagement.entity.UserEntity;
import com.usermanagement.usermanagement.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    String create(@RequestBody UserEntity entity)
    {
       return userService.create(entity);
    }

    @PutMapping
    String update(@RequestBody UserEntity entity)
    {
       return userService.update(entity);
    }
    @DeleteMapping 
    String delete(@RequestParam long id)
    {
       return userService.delete(id);
    }
    @GetMapping
    UserEntity get(@RequestParam long id)
    {
       return userService.get(id);
    }
}
