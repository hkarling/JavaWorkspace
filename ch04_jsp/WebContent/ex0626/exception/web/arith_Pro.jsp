<%--
  Created by hkarling
  Date: 2019-06-26
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>exception Arithmeic Process</title>
</head>
<body>
<%
    int num = Integer.parseInt(request.getParameter("num1"));
    int result =100 / num ;
%>
<h1>나눈결과 : 100을 <%=num%>으로 나눈 결과는 <%=result%></h1>

</body>
</html>
