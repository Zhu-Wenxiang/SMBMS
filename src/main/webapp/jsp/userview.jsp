<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/10/14
  Time: 下午 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>查看用户详情</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="main">
    <div class="optitle clearfix">
        <div class="title">尊敬的${userSession.userName},您正在查看用户${userInView.userName}的信息&gt;&gt;</div>
    </div>
        <div class="content">
            <table class="box">
                <tbody>
                <tr>
                    <td class="field">用户账号：</td>
                    <td><input type="text" name="userCode" class="text" id="userCode" readonly="readonly" value="${userInView.userCode}">
                    </td>
                </tr>
                <tr>
                    <td class="field">用户名：</td>
                    <td><input type="text" name="userName" class="text" id="userName" value="${userInView.userName}" readonly="readonly">
                </tr>
                <tr>
                    <td class="field">用户性别：</td>
                    <td>
                        <c:if test="${userInView.gender==1}">男</c:if>
                        <c:if test="${userInView.gender==2}">女</c:if>
                    </td>
                </tr>
                <tr>
                    <td>出生日期</td>
                    <td><input type="text" readonly="readonly" value="${userInView.birthDate}"/></td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td><input type="text" readonly="readonly" value="${userInView.age}"/></td>
                </tr>
                <tr>
                    <td class="field">用户电话：</td>
                    <td><input type="text" name="phone" class="text" id="phone" value="${userInView.phone}" readonly="readonly"></td>
                </tr>
                <tr>
                    <td class="field">用户地址：</td>
                    <td><input name="address" id="address" class="text" value="${userInView.address}" readonly="readonly"></td>
                </tr>
                <tr>
                    <td class="field">用户权限：</td>
                    <td>
                        <c:if test="${userInView.userType==1}">管理员</c:if>
                        <c:if test="${userInView.userType==2}">普通用户</c:if>
                        <c:if test="${userInView.userType==3}">经理</c:if>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
</div>
</body>
</html>
