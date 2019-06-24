<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: hkarling
  Date: 2019-06-24
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>여기는 top.jsp문서입니다.</h3>
<%
    out.print(new Date());
%>
</body>
</html>
