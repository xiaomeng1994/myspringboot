package com.meng.controller;

import com.meng.service.impl.UserServiceImpl;
import com.meng.vo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource(name = "userService")
    private UserServiceImpl userService;

    @RequestMapping(value = "getUserById",params = {"userId"})
    public User getUserById(String userId){
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "getUserList")
    public List<User> getUserList(){
        return userService.getUserList();
    }

}
