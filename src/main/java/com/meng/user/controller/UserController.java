package com.meng.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meng.user.service.impl.UserServiceImpl;
import com.meng.user.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource(name = "userService")
    private UserServiceImpl userService;

    @RequestMapping(value = "getUserById",params = {"userId"})
    @ResponseBody
    public User getUserById(String userId){
        System.out.println(111);
        return userService.getUserById(userId);
    }

    @RequestMapping(value = "getUserList")
    @ResponseBody
    public PageInfo<User>  getUserList(Model model,
             @RequestParam(name = "currentPage",value = "1") int currentPage,
             @RequestParam(name = "pageSize",value = "10") int pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<User> userList = userService.getUserList();
        return new PageInfo<>(userList);
    }

    @RequestMapping("/")
    public String index(){
        return "/UserList";
    }

}
