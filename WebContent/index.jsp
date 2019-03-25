<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple ReST example</title>
</head>
<body>
<h1>App running</h1>

<p>API endpoint</p>
<a href="<%=request.getContextPath()%>/rest/UserService/users" target="_blank">Users [GET]</a>
</body>
</html>