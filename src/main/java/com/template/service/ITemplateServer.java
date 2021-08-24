package com.template.service;

import com.template.entity.User;
import com.template.entity.UserExample;

import java.util.List;

/**
 * @author: guoqing.chen01@hand-china.com 2021-08-22 10:49
 **/

public interface ITemplateServer {
    /**
     * 查找所有的用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查找一个用户
     * @param id
     * @return
     */
    User findOneByPrimaryKey(Integer id);

    /**
     * 根据example查找用户
     * @return
     */
    List<User> findOneByExample(User user);

    /**
     * 添加一个用户
     * @param user
     * @return
     */
    int addOne(User user);

    /**
     * 修改一个用户
     * @param user
     * @return
     */
    int editOne(User user);

    /**
     * 删除一个用户
     * @param id
     * @return
     */
    int removeOneByPrimaryKey(Integer id);
}
