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
    //通过userCode查看User，返回若为空，则该userCode可用
    public User selectUserCodeExist(String userCode);
    //通过UserName查询特定的User，返回若为空，则该用户名可用
    public User getUserByUserName(String userName);
    //通过id删除用户
    public Boolean deleteUserById(Integer id) ;
    //更新用户数据
    public boolean updateUser(User user);
}
