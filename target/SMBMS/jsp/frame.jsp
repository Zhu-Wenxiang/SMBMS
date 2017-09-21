<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<frameset rows="102,*">
	<frame src="${pageContext.request.contextPath}/jsp/top.jsp" id="top"/>
	<frameset cols="20%,*">
		<frame src="${pageContext.request.contextPath }/jsp/left.jsp" id="left" noreSize frameborder="0"/>
		<frame src="${pageContext.request.contextPath }/jsp/main.jsp" id="mainFrame" name="mainFrame" frameborder="0"/>
	</frameset>
</frameset>