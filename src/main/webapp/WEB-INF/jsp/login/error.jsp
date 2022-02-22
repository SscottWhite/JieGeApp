<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%
	    String path = request.getContextPath();
	    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	    String url = basePath+"login"; //设置跳转的地址
	    %>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv=refresh content=5;url=<%=url %>>
		<title>error错误</title>	      
		
	<body>
		error <br/>
		<b style=color:blue><span id="jump">5秒钟后页面将自动返回登录页面...</span></b>
		
		<script>
			function countDown(secs){
		        jump.innerText=secs;
		        document.getElementById("jump").innerHTML =  secs+"秒钟后页面将自动返回登录页面...";
		        if(--secs>0)		        	
		            setTimeout("countDown("+secs+" )",1000);
		    }
		    countDown(5);
		</script>
	</body>
</html>