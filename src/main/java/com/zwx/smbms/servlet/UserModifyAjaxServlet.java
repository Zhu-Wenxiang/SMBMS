package com.zwx.smbms.servlet;

import com.alibaba.fastjson.JSONArray;
import com.zwx.smbms.pojo.User;
import com.zwx.smbms.service.UserService;
import com.zwx.smbms.serviceimpl.UserServiceImpl;
import com.zwx.smbms.tools.Constants;
import com.zwx.smbms.tools.ToolClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class UserModifyAjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 怎样如果用户没有改名字怎么判断重名？通过userName取到数据库内
         * 的user，将其id与当前userid对比，如果相同仍然通过
         **/
        String userName = request.getParameter("userName");
        String userid=request.getParameter("userId");
        int id = Integer.valueOf(userid);
        HashMap<String,String> duplicatResult=new HashMap<String, String>();
        String resultOfService=this.userNameDuplicationVerify(userName,id);
        duplicatResult.put("duplicateResult",resultOfService);
        //将map转换成json字符串输出
       /* response.setContentType("json/applicatoin");
        PrintWriter writer=response.getWriter();
        writer.write(JSONArray.toJSONString(duplicatResult));
        writer.flush();
        writer.close();*/
        ToolClass.convertToJson(duplicatResult,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    //判断新的userName是否有重复
    public String userNameDuplicationVerify(String userName,int id){
        String hint=null;
        UserService userService=new UserServiceImpl();
        User userInDateBase=new User();
        userInDateBase=userService.getUserByUserName(userName);
        if (userInDateBase.getId() == id || userInDateBase == null) {
            hint = Constants.NOT_DUPLICATE_USER_NAME;
        } else {
            hint=Constants.DUPLICATE_USER_NAME;
        }
        return hint;
    }
}
