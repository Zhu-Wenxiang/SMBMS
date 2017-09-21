package com.zwx.smbms.serviceimpl;

import com.zwx.smbms.dao.BaseDao;
import com.zwx.smbms.dao.UserDao;
import com.zwx.smbms.daoimpl.UserDaoImpl;
import com.zwx.smbms.pojo.User;
import com.zwx.smbms.service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public UserServiceImpl(){
        userDao=new UserDaoImpl();
    }

    //向数据库中添加数据的service方法，使用事务，并且处理异常
    public boolean add(User user) {
        boolean flag=false;
        Connection connection=null;
        PreparedStatement pstm=null;
        try {
            connection= BaseDao.getConnection();
            //关闭MySQL的自动提交事务
            connection.setAutoCommit(false);
            int updateRows=userDao.add(connection,user);
            //提交操作
            connection.commit();
            if (updateRows>0){
                flag=true;
                System.out.print("添加数据成功");
            }else {
                System.out.println("添加数据失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("添加数据出现异常，正在回滚");
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    public User login(String userCode) {
        Connection connection=null;
        User user=null;
        try {
            connection=BaseDao.getConnection();
            user=userDao.getLoginUser(connection,userCode);
            System.out.println("取到user对象========="+user.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }

        return user;
    }
}
