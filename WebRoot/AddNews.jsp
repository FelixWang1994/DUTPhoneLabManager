<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
  	
  	<jsp:useBean id="addPageBean" class="first.AddPageBean" scope="page"></jsp:useBean>
  	
  	<jsp:setProperty property="username" name="addPageBean" value="<%=session.getAttribute(\"username\") %>"/>
  
  	<jsp:setProperty property="title" name="addPageBean" param="titleText"/>
  	<jsp:setProperty property="abstractText" name="addPageBean" param="abstractText"/>
  	<jsp:setProperty property="newsContent" name="addPageBean" param="editor"/>
  	
  	<jsp:setProperty property="date" name="addPageBean" value="<%=new java.sql.Date(System.currentTimeMillis())  %>"/>
  	<jsp:setProperty property="countSql" name="addPageBean" value=""/>
  	<table>
  		<tr>
  			<td><jsp:getProperty property="countSql" name="addPageBean"/>
  			</td>
  			<td>
  				<%=request.getParameter("titleText") %>
  			</td>
  		</tr>
  	</table>
    <%
   		int count = 0;
   		count = addPageBean.getRs();
   		if(count == 1){
   			request.getRequestDispatcher("/edit_news.jsp").forward(request,response);
   		}else{
   	%>
   			添加失败！
   	<%
   		}
   	%>
  </body>
</html>
