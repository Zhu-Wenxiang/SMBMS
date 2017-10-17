package com.zwx.smbms.serviceimpl;

import com.zwx.smbms.dao.BaseDao;
import com.zwx.smbms.dao.UserDao;
import com.zwx.smbms.daoimpl.UserDaoImpl;
import com.zwx.smbms.pojo.User;
import com.zwx.smbms.service.UserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    //向数据库中添加数据的service方法，使用事务，并且处理异常
    public boolean add(User user) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            //关闭MySQL的自动提交事务
            connection.setAutoCommit(false);
            int updateRows = userDao.add(connection, user);
            //提交操作
            connection.commit();
            if (updateRows > 0) {
                flag = true;
                System.out.print("添加数据成功");
            } else {
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
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    //通过特定userCode找到用户的方法
    public User login(String userCode) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection, userCode);
            System.out.println("取到user对象=========" + user.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return user;
    }

    //通过用户名进行模糊查询查找用户列表
    public List<User> getUserList(String userName) {
        List<User> users = null;
        Connection connection = null;
       /*应该在servlet里面进行该验证
       if (userName==null) {
            userName="";
        }*/
        try {
            connection = BaseDao.getConnection();
            users = userDao.getUserList(connection, userName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return users;
    }

    //通过userCode看用户是否存在，如果存在，则该userCode已经注册，不存在则未注册
    public User selectUserCodeExist(String userCode) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection, userCode);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }

    //根据userName查询特定User的方法,用于检查userName是否重复
    public User getUserByUserName(String userName) {
        Connection connection = null;
        User user = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getUserByUserName(connection, userName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }
        return user;
    }

    //根据userid删除User的方法
    public Boolean deleteUserById(Integer id) {
        Boolean flag = false;
        Connection connection = null;
        try {
            connection=BaseDao.getConnection();
            if (connection!=null) {
                if (userDao.deleteUserByID(connection, id) > 0) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    public boolean updateUser(User user) {
        Connection connection=null;
        boolean flag=false;
        if (null!=user) {
            //关闭MySQL事务自动提交
            connection=BaseDao.getConnection();
            try {
                connection.setAutoCommit(false);
                if (userDao.updateUser(connection,user)>=0) {
                    flag=true;
                }
                connection.commit();
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    connection.rollback();
                    System.out.println("更新数据出现异常，userService内的updateUser()发生异常");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    System.out.println("updateUser()数据回滚出现异常");
                }
            } catch (Exception e) {
                System.out.println("数据更新的userDao方法出现异常");
                e.printStackTrace();
            } finally {
                BaseDao.closeResource(connection,null,null);
            }
        }
        return flag;
    }
}
