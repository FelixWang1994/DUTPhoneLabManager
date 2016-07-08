<%
	//获取用户名参数
	String username = request.getParameter("username");
	if (username == null || "".equals(username)) {
		//如果请求参数没有，就从会话里获取
		username = (String) session.getAttribute("username");
	}
	//如果用户名为空则要求重新登录
	if (username == null || "".equals(username)) {
		response.sendRedirect("login.html");
	} else {
		//保存用户名到会话中
		session.setAttribute("username", username);
	}
%>
