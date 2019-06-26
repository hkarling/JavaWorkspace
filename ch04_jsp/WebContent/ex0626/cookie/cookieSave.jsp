<%--
  Created by hkarling
  Date: 2019-06-26
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Save cookie</title>
</head>
<body>
<h1>Cookie - 사용자 PC 쪽에 클라이언트 정보를 저장하는 것</h1>
<h4>sessionId는 cookie 에 기본적으로 저장된다.</h4>
<%
    // 저장할 쿠키를 생성한다.
    Cookie co1 = new Cookie("id", "jang");
    Cookie co2 = new Cookie("age", "20");

    // 옵션설정
    co1.setMaxAge(60*60*24); // 1일
    co2.setMaxAge(60*60*24*365); // 1년

    // 현재 위치에서 저장된 쿠키를 다른 폴더에서 사용할 수 있도록 설정
    co1.setPath("/");
    co2.setPath("/");

    // 클라이언트에 저장
    response.addCookie(co1);
    response.addCookie(co2);
%>
<h1><%=session.getId()%></h1>
<a href="cookieGet.jsp">쿠키확인하러가자</a>
</body>
</html>
