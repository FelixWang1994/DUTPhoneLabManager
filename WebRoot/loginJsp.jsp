<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>用户登录</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<%
			 //获取用户名参数
			 String username = request.getParameter("username");
			 if(username == null || "".equals(username)){
			 	//如果请求参数没有，就从会话里获取
			 	username = (String)session.getAttribute("username");
			 }
			 //如果用户名为空则要求重新登录
			 if(username == null || "".equals(username)){
			 	response.sendRedirect("login.html");
			 }else{
			 	//保存用户名到会话中
			 	session.setAttribute("username",username);
			 }
		 %>
		<jsp:useBean id="loginBean" class="first.LoginBean" scope="page"></jsp:useBean>
		<jsp:setProperty property="username" name="loginBean" param="username" />
		<jsp:setProperty property="password" name="loginBean" param="password" />
		<%
			if (!loginBean.checkUser()){
		%>
			<a href="login.html"> <jsp:getProperty property="username"
				name="loginBean" /> </a>
		<%
			}else{
			if (!loginBean.checkPassword()) {
		%>
			<a href="login.html"> <jsp:getProperty property="password"
				name="loginBean" /> </a>
		<%
			} else {
		%>
		<jsp:setProperty property="searchSql" name="loginBean"
			value="select * from manager where username = ?" />
		<%
			if (loginBean.check()) {
					response.sendRedirect("edit_news.jsp");
				} else {
		%>
		<a href="login.html"> 用户名或密码错误，点击返回输入 </a>
		<%
			}
			}
			}
		%>
	</body>
</html>
