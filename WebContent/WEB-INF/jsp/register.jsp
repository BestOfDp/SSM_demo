<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册</title>
</head>
<body>
<form action="registersuccess.do" method="post">
	用户名：<input type="text" name="username" value="" id="username">
	密码：<input type="password" name="password" value="" id="password">
	<input type="radio" name="usex" value="男" checked="checked">男
	<input type="radio" name="usex" value="女" >女
	<br/>
	<input type="checkbox" name="hobby" value="音乐">音乐
	<input type="checkbox" name="hobby" value="登山">登山
	<input type="checkbox" name="hobby" value="旅游">旅游
	<input type="checkbox" name="hobby" value="写作">写作
	
	<input type="submit" value="注册"><input type="reset" value="重置">
</form>
</body>
</html>