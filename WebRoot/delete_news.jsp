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
    
    <title>My JSP 'delete_news.jsp' starting page</title>
    
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
    
   	<jsp:useBean id="deletePageBean" class="first.deletePageBean" scope="page"></jsp:useBean>
   	<jsp:setProperty property="id" name="deletePageBean" param="id"/>
   	<jsp:setProperty property="countSql" name="deletePageBean" value="delete from news "/>
   	<table border="1">
    	<tr>
    		<td><jsp:getProperty property="id" name="deletePageBean"/></td>
    		<td>
    			<jsp:getProperty property="countSql" name="deletePageBean"/>
    		</td>
    	</tr>
    </table>
   	<%
   		int count = 0;
   		count = deletePageBean.getRs();
   		if(count == 1){
   			response.sendRedirect("edit_news.jsp");
   		}else{
   	%>
   			删除失败！
   	<%
   		}
   	%>
   	
  </body>   	
</html>
