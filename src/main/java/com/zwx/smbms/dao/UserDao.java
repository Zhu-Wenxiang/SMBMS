package com.zwx.smbms.dao;

import com.zwx.smbms.pojo.User;

import java.sql.Connection;

public interface UserDao {
    //向数据库中增加数据
    public int add(Connection connection, User user) throws Exception;

    //查询数据操作
    
}
