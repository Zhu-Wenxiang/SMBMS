package com.zwx.smbms.dao;

import com.zwx.smbms.pojo.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {
    //向数据库中增加数据
    public int add(Connection connection, User user) throws Exception;

    //根据UserCode查询某一特定用户的功能
    public User getLoginUser(Connection connection,String userCode) throws Exception;

    //查询用户列表,可根据传入的用户名进行模糊查询
    public List<User> getUserList(Connection connection,String userName) throws Exception;

    //通过特定的userName查找某一个具体用户，主要用于检查用户名是否有重复
    public User getUserByUserName(Connection connection,String userName) throws Exception;

    //通过指定userid删除指定用户
    public int deleteUserByID(Connection connection,Integer id) throws Exception;

    //修改用户数据
    public int updateUser(Connection connection,User user) throws Exception;

}
