<%@ page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%
    // post 방식 한글 인코딩 설정
    request.setCharacterEncoding("UTF-8");

    // form 으로 전송된 모든 정보 가져오기.
    Enumeration<String> e = request.getParameterNames();

    while(e.hasMoreElements()){
        String name = e.nextElement();
        String value = request.getParameter(name);
        out.println(name + "=" + value + "<br>");
    }

%>
</body>
</html>
