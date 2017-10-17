package com.zwx.smbms.servlet;

import com.alibaba.fastjson.JSONArray;
import com.zwx.smbms.service.UserService;
import com.zwx.smbms.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入UserDeleteServlet方法");
        String userid=request.getParameter("userid");
        Integer id=Integer.valueOf(userid);
        UserService userService=new UserServiceImpl();
        HashMap<String,String> deleteResult=new HashMap<String, String>();
        if (id < 0) {
            deleteResult.put("deleteResult", "notExist");
        } else {
            if (userService.deleteUserById(id)) {
                deleteResult.put("deleteResult", "deleted");
                System.out.println("执行了delete方法");
            } else {
                deleteResult.put("deleteResult","failed");
            }
        }

        //将带有提示信息的deleteResult转换成json格式传输到前台
        response.setContentType("json/application");
        PrintWriter writer=response.getWriter();
        writer.write(JSONArray.toJSONString(deleteResult));
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
