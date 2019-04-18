<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getContextPath()+"/"; 
	request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form enctype="application/x-www-form-urlencoded" method="post" action="${basePath}addOne.do">
	<h2>注册信息：</h2>
	学生姓名：<input name="name" type="text" /><br>
	年龄：<input name="age" type="text" /><br>
	性别：<input name="gender" value="0" type="checkbox" />男
	<input name="gender" value="1" type="checkbox" />女<br>
	<input type="submit" value="添加学生"/>
</form>
</body>
</html>