<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/10/14
  Time: 下午 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改用户</title>
</head>
<body>
<form id="userModifyForm" name="userModifyForm" method="post" action="/modifyuser.do">
    <input type="hidden" name="userid" id="userid" value="${user.id}">
    <div class="content">
        <table class="box">
            <tbody>
            <tr>
                <td class="field">用户账号：</td>
                <td><input type="text" name="userCode" class="text" id="userCode" value="${user.userCode}" readonly="readonly">
                    <font color="red"></font>
                </td>
            </tr>
            <tr>
                <td class="field">用户名：</td>
                <td><input type="text" name="userName" class="text" id="userName" value="${user.userName}">
                    <font color="red"></font>
                <td>
            </tr>
            <tr>
                <td class="field">用户性别：</td>
                <td><select name="gender" id="gender">
                    <c:choose>
                        <c:when test="${user.gender==1}">
                            <option value="1" selected="selected">男</option>
                            <option value="2" >女</option>
                        </c:when>
                        <c:otherwise>
                            <option value="1">男</option>
                            <option value="2" selected="selected">女</option>
                        </c:otherwise>
                    </c:choose>
                </select>
                </td>
            </tr>
            <tr>
                <td class="field">出生日期：</td>
                <td>
                    <input type="text" name="birthDate" class="Wdate" id="birthDate" readonly="readonly" onclick="WdatePicker();" value="${user.birthDate}">
                    <font color="red"></font>
                </td>
            </tr>
            <tr>
                <td class="field">用户电话：</td>
                <td><input type="text" name="phone" class="text" id="phone" value="${user.phone}">
                    <font color="red"></font></td>
            </tr>
            <tr>
                <td class="field">用户地址：</td>
                <td><input name="address" id="address" class="text" value="${user.address}">
                <font color="red"></font></td>
            </tr>
            <tr>
                <td class="field">用户权限：</td>
                <td><input type="radio" name="userType" value="1" <c:if test="${user.userType==1}">checked="checked"</c:if>>管理员
                    <input type="radio" name="userType" value="2" <c:if test="${user.userType==2}">checked="checked"</c:if>>普通用户
                    <input type="radio" name="userType" value="3" <c:if test="${user.userType==3}">checked="checked"</c:if>>经理
                </td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="buttons">
        <input type="button" name="addBtn" id="addBtn" value="保存" class="input-button">
        <input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button">
    </div>
</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/calendar/WdatePicker.js"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/common.js"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user/usermodify.js"/>
</html>
