<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>超市账单管理系统-用户管理</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<div class="menu">
<input type="hidden" name="path" id="path" value="${pageContext.request.contextPath}">
    <table>
        <tbody>
        <tr>
            <td>
                <form method="post" action="${pageContext.request.contextPath}/usersearch.do">
                    <!--<input name="method" value="query" class="input-text" type="hidden">-->
                    用户名：
                    <input name="queryName" class="input-text" type="text" value="${queryName}">&nbsp;&nbsp;&nbsp;&nbsp;
                    <input value="查 询" type="submit">
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div class="main">

    <div class="optitle clearfix">
        <em><input value="添加用户" class="input-button" onclick="window.location='${pageContext.request.contextPath}/jsp/useradd.jsp'" type="button">
        </em>
        <div class="title">用户管理&gt;&gt;</div>
    </div>
    <div class="content">
        <table class="list">
            <tbody>
            <tr>
                <td width="70" height="29"><div class="STYLE1" align="center">用户编码</div></td>
                <td width="80"><div class="STYLE1" align="center">用户名称</div></td>
                <td width="80"><div class="STYLE1" align="center">性别</div></td>
                <td width="100"><div class="STYLE1" align="center">年龄</div></td>
                <td width="100"><div class="STYLE1" align="center">电话</div></td>
                <td width="150"><div class="STYLE1" align="center">用户类型</div></td>
                <td width="150"><div class="STYLE1" align="center">操作</div></td>
            </tr>
            <c:forEach var="user" items="${userlist}" varStatus="status">
                <tr>
                    <td>${user.userCode}</td>
                    <td>${user.userName}</td>
                    <td>
                        <c:if test="${user.gender==1}">男</c:if>
                        <c:if test="${user.gender==2}">女</c:if>
                    </td>
                    <td>${user.age}</td>
                    <td>${user.phone}</td>
                    <td>
                        <c:if test="${user.userType==1}">系统管理员</c:if>
                        <c:if test="${user.userType==3}">经理</c:if>
                        <c:if test="${user.userType==2}">普通员工</c:if>
                    </td>
                    <td>
                        <span><a class="viewUser" href="javascript:;" userid="${user.id}" username="${user.userName}">查看</a></span>
                        <span><a class="modifyUser" href="javascript:;" userid="${user.id}" username="${user.userName}">修改</a></span>
                        <span><a class="deleteUser" href="javascript:;" userid="${user.id}" username="${user.userName}">删除</a></span>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/userlist.js"></script>
</html>