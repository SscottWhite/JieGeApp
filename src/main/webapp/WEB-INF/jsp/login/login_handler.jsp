<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%
    String name = request.getParameter("name");
    String pwd = request.getParameter("password");
    String flag = request.getParameter("isLogin");
	System.out.println(name+";"+pwd+";"+flag);
	
    if (!"admin".equals(name) || !"123".equals(pwd)) {
        response.sendRedirect("/error1");
    } else {
        if ("y".equals(flag)) {
            //创建两个Cookie对象
            Cookie nameCookie = new Cookie("username", name);
            //设置Cookie的有效期为3天
            nameCookie.setMaxAge(60 * 60 * 24 * 3);
            Cookie pwdCookie = new Cookie("password", pwd);
            pwdCookie.setMaxAge(60 * 60 * 24 * 3);
            response.addCookie(nameCookie);
            response.addCookie(pwdCookie);
        }
        response.sendRedirect("/success");
    }
%>
</head>
<body>

</body>
</html>