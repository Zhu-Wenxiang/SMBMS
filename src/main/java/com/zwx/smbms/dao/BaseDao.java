package com.zwx.smbms.dao;

import com.zwx.smbms.tools.ConfigManager;

import java.sql.*;

public class BaseDao {
    //获取数据连接的基类
    public static Connection getConnection(){
        Connection connection=null;
        String driver= ConfigManager.getInstance().getValue("DRIVER");
        String url= ConfigManager.getInstance().getValue("URL");
        String userName= ConfigManager.getInstance().getValue("USERNAME");
        String password= ConfigManager.getInstance().getValue("PASSWORD");
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,userName,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭资源的方法
    public static boolean closeResource(Connection connection, PreparedStatement pstm, ResultSet rs) {
        boolean flag=true;
        if (rs!=null){
            try {
                rs.close();
                rs=null;//GC回收
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        if (pstm!=null){
            try {
                pstm.close();
                pstm=null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }
        if (connection!=null){
            try {
                connection.close();
                connection=null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag=false;
            }
        }

        return flag;
    }

    //查询方法
    public static ResultSet execute(Connection connection,PreparedStatement pstm,ResultSet rs,String sql,Object[] params) throws SQLException {
        pstm=connection.prepareStatement(sql);
        //pstm中的参数从1开始，数组的下标从0开始
        for (int i = 0; i <params.length ; i++) {
           pstm.setObject(i+1,params[i]);
        }
        rs=pstm.executeQuery();
        return rs;
    }

    //增删改方法,也就是更新操作
    public static int execute(Connection connection,PreparedStatement pstm,String sql,Object[] params) throws SQLException {
        pstm=connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
           pstm.setObject(i+1,params[i]);
        }
        return pstm.executeUpdate();
    }
}
