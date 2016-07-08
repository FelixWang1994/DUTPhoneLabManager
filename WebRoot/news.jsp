<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>DUT Phone Lab-News</title>
		<meta charset="utf-8">
		<link rel="stylesheet" href="css/reset.css" type="text/css"
			media="screen">
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="screen">
		<link rel="stylesheet" href="css/grid.css" type="text/css"
			media="screen">
		<link rel="stylesheet" href="css/news.css" type="text/css">
		<script src="js/jquery-1.6.2.min.js" type="text/javascript"></script>
		<script src="js/cufon-yui.js" type="text/javascript"></script>
		<script src="js/cufon-replace.js" type="text/javascript"></script>
		<script src="js/Open_Sans_400.font.js" type="text/javascript"></script>
		<script src="js/Open_Sans_italic_400.font.js" type="text/javascript"></script>
		<script src="js/FF-cash.js" type="text/javascript"></script>
		<script type="text/javascript">
			function search(){
			  	var keyword = document.getElementById('keyword').value;
				window.open('Search.jsp?name='+keyword);
			}
		</script>
		<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
	<body>
		<!-- header -->
		<header>
		<div class="line-top"></div>
		<div class="row-top">
			<div class="main">
				<div class="container_12">
					<div class="wrapper">
						<div class="grid_9">
							<h1>
								<a class="logo" href="MainPage.html">family center</a>
							</h1>
						</div>
						<div class="grid_3">
							<form id="search-form" method="post"
								enctype="multipart/form-data">
								<fieldset>
									<div class="search-field">
										<input name="search" type="text" value="Search"
											onFocus="if(this.value=='Search'){this.value=''}"
											onBlur="if(this.value==''){this.value='Search'}" />
									</div>
									<a class="search-button" href="#"
										onClick="document.getElementById('search-form').submit()"><span>search</span>
									</a>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row-bot">
			<div class="row-bot-shadow">
				<div class="main">
					<div class="container_12">
						<div class="grid_12">
							<nav>
							<ul class="menu">
								<li class="active">
									<a href="MainPage.html">Home</a><strong></strong>
								</li>
								<li>
									<a href="publication.html">Publication</a><strong></strong>
								</li>
								<li>
									<a href="people.html">People</a><strong></strong>
								</li>
								<li>
									<a href="research.html">Research</a><strong></strong>
								</li>

								<li>
									<a href="resource.html">Resources</a>
								</li>
								<li class="last">
									<a href="news.jsp">News</a><strong></strong>
								</li>
							</ul>
							</nav>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>
		</header>
		<div class="border-bot margin-bot">
			<article class="grid_12">
			<div style="margin-left: 600px; margin-top: 20px;">
				<strong class="title-1">&quot;Welcome to our
					laboratory&quot;</strong>
				<strong class="title-2">Be informed of the news about
					laboratory.</strong>
			</div>
			</article>
			<div class="clear"></div>
		</div>
		<%@include file="checkLogin.jsp"%>
		<div class="info">
			Welcome</div>
		<!-- 在page范围内，使用pageBean -->
		<div align="center"><jsp:useBean id="pageBean"
				class="first.PageBean" scope="page"></jsp:useBean>
			<!-- 设置每页记录数为5 -->
			<jsp:setProperty property="pageSize" name="pageBean" value="20" />
			<!-- 用请求参数page来为当前页设值 -->
			<jsp:setProperty property="currentPage" name="pageBean" param="page" />
			<!-- 设置查询结果记录总数的SQL语句 -->
			<jsp:setProperty property="countSql" name="pageBean"
				value="select count(*) from news" />
			<!-- 设置查询结果集的SQL语句 -->
			<jsp:setProperty property="rsSql" name="pageBean"
				value="select * from news" />
			<input name="keyword" type="text" value="Search" id="keyword"
										onFocus="if(this.value=='Search'){this.value=''}"
										onBlur="if(this.value==''){this.value='Search'}" />
			<input type="button" value="Search" name="searchButton"
				onclick="search()">
			<!-- 使用表格进行数据的表现 -->
		</div>
		<table class="ptable" cellspacing="1" cellpadding="0" border="1"
			width="98%" align="center" >
			<tr>
				<th align="center">
					Editor
				</th>
				<th align="center">
					Title
				</th>
				<th align="center">
					Abstract
				</th>
				<th align="center">
					Date
				</th>
				<th align="center">
					Action
				</th>
			</tr>
			<%
				ResultSet rs = pageBean.getRs();
				//从pageBean那里获取结果集
				//如果结果集存在，则遍历结果集
				if (rs != null) {
					while (rs.next()) {
			%>
			<tr onmouseover="this.bgColor='#eeeeee'"
				onmouseout="this.bgColor='#ffffff'" bgcolor="#ffffff" 
				>
				<td>
					<%=rs.getString("username")%>
					<%--编辑姓名 --%>
				</td>
				<td>
					<%=rs.getString("title")%>
					<%--新闻标题 --%>
				</td>
				<td>
					<%=rs.getString("abstract")%>
					<%--新闻摘要 --%>
				</td>
				<td>
					<%=rs.getDate("date")%>
					<%--新闻编辑时间 --%>
				</td>
				<td>
					<a href="see_news.jsp?id=<%=rs.getInt("news_id")%>">More</a>
				</td>
			</tr>
			<%
				}
				}
			%>
			<tr onmouseover="this.bgColor='#eeeeee'"
				onmouseout="this.bgColor='#ffffff'" bgcolor="#ffffff">
				<!-- 打印翻页操作信息 -->
				<td colspan="5">
					Current Page：<jsp:getProperty property="currentPage" name="pageBean" />
					&nbsp; Totle Page：<jsp:getProperty property="maxPage" name="pageBean" />
					&nbsp;
					<a href="news.jsp?page=1"> <jsp:getProperty
							property="firstPageText" name="pageBean" /> </a>
					<a
						href="news.jsp?page=<jsp:getProperty name="pageBean" property="prePage"/>">
						<jsp:getProperty property="prePageText" name="pageBean" /> </a>
					<a
						href="news.jsp?page=<jsp:getProperty name="pageBean" property="nextPage"/>">
						<jsp:getProperty property="nextPageText" name="pageBean" /> </a>
					<a
						href="news.jsp?page=<jsp:getProperty name="pageBean" property="maxPage"/>">
						<jsp:getProperty property="lastPageText" name="pageBean" /> </a>
				</td>
			</tr>
		</table>
		<br>
	</body>
</html>
