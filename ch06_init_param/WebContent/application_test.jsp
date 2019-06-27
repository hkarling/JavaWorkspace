<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application Test</title>
</head>
<body>
<h1> context-param에 저장된 정보</h1>
<h3>
메시지 : <%=application.getInitParameter("message") %><br>
주소 : <%=application.getInitParameter("addr") %>
</h3>
</body>
</html>