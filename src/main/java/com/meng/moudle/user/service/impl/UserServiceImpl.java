package com.meng.moudle.user.service.impl;

import com.meng.moudle.user.mapper.UserMapper;
import com.meng.moudle.user.service.UserService;
import com.meng.moudle.user.vo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User getUserById(String userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public void deleteUserById(String userId) {
        userMapper.deleteUserById(userId);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }
}
