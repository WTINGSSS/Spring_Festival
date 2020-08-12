package com.czxy.service.impl;

import com.czxy.domain.User;
import com.czxy.mapper.UserMapper;
import com.czxy.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author 庭前云落
 * @Date 2019/12/16 11:10
 * @description
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        Example example = new Example(User.class);
        Example.Criteria c = example.createCriteria();
        c.andEqualTo("user_name", user.getUser_name());
        c.andEqualTo("password", user.getPassword());

       return userMapper.selectOneByExample(example);
    }
}
