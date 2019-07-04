<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Session Method</title>
</head>
<body>
<h1>Session 관련 메소드 - HttpSession</h1>
<h3>
    <%
        // 세션 유효기간 설정
//        session.setMaxInactiveInterval(30); // 30초
    %>
    session.getId() = <%=session.getId()%><br>
    session.getMaxInactiveInterval() = <%=session.getMaxInactiveInterval()%><br>
    session.getLastAccessedTime() = <%=session.getLastAccessedTime()%><br>
    session.getCreationTime() = <%=session.getCreationTime()%><br>
    session.isNew() = <%=session.isNew()%><br>

    <%
        session.setAttribute("id", "jang");
        session.setAttribute("age", 50);
        session.setAttribute("hobby", new String[]{"등산", "수영", "낚시"});
    %>

    <h3>세션 정보 확인하기</h3>
    아이디 : <%=session.getAttribute("id")%><br>
    나이 : <%=session.getAttribute("age")%><br>
    취미 : <%for(String str:(String[])session.getAttribute("hobby")) out.println(str+" ");%><br>
</h3>

<a href="sessionGet.jsp">확인하러가자</a>
</body>
</html>
