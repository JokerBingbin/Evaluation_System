package com.XS.service;

import com.XS.pojo.User;

import java.util.List;

public interface UserService {
    //增加一个用户
    int addUser(User user);

    //根据用户id查询用户
    User queryUserById(int id);

    //根据用户名称查询用户
    User queryUserByName(String name);

    //根据用户id删除用户
    int deleteUserById(int id);

    //根据用户名称删除用户
    int deleteUserByName(String name);

    //更新用户
    int updateUser(User user);

    //查询所有用户 返回list合集
    List<User> queryAllUser();
}
