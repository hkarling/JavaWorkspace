<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
%>

<h1>정보확인하기</h1>
<h3>
    이름 : <%=request.getParameter("name")%><br>
    나이 : <%=request.getParameter("age")%><br>
    취미 :

<%
    String[] hobbies = request.getParameterValues("hobby");
    for(String ho:hobbies) {
        out.print(ho + " ");
    }
%><br>

    접속자 : <%=request.getRemoteAddr()%>
</h3>
</body>
</html>
