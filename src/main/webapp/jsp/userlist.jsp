<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>超市账单管理系统-用户管理</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="menu">

    <table>
        <tbody>
        <tr>
            <td>
                <form method="post" action="user.do">
                    <input name="method" value="query" class="input-text" type="hidden"> 用户名：<input name="name"
                                                                                                    class="input-text"
                                                                                                    type="text"
                                                                                                    value="">&nbsp;&nbsp;&nbsp;&nbsp;
                    <input value="查 询" type="submit">
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="main">

    <div class="optitle clearfix">
        <em><input value="添加用户" class="input-button" onclick="window.location='userAdd.html'" type="button">
        </em>
        <div class="title">用户管理&gt;&gt;</div>
    </div>
    <div class="content">
        <table class="list">
            <tbody>
            <tr>
                <td width="70" height="29">
                    <div class="STYLE1" align="center">编号</div>
                </td>
                <td width="80">
                    <div class="STYLE1" align="center">用户名</div>
                </td>
                <td width="80">
                    <div class="STYLE1" align="center">用户账号</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">性别</div>
                </td>
                <td width="100">
                    <div class="STYLE1" align="center">年龄</div>
                </td>
                <td width="150">
                    <div class="STYLE1" align="center">电话</div>
                </td>
                <td width="150">
                    <div class="STYLE1" align="center">权限</div>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>