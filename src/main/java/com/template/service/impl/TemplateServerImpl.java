package com.template.service.impl;

import com.template.entity.User;
import com.template.entity.UserExample;
import com.template.mapper.UserMapper;
import com.template.service.ITemplateServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: guoqing.chen01@hand-china.com 2021-08-22 10:55
 **/

@Service
public class TemplateServerImpl implements ITemplateServer {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public User findOneByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findOneByExample(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (user.getId() != null) {
            criteria.andIdEqualTo(user.getId());
        } else if (user.getName() != null) {
            criteria.andNameEqualTo(user.getName());
        } else if (user.getPassword() != null) {
            criteria.andPasswordEqualTo(user.getPassword());
        } else if (user.getAge() != null) {
            criteria.andAgeEqualTo(user.getAge());
        } else if (user.getAddress() != null) {
            criteria.andAddressEqualTo(user.getAddress());
        }

        List<User> users = userMapper.selectByExample(userExample);

        return users;
    }

    @Override
    public int addOne(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int editOne(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int removeOneByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
