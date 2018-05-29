package com.meng.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        System.out.println(111);
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "getUserList",params = {"currentPage","pageSize"})
    public PageInfo<User>  getUserList(int currentPage,int pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<User> userList = userService.getUserList();
        return new PageInfo<>(userList);
    }

}
