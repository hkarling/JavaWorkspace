<%--
  Created by hkarling
  Date: 2019-06-26
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>오류가 발생하였습니다.</h1>
<%
    // 크롬은 문제가 없으나 IE의 경우 상태코드가 500이면 이하 내용에 관계없이 화면이 출력이 되지 않는다 따라서 상태코드를 변경해준다.
    response.setStatus(200);
%>
<h3>
    exception = <%=exception%><br>
    exception.getMessage() = <%=exception.getMessage()%><br>
    exception.getClass() = <%=exception.getClass()%><br>
</h3>
<a href="exceptionForm.jsp">홈으로 이동</a>
</body>
</html>
