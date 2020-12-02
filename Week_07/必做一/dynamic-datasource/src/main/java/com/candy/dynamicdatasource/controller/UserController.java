package com.candy.dynamicdatasource.controller;

import com.candy.dynamicdatasource.entity.UserDO;
import com.candy.dynamicdatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zh0809
 * @date 2020/12/2 14:23
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/findById/{id}")
    public UserDO findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/findAll")
    public List<UserDO> findAll() {
        return userService.findAll();
    }

}
