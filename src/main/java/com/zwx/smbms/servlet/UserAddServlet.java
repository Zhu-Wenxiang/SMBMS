package com.zwx.smbms.servlet;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.Constants;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class UserAddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserService userService=new UserServiceImpl();
        HashMap<String,String> resultMap=new HashMap<String, String>();
        String ajaxmethod=request.getParameter("ajaxmethod");
        String method=request.getParameter("method");
        System.out.println("取到的method是========="+ajaxmethod);
        if (ajaxmethod!=null&&ajaxmethod.equals("userCodeVerify")) {
            this.userCodeVerify(request,response,userService,resultMap);
        } else if (ajaxmethod!=null&&ajaxmethod.equals("userNameVerify")) {
            try {
                this.userNameVerify(request,response,userService,resultMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (method != null && method.equals("addUser")) {
            try {
                this.userAdd(request,response,userService);
                System.out.println("已经完成UserAddServlet中的this.userAdd方法");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    //Ajax异步验证userCode是否存在的方法
    protected void userCodeVerify(HttpServletRequest request,HttpServletResponse response,UserService userService,HashMap resultMap) throws IOException {
        String userCode=request.getParameter("userCode");
        User user=null;
        System.out.println("查看userCode是否被取到======="+userCode);
        //根据userCode查找User
        if (StringUtils.isNullOrEmpty(userCode)) {//判断userCode是否为空
            resultMap.put("userCode","userCodeNull");
        } else {
            //若不为空，则使用service方法验证
            user=userService.selectUserCodeExist(userCode);
            //System.out.print("查看user是否为空======="+user);
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

    //userName异步验证函数的请求方法
    protected void userNameVerify(HttpServletRequest request,HttpServletResponse response,UserService userService,HashMap resultMap) throws Exception{
        String userName=request.getParameter("userName");
        System.out.println("在userAddServlet中取到的userName是======="+userName);
        User user=null;
        if (StringUtils.isNullOrEmpty(userName)) {//判断userName是否为空
            resultMap.put("result","userNameNull");
        }else{//userName不为空的情况下，得到的结果
            user=userService.getUserByUserName(userName);
            if (null == user) {
                resultMap.put("result", "userNameUsable");
            } else {
                resultMap.put("result","userNameExist");
            }
        }
        //把结果转成json输出到jsp页面中
        response.setContentType("application/json");
        PrintWriter printWriter=response.getWriter();
        printWriter.write(JSONArray.toJSONString(resultMap));
        printWriter.flush();
        printWriter.close();
    }

    //添加user的add方法
    protected void userAdd(HttpServletRequest request,HttpServletResponse response,UserService userService) throws Exception{
        String path=request.getParameter("path");
        //取到前台传入的数据，所有得到的结果均为字符串
        String userCode=request.getParameter("userCode");
        String userName=request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        String phone = request.getParameter("phone");
        String address=request.getParameter("address");
        String userType = request.getParameter("userType");

        //新建User对象，存入数据
        User user = new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setGender(Integer.valueOf(gender));
        user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthDate));
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserType(Integer.valueOf(userType));
        user.setCreatedBy(((User)request.getSession().getAttribute(com.zwx.smbms.tools.Constants.USER_SESSION)).getId());
        user.setCreationTime(new Date());
        if (userService.add(user)) {
            //request.getRequestDispatcher("usersearch.do").forward(request,response);
            response.sendRedirect( "/usersearch.do");
        } else {
            request.getRequestDispatcher("jsp/useradd.jsp").forward(request,response);
        }
    }


}
