<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Request Header Info</title>
</head>
<body>
<h1>Request Header Info</h1>
<%
    // 모든 헤더정보의 name 구하기
    Enumeration<String> e = request.getHeaderNames();
    while (e.hasMoreElements()) {
        String name = e.nextElement();
        String value = request.getHeader(name);
        out.println(name + " = " + value + "<br>");
    }
%>
<hr>
request.getContextPath() = <%=request.getContextPath()%><br>
request.getRealPath() = <%=request.getRealPath("/")%><br>
request.getRequestURL() = <%=request.getRequestURL()%><br>
</body>
</html>
