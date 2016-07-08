<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>DUT Phone Lab-Publication</title>
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
								<a class="logo" href="index.html">family center</a>
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
										onClick=document.getElementById('search-form').submit();><span>search</span>
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
									<a href="edit_news.jsp">News</a><strong></strong>
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
			Welcome，<%=session.getAttribute("username")%></div>
		<form action="AddNews.jsp" name="editorForm" method="post">
			<div id="textarea";style="float:left">
			<input type="text"  id="titleText" name="titleText" value="Please input the title.." class="title"
				   onFocus="if(this.value=='Please input the title..'){this.value=''}"
				   onBlur="if(this.value==''){this.value='Please input the title..'}"
			>
			<textarea rows="5" cols="110" id="abstractText" name="abstractText" onfocus="if(this.value=='Please input the abstract..') {this.value='';}" onblur="if(this.value=='') {this.value='Please input the abstract..';}">Please input the abstract..</textarea>
			<textarea rows="10" cols="80" id="editor" name="editor" onfocus="if(this.value=='Please input the news..') {this.value='';}" onblur="if(this.value=='') {this.value='Please input the news..';}">Please input the news..
			<s:if test="srcPath != null">
    			<img src="<s:property value="srcPath"/>" />
    		</s:if>
			</textarea>		
    		</div>
    		<div style="float:left" id="anniu">
    		<input type="submit" value="submit" name="submit" class="anniu">
    		<input type="reset" value="clear" name="reset" class="anniu" >
			</div>
			<ckeditor:replace replace="editor"	
				basePath="/DUTPhoneLabManager/ckeditor">
			</ckeditor:replace>&nbsp;&nbsp;
		</form>
		<form action="Upload" method="post" enctype="multipart/form-data">
			<div style="float:left" id="upload">
			<input type="button" value="choose files" size="30" onclick="f.click()" />
			<input type="file" name="upload" id="f"  style=" filter:alpha(opacity=0); opacity:0; "/>
			<input type="submit" value="upload" class="up" />
			</div>
		</form>
		<div class="info">
			<s:property value="info" />
		</div>
		<div class="pic2">
		<a href="news.jsp"><img alt="" src="images/ret.png" style="width: 64px; height: 64px;">
		</a>
		</div>
	</body>
</html>
