<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${param.name}님 반가워요.<br>
메시지 = <%= request.getParameter("message") %><br>
접속시간 : <%= new Date().toLocaleString() %>
</h3>
</body>
</html>