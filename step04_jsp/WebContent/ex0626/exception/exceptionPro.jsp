<%--
  Created by hkarling
  Date: 2019-06-26
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Exception Process</title>
</head>
<body>
<%
    int num1 = Integer.parseInt(request.getParameter("num1"));
    int num2 = Integer.parseInt(request.getParameter("num2"));
%>
<h1>두 수의 합: <%=num1%> + <%=num2%> = <%=num1 + num2%></h1>
</body>
</html>
