package com.meng.service.impl;

import com.meng.mapper.UserMapper;
import com.meng.service.UserService;
import com.meng.vo.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User getUserById(int userId) {
        User user = userMapper.getUserById(userId);
        return user;
    }
}
