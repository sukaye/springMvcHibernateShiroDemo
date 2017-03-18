<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<br><br><br><br><br>
<div align='center'>
<form action="${pageContext.request.contextPath}/login" method="POST">
	user name : <input type='text' name='userName'><br><br>
	password : <input type='text' name='password'><br><br>
	<font color="red">${loginError}</font>
	<br><br>
	<input type='submit' value='Login'>
</form>
</div>
</body>
</html>
