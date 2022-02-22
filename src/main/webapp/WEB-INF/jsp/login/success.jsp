<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>正确</title>	
		<script type="text/javascript">
			
		</script>
	</head>
	<body>
		<% for(int i=0;i<=2;i++){ %>
			<span>123</span><br/>
		<% } %>
		
		<%=request.getParameter("isLogin") %>
		
		<%
		Enumeration paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()){
			String paramName = (String) paramNames.nextElement();
			out.println("<tr><td>"+paramName+"</td>\n");
			String paramValue = (String) paramNames.nextElement();
			out.println("<td>"+paramValue+"</td></tr>");
		}
		
		%>
		
		<c:out value="c-out"></c:out>

	</body>
</html>