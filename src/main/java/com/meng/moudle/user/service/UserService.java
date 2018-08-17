package com.meng.moudle.user.service;

import com.meng.moudle.user.vo.User;

import java.util.List;

public interface UserService {
    //查询用户集合
    List<User> getUserList();
    //根据id查询用户
    User getUserById(String userId);
    //根据id删除用户
    void deleteUserById(String userId);
    //新增用户
    void insertUser(User user);
    //根据id修改用户
    void updateUserById(User user);
}
