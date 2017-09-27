package com.zwx.smbms.servlet;

import com.zwx.smbms.pojo.User;
import com.zwx.smbms.service.UserService;
import com.zwx.smbms.serviceimpl.UserServiceImpl;
import com.zwx.smbms.tools.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String userName=request.getParameter("userName");
       List<User> userList=null;
       //一定要做非空验证，这样一开始请求的时候才能查找到数据
        if (userName==null) {
            userName="";
        }
        UserService userService=new UserServiceImpl();
        userList=userService.getUserList(userName);
        request.setAttribute(Constants.USER_LIST,userList);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
