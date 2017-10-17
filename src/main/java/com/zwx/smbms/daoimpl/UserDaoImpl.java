package com.zwx.smbms.daoimpl;

import com.zwx.smbms.dao.BaseDao;
import com.zwx.smbms.dao.UserDao;
import com.zwx.smbms.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    //添加数据的具体实现方法
    public int add(Connection connection, User user) throws Exception {
        PreparedStatement pstm=null;
        int updateRows=0;
        if (null!=connection){
            String sql="insert into smbms_user (userCode,userName,userPassword,gender,birthday,phone,address,userType,createdBy,creationDate) values (?,?,?,?,?,?,?,?,?,?)";
            Object[] params={user.getUserCode(),user.getUserName(),user.getUserPassword(),user.getGender(),user.getBirthday(),user.getPhone(),user.getAddress(),user.getUserType(),user.getCreatedBy(),user.getCreationTime()};
            updateRows=BaseDao.execute(connection,pstm,sql,params);
            //要使用事务，connection一定要在service关闭
            BaseDao.closeResource(null,pstm,null);
        }
        return updateRows;
    }

    //根据用户的user Code查询特定用户，旨在为登陆功能服务
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

    //根据用户名查找用户，主要用于查询用户列表查询及用户检索
    public List<User> getUserList(Connection connection, String userName) throws Exception {
        PreparedStatement pstm=null;
        ResultSet resultSet=null;
        List<User> userList=new ArrayList<User>();
        if (null!=connection) {
           String sql="select * from smbms_user where userName like ?";
           Object[] params={"%"+userName+"%"};
           pstm=connection.prepareStatement(sql);
           resultSet=BaseDao.execute(connection,pstm,resultSet,sql,params);
           while(resultSet.next()) {
               User user = new User();
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
               userList.add(user);
           }
        }
        BaseDao.closeResource(null,pstm,resultSet);
        return userList;
    }

    //根据用户名精确查找用户
    public User getUserByUserName(Connection connection, String userName) throws Exception {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        User user=null;
        String sql="select * from smbms_user where userName=?";
        Object[] params={userName};
        if (connection!=null) {
            resultSet=BaseDao.execute(connection,preparedStatement,resultSet,sql,params);
            if (resultSet.next()) {
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
        BaseDao.closeResource(null,preparedStatement,resultSet);
        return user;
    }

    //根据用户id删除用户
    public int deleteUserByID(Connection connection, Integer id) throws Exception{
        int updateRows=0;
        if (connection!=null) {
            String sql="delete from smbms_user where id=?";
            PreparedStatement preparedStatement=null;
            Object[] params={id};
            updateRows=BaseDao.execute(connection,preparedStatement,sql,params);
            BaseDao.closeResource(null,preparedStatement,null);
        }
        return updateRows;
    }

    //更新用户数据
    public int updateUser(Connection connection, User user) throws Exception {
        PreparedStatement preparedStatement=null;
        int updateRows=-1;
        if (connection!=null) {
           String sql="update smbms_user set userName=?,gender=?,birthday=?,phone=?,address=?,userType=?,modifyBy=?,modifyDate=? where id=?";
           Object[] params={user.getUserName(),user.getGender(),user.getBirthday(),user.getPhone(),user.getAddress(),user.getUserType(),user.getModifyBy(),user.getModifyTime(),user.getId()};
           updateRows=BaseDao.execute(connection,preparedStatement,sql,params);
           BaseDao.closeResource(null,preparedStatement,null);
        }
        return updateRows;
    }

}
