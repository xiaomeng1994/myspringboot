package com.meng.service.impl;

import com.meng.mapper.UserMapper;
import com.meng.service.UserService;
import com.meng.vo.User;
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
