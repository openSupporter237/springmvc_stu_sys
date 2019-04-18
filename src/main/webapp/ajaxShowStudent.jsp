<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getContextPath()+"/"; 
	request.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
	<script type="text/javascript" src="js/jquery.form.js"></script>
	<script type="text/javascript">
		function searchStudent(){
			var name=$("#name_input").val();
			$.ajax({
				url:"searchStudent.do",
				type:"post",
				dataType:"JSON",
				data:{"name":name},
				success:function(data){
					var table_html="<tr><th>学号</th><th>姓名</th><th>性别</th><th>年龄</th></tr>";
					var tr_html="";
					for (var i = 0; i < data.length; i++) {
						var stu=data[i];
						tr_html="<tr>";
						tr_html+="<td>"+stu.sid+"</td>";
						tr_html+="<td>"+stu.name+"</td>";
						tr_html+="<td>";
						if (stu.gender==false) {
							tr_html+="男";
						}else{
							tr_html+="女";
						}
						tr_html+="</td>";
						tr_html+="<td>"+stu.age+"</td>";
						tr_html+="</tr>";
						table_html+=tr_html;
					}
					$("table").html(table_html);
					console.log(table_html);
				}
			});
		}
	</script>
	<style type="text/css">
		table{ border: 1px solid;}
	</style>
</head>
<body>
	输入用户名：<input type="text" name="name" id="name_input">
	<a onclick="searchStudent()">检索</a>
	<table></table>
</body>
</html>