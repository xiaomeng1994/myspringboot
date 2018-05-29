package com.meng.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meng.service.impl.UserServiceImpl;
import com.meng.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("helloWorld")
public class HelloWorld {

    @Resource(name = "userService")
    private UserServiceImpl userService;

    @RequestMapping("getHelloWorld")
    @ResponseBody
    public String helloWorld(){
        return "HelloWorld";
    }

    @RequestMapping(value = "getHelloWorld2",params = {"currentPage","pageSize"})
    public String helloWorld2(Model model,int currentPage,int pageSize){
        PageHelper.startPage(currentPage,pageSize);
        PageInfo<User> userPageInfo = new PageInfo<>(userService.getUserList());

        model.addAttribute("userPageInfo",userPageInfo);
        return "/HelloWorld";
    }
}
