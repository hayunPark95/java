<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request.setCharacterEncoding("utf-8");
	String master=request.getParameter("master");
	
	if(master==null){
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
%>    
<hr>
<p>Copyright © Itwill Corp. All rights reserved.</p>
<p>관리자 : <%=master %></p>