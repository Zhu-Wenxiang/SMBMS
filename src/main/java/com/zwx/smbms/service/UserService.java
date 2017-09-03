package com.zwx.smbms.service;

import com.zwx.smbms.pojo.User;

public interface UserService {

    //向数据库中添加数据的方法,要求使用事务
    public boolean add(User user);
}
