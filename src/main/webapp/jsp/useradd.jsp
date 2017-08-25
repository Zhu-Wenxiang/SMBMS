<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="main">
	<input type="hidden" name="path" id="path" value="${pageContext.request.contextPath}">
	<div class="optitle clearfix">
		<div class="title">用户管理&gt;&gt;</div>

	</div>
	<form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath}/user.do">
		<input type="hidden" name="method" value="add">
		<div class="content">
			<table class="box">
			   <tbody><tr>
					<td class="field">用户编码：</td>
					<td><input type="text" name="userCode" class="text" id="userCode" value=""> <font color="red"></font><font color="red" id="userCode_span"></font></td>
				</tr>
				 <tr>
					<td class="field">用户名称：</td>
					<td><input type="text" name="userName" class="text" id="userName" value=""> <font color="red"></font><font color="red" id="userName_span"></font></td>
				</tr>
				 <tr>
					<td class="field">用户密码：</td>
					<td><input type="password" name="userPassword" class="text" id="userPassword" value=""> <font color="red"></font><font color="red" id="userPassword_span"></font></td>
				</tr>
				 <tr>
					<td class="field">确认密码：</td>
					<td><input type="password" name="ruserPassword" class="text" id="ruserPassword" value=""> <font color="red"></font></td>
				</tr>
				<tr>
					<td class="field">用户性别：</td>
					<td><select name="gender" id="gender">
						    <option value="1" checked="checked">男</option>
						    <option value="2">女</option>
						 </select></td>
				</tr>
				<tr>
					<td class="field">出生日期：</td>
					<td><input type="text" Class="Wdate" id="birthday" name="birthday" readonly="readonly" onclick="WdatePicker();"> <font color="red"></font><font color="red" id="birthday_span"></font></td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><input type="text" name="phone" class="text" id="phone" value=""> <font color="red"></font><font color="red" id="phone_span"></font></td>

				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td><input name="address" id="address" class="text" value=""><font color="red"></font><font color="red" id="address_span"></font></td>
				</tr>
				<tr>
					<td class="field">用户权限：</td>

					<td><input type="radio" name="userType" value="1">管理员<input type="radio" name="userType" value="2" >经理
					<input type="radio" name="userType" value="3" checked="true">普通用户</td>
				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="button" name="add" id="add" value="保存" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>

	</form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/useradd.js"></script>
</body></html>