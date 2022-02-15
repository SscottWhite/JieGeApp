<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login Here</title>
		<%
			String username="";
			String password="";
			
			Cookie[] cookies = request.getCookies();
			for(int i=0; i<cookies.length; i++){
				if("username".equals(cookies[i].getName())){
					username = cookies[i].getValue();
				} else if ("password".equals(cookies[i].getName())){
					password = cookies[i].getValue();
				}
			}
		%>
	</head>
	<body>
		<div>
			<form action="/login3" method="get">
				<span>姓名：</span><input type="text" name="name" value="<%=username%>"><br/>
				<span>密码：</span><input type="password" name="password" value="<%=password%>"> <br/>
				<input type="checkbox" value="y" name="isLogin"> 自动登录 <br/>
				<input type="submit" >
    			<input type="reset">
			</form>
		</div>
	</body>
</html>