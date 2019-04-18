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
		function submitPhoto(){
			var form = $("#fileForm");
			var options={
				url:"${basePath}submitPhoto2.do",
				type:"post",
				dataType:"text",
				success:function(result){
					var imgPath=result;
					console.log(imgPath);
					$("#photo_preview").attr("src",imgPath);
				},
				error:function(xhr){
					console.log(xhr.textStatus);
					console.log("error");
				}
			}
			form.ajaxSubmit(options);
		}
	</script>
</head>
<body>
	<form id="fileForm" enctype="multipart/form-data">
		浏览：<input type="file" name="file" onchange="submitPhoto()" accept="image/*" />
	</form>
	<img id="photo_preview" alt="自定义相片" src="">
</body>
</html>