<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%--
  Created by hkarling
  Date: 2019-06-26
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cookie Last Date</title>
</head>
<body style="text-align:center">
<%
    Cookie lastVisit = null; // lastVisit, time
    long current = System.currentTimeMillis(); // 현재시간을 받아옴.

    // 시간 표시를 위한 date format 설정
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy. MM. dd. a hh:mm:ss", Locale.KOREAN);

    // 쿠키를 받아온다.
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("lastVisit")) {
                lastVisit = cookie;
                break;
            }
        }
    }

    // 쿠키가 있고 없고에 따라 출려어어억
    if (lastVisit == null) {
        out.println("<h1>당신은 처음 방문하였습니다.</h1>");
    } else {
        long time = Long.parseLong(lastVisit.getValue());
        out.println("<h1>당신의 마지막 접속일은 : " + simpleDateFormat.format(new Date(time)) + "</h1>");
    }

    // 쿠키저자아아아앙
    lastVisit = new Cookie("lastVisit", String.valueOf(current));
    lastVisit.setMaxAge(60 * 60 * 24 * 365);
    lastVisit.setPath("/");
    response.addCookie(lastVisit);

    // 밑에 정보 처리이이이
    out.println("<br><h3>");
    out.println("현재접속시간 : " + simpleDateFormat.format(new Date(current)) + "<br>");
    out.println("다시저장된 시간 : " + current);
    out.println("</h3>");
%>
</body>
</html>
