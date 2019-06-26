<%--
  Created by hkarling
  Date: 2019-06-26
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Process</title>
</head>
<body>
<%
    // 아이디와 패스워드를 비교해서 일치하면 로그인하고 로그인이 성공하면 Cookie에 현재 id를 저장한다.
    // 틀리면 폼으로 이동.

    Cookie co = new Cookie("savedId", request.getParameter("userId"));
    co.setMaxAge(60*60*24*365);
    co.setPath("/");

    response.addCookie(co);
%>
<script>
    alert('저장되었음');
    location.href='LoginFormCookie.jsp';
</script>
</body>
</html>
