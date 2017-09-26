package com.zwx.smbms.service;

import com.zwx.smbms.pojo.User;

import java.util.List;

public interface UserService {

    //向数据库中添加数据的方法,要求使用事务
    public boolean add(User user);
    //获取登录用户
    public User login(String userCode);
    //根据前台传来的userName查询用户列表
    public List<User> getUserList(String userName);
}
