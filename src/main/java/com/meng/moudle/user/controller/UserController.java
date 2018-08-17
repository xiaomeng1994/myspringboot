package com.meng.moudle.user.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meng.commnon.ReturnMessage;
import com.meng.moudle.user.service.UserService;
import com.meng.moudle.user.vo.User;
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
    private UserService userService;

    @ApiOperation(value = "获取用户列表信息")
    @RequestMapping(method = RequestMethod.POST,value = "getUserList")
    public PageInfo<User>  getUserList(
             @RequestParam(name = "currentPage",defaultValue = "1") int currentPage,
             @RequestParam(name = "pageSize",defaultValue = "10") int pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<User> userList = userService.getUserList();
        return new PageInfo<>(userList);
    }

    @ApiOperation(value = "查询用户",notes = "根据用户ID获取用户")
    @ApiParam(required = true,name = "userId",value = "用户id")
    @RequestMapping(method = RequestMethod.GET,value = "getUserById/{userId}")
    public User getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @ApiOperation(value = "修改用户",notes = "根据用户ID修改用户")
    @RequestMapping(method = RequestMethod.PUT,value = "/updateUser")
    public ReturnMessage updateUserById(@RequestBody User user){//RequestBody注解让springboot将json对象转换成对象
        userService.updateUserById(user);
        return new ReturnMessage("修改成功!");
    }

    @ApiOperation(value = "删除用户",notes = "根据用户ID删除用户")
    @ApiParam(required = true,name = "userId",value = "用户id")
    @RequestMapping(method = RequestMethod.DELETE,value = "/updateUser/{userId}")
    public ReturnMessage deleteUserById(@PathVariable String userId) {
        userService.deleteUserById(userId);
        return new ReturnMessage("删除成功!");
    }

}
