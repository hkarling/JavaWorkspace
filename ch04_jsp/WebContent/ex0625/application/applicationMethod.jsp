<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Application Method</title>
</head>
<body>

<h1>Application Method : ServletContext</h1>
<h3>
application.getContextPath() = <%=application.getContextPath()%><br>
application.getRealPath("/") = <%=application.getRealPath("/")%><br>
application.getMajorVersion() = <%=application.getMajorVersion()%><br>
application.getMinorVersion() = <%=application.getMinorVersion()%><br>
application.getServerInfo() = <%=application.getServerInfo()%><br>
</h3>

<%
    // application 영역에 정보를 저장,
    application.setAttribute("addr", "경기도 성남시 분당구");
    application.setAttribute("message", "오늘도 끝날 시간이구나..");
%>

<h3>application 정보 확인하기</h3>
주소: <%=application.getAttribute("addr")%><br>
메시지: <%=application.getAttribute("message")%><br><br>

<a href="../session/sessionGet.jsp">확인하러가기</a>
</body>
</html>
