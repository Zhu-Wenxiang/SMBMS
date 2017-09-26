package com.zwx.smbms.servlet;

import com.zwx.smbms.pojo.User;
import com.zwx.smbms.service.UserService;
import com.zwx.smbms.serviceimpl.UserServiceImpl;
import com.zwx.smbms.tools.Constants;

import java.io.IOException;

public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userCode=request.getParameter("userCode");
        String userPassword=request.getParameter("userPassword");
        UserService userService=new UserServiceImpl();
        User user=null;

        user=userService.login(userCode);
        System.out.println("取到的user是======>"+user.getUserName());
        System.out.println("取到的密码是=====>"+user.getUserPassword());
        if (null!=user){
            if (!(user.getUserPassword().equals(userPassword))) {
                //若查询得到的用户密码与传入的用户密码不匹配，提示
                request.setAttribute(Constants.PASSWORD_ERROR, Constants.PASSWORD_ERROR_HINT);
                request.getRequestDispatcher("login.jsp").forward(request,response);
                //request.setAttribute("error_password","密码错误");
            } else {
                request.getSession().setAttribute(Constants.USER_SESSION,user);
                response.sendRedirect("/jsp/frame.jsp");
            }
        }else {
            //若无法查询到该用户，则提示用户不存在
            request.setAttribute(Constants.NO_SUCH_USER,Constants.NO_SUCH_USER_HINT);
            //request.setAttribute("error_user","该用户不存在");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
