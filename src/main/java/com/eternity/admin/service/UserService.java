package com.eternity.admin.service;

import com.eternity.admin.bean.User;
import com.eternity.admin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUserById(Integer id){
        User user = userMapper.getUser(id);
        return user;
    }

}
