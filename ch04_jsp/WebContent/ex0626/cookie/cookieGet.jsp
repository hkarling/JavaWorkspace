<%--
  Created by hkarling
  Date: 2019-06-26
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Get Cookie</title>
</head>
<body>
<h1>저장된 Cookie 정보 확인하기</h1>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies == null)
        out.println("<h1></h1>");
    else {
        out.println("Cookie 갯수 : "+ cookies.length+ "<br>");
        for (Cookie cookie : cookies) {
            out.println(cookie.getName() + " : "  + cookie.getValue() + "<br>");

        }
    }
%>
</body>
</html>
