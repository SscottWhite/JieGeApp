<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login Here</title>
	</head>
	<body>
		<div>
			<form action="/getUser" method="post">
				<span>姓名：</span><input type="text"  name="name">
				<span>密码：</span><input type="password" name="password" >  
				<input type="submit" >
    			<input type="reset">
			</form>
		</div>
	</body>
</html>