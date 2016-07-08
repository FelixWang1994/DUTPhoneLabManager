<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddNews.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
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
  	<%@include file="checkLogin.jsp" %>
  	<jsp:useBean id="modifyPageBean" class="first.ModifyPageBean" scope="page"></jsp:useBean>
  	<jsp:setProperty property="id" name="modifyPageBean" param="id"/>
  	<jsp:setProperty property="username" name="modifyPageBean" value="<%=session.getAttribute(\"username\") %>"/>
  	<jsp:setProperty property="title" name="modifyPageBean" param="titleText"/>
  	<jsp:setProperty property="abstractText" name="modifyPageBean" param="abstractText"/>
  	<jsp:setProperty property="newsContent" name="modifyPageBean" param="editor"/> 	
  	<jsp:setProperty property="date" name="modifyPageBean" value="<%=new java.sql.Date(System.currentTimeMillis())  %>"/>
  	<jsp:setProperty property="countSql" name="modifyPageBean" value=""/>
  	<table>
  		<tr>
  			<td><jsp:getProperty property="countSql" name="modifyPageBean"/>
  			</td>
  			<td>
  				<%=request.getParameter("titleText") %>
  			</td>
  		</tr>
  	</table>
    <%
   		int count = 0;
   		count = modifyPageBean.getRs();
   		if(count == 1){
   			request.getRequestDispatcher("/edit_news.jsp").forward(request,response);
   		}else{
   	%>
   			修改失败！
   	<%
   		}
   	%>
  </body>
</html>
