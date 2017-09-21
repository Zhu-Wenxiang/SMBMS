package com.zwx.smbms.daoimpl;

import com.zwx.smbms.dao.BaseDao;
import com.zwx.smbms.dao.UserDao;
import com.zwx.smbms.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao{

    //添加数据的具体实现方法
    public int add(Connection connection, User user) throws Exception {
        PreparedStatement pstm=null;
        int updateRows=0;
        if (null!=connection){
            String sql="insert into smbms_user (userCode,userName,userPassword) values (?,?,?)";
            Object[] params={user.getUserCode(),user.getUserName(),user.getUserPassword()};
            updateRows=BaseDao.execute(connection,pstm,sql,params);
            //要使用事务，connection一定要在service关闭
            BaseDao.closeResource(null,pstm,null);
        }
        return updateRows;
    }

    public User getLoginUser(Connection connection, String userCode) throws Exception {
        PreparedStatement pstm=null;
        ResultSet resultSet=null;
        User user=null;
        if (null!=connection){
            String sql="select * from smbms_user where userCode=?";
            Object[] params={userCode};
            resultSet=BaseDao.execute(connection,pstm,resultSet,sql,params);
            if (resultSet.next()){
                user=new User();
                user.setUserName(resultSet.getString("userName"));
                user.setUserPassword(resultSet.getString("userPassword"));
                user.setUserCode(resultSet.getString("userCode"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setCreationTime(resultSet.getTimestamp("creationDate"));
                user.setId(resultSet.getInt("id"));
                user.setAddress(resultSet.getString("address"));
                user.setCreatedBy(resultSet.getInt("createdBy"));
                user.setModifyBy(resultSet.getInt("modifyBy"));
                user.setGender(resultSet.getInt("gender"));
                user.setPhone(resultSet.getString("phone"));
                user.setUserType(resultSet.getInt("userType"));
                user.setModifyTime(resultSet.getDate("modifyDate"));
            }
        }
        BaseDao.closeResource(null,pstm,resultSet);
        return user;
    }
}
