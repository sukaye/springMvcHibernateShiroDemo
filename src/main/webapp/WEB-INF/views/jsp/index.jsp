<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<script src="${pageContext.request.contextPath }/scripts/jquery-3.1.1.min.js"></script>
</head>
<script type="text/javascript">
var path="${pageContext.request.contextPath}";
function logout() {
	//$.post(path + "/logout");
	window.location.href = path + "/logout";
}
</script>
<body>
<h1>Index Page</h1><br /><br /><br />
<a href="${pageContext.request.contextPath}/admin/manage">scott 用户登录后,可以访问此链接，因为 soctt 用户拥有admin 角色</a>
<br><br><br>
<p><input type='button' value='logout' onclick="logout();"></p>
</body>
</html>
