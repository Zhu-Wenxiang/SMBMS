package com.zwx.smbms.tools;

public class Constants {
    //用户的session常量,存储user对象的键名称
    public final static String USER_SESSION="userSession";
    //用户名错误的显示信息
    public final static String NO_SUCH_USER="noSuchUser";
    public final static String NO_SUCH_USER_HINT="用户不存在呢";
    //密码错误的显示信息
    public final static String PASSWORD_ERROR="passwordError";
    public final static String PASSWORD_ERROR_HINT="您的密码不正确，请重新输入";
    //存入request中的用户列表字符串
    public final static String USER_LIST="userlist";
    //要查询的用户名
    public final static String QUERY_NAME="queryName";
    //在userModifyAjaxServlet中要使用到的userName是否重复的提示字符串
    public final static String DUPLICATE_USER_NAME="userNameDuplicate";
    public final static String NOT_DUPLICATE_USER_NAME= "userNameNotDuplicate";
    //在ViewUserServlet中用来存储获得的user对象的key
    public final static String USER_IN_VIEW="userInView";
    public final static String ALERT_MESSAGE="出现未知错误,该用户不存在";
}
