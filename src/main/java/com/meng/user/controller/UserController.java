package com.meng.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meng.user.service.impl.UserServiceImpl;
import com.meng.user.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "/api/user",description = "用户管理接口",tags = "UserController")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource(name = "userService")
    private UserServiceImpl userService;

    @ApiOperation(value = "查询用户",notes = "根据用户ID获取用户")
    @ApiParam(required = true,name = "userId",value = "用户id")
    @RequestMapping(method = RequestMethod.GET,value = "getUserById/{userId}")
    public User getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @ApiOperation(value = "获取用户列表信息")
    @RequestMapping(method = RequestMethod.POST,value = "getUserList")
    public PageInfo<User>  getUserList(
             @RequestParam(name = "currentPage",defaultValue = "1") int currentPage,
             @RequestParam(name = "pageSize",defaultValue = "10") int pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<User> userList = userService.getUserList();
        return new PageInfo<>(userList);
    }



}
