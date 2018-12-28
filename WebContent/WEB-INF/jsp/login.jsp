<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>登录页面</h1>
	<form action="loginsuccess.do" method="post">
		<input type="text" name="username" value="" id="username">
		<input type="password" name="password" value="" id="password">
		<input type="submit" value="登录">
	</form>
	<a href="register.do">注册</a>
</center>

</body>
</html>