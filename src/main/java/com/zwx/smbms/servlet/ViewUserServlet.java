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

public class ViewUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userCode=request.getParameter("userCode");
        UserService userService = new UserServiceImpl();
        User user=null;
        user=userService.login(userCode);
        if (user != null) {
            request.setAttribute(Constants.USER_IN_VIEW, user);
        } else {
            request.setAttribute("message",Constants.ALERT_MESSAGE);
        }
        request.getRequestDispatcher("jsp/userview.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
