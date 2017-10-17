package com.zwx.smbms.tools;

import com.alibaba.fastjson.JSONArray;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ToolClass {
    //把hashmap对象转换成json对象输出出去
    public static void convertToJson(Object obj, HttpServletResponse response) throws IOException {
        response.setContentType("json/application");
        PrintWriter writer=response.getWriter();
        writer.write(JSONArray.toJSONString(obj));
        writer.flush();
        writer.close();
    }


}
