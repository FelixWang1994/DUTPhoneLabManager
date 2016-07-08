<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>查看新闻</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/news.css">
	

  </head>
  
  <body>
    	<%@include file="checkLogin.jsp" %>
		<jsp:useBean id="modifyPageBean" class="first.ModifyPageBean"
			scope="page"></jsp:useBean>
		<jsp:setProperty property="id" name="modifyPageBean" param="id" />
		<jsp:setProperty property="rsSql" name="modifyPageBean"
			value="select * from news " />
		<%
			ResultSet rs = modifyPageBean.getResult();
			if (rs != null) {
				while (rs.next()) {
		%>
		<div class="news">
			<div class="news_title"><%=rs.getString("title")%></div>
			<div class="content">		
    			<%=rs.getString("newsContent")%>
    		</div>
		</div>
		<%
				}
			}
		%>
		<div class="pic">
		<a href="news.jsp"><img alt="" src="images/ret.png" style="width: 64px; height: 64px;" width="64" height="64">
		</a>
		</div>
   </body>
</html>
