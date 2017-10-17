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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        Integer id = Integer.valueOf(userid);

        //获取user对象的所有数据
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        //封装user对象，并调用service进行数据库操作
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setGender(Integer.valueOf(gender));
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setPhone(phone);
        user.setAddress(address);
        user.setModifyTime(new Date());
        user.setModifyBy(((User) request.getSession().getAttribute(Constants.USER_SESSION)).getId());
        UserService userService = new UserServiceImpl();
        if (userService.updateUser(user)) {
            request.getRequestDispatcher("/usersearch.do").forward(request, response);
        } else {
            request.getRequestDispatcher("jsp/usermodify.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
