package com.zwx.smbms.daoimpl;

import com.zwx.smbms.dao.BaseDao;
import com.zwx.smbms.dao.UserDao;
import com.zwx.smbms.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDaoImpl implements UserDao{

    //添加数据的具体实现方法
    public int add(Connection connection, User user) throws Exception {
        PreparedStatement pstm=null;
        String sql="insert into smbms_user (userCode,userName,userPassword) values (?,?,?)";
        Object[] params={user.getUserCode(),user.getUserName(),user.getUserPassword()};
        connection=BaseDao.getConnection();
        int updateRows=BaseDao.execute(connection,pstm,sql,params);
        //要使用事务，connection一定要在service关闭
        BaseDao.closeResource(null,pstm,null);
        return updateRows;
    }
}
