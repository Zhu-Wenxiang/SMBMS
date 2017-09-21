<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
        <title>超市账单管理系统-欢迎页</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
</head>
<body>
<h2>Hello World!</h2>
<h6>这是超市供应商管理系统演示应用</h6>
路径："${pageContext.request.contextPath}"
路径:<%=request.getServletContext().getRealPath("/")%>
lujing:<%=request.getContextPath()%>
测试是否可以热更新jsp页面
</body>
</html>
