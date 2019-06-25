<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>세션 정보 확인하기</h3>
아이디 : <%=session.getAttribute("id")%><br>
나이 : <%=session.getAttribute("age")%><br>
취미 : <%
    if(session.getAttribute("hobby")!=null) {
        for(String str:(String[])session.getAttribute("hobby"))
            out.println(str+" ");
    }
%><br>
</body>
</html>
