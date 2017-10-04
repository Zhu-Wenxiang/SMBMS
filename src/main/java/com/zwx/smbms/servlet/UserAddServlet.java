package com.zwx.smbms.servlet;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import com.zwx.smbms.pojo.User;
import com.zwx.smbms.service.UserService;
import com.zwx.smbms.serviceimpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        System.out.println("取到的method是========="+method);
        if (method!=null&&method.equals("userCodeVerify")) {
            userCodeVerify(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void userCodeVerify(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String userCode=request.getParameter("userCode");
        User user=null;
        System.out.println("查看userCode是否被取到======="+userCode);
        HashMap<String,String> resultMap=new HashMap<String, String>();
        //根据userCode查找User
        if (StringUtils.isNullOrEmpty(userCode)) {//判断userCode是否为空
            resultMap.put("userCode","exist");
        } else {
            //若不为空，则使用service方法验证
            UserService userService=new UserServiceImpl();
            user=userService.selectUserCodeExist(userCode);
            System.out.print("查看user是否为空======="+user);
            //根据User是否为空，判断该userCode是否可用
            if (null == user) {
                resultMap.put("userCode", "usable");
            } else {
                //若user为空，则该userCode可用
                resultMap.put("userCode","exist");

            }
        }
        //将resultMap转为json输出到前端(固定步骤)
        //配置上下文输出类型
        response.setContentType("application/json");
        //从response对象中获取往外输出的writer对象
        PrintWriter printWriter=response.getWriter();
        //把resultMap转为json字符串输出
        printWriter.write(JSONArray.toJSONString(resultMap));
        //刷新
        printWriter.flush();
        //关闭流
        printWriter.close();
    }
}
