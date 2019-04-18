<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		border: 1px solid;
	}
</style>
</head>
<body>
<h1>studentList</h1>
<table>
	<tr>
		<th>学号</th>
		<th>姓名</th>
		<th>性别</th>
		<th>年龄</th>
	</tr>
<c:forEach items="${requestScope.stulist}" var="stu">
	<tr>
		<td>${stu.sid }</td>
		<td>${stu.name }</td>
		<td>
			<c:if test="${stu.gender == false}">
				男
			</c:if>
			<c:if test="${stu.gender == true}">
				女
			</c:if>
		</td>
		<td>${stu.age}</td>
	</tr>	
</c:forEach>
</table>
</body>
</html>