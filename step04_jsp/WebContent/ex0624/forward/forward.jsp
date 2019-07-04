<%--
  Created by IntelliJ IDEA.
  User: hkarling
  Date: 2019-06-24
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>forward</title>
</head>
<body>
<%
    // request 한글 인코딩 처리
    request.setCharacterEncoding("UTF-8");

    // 반복문
    int i = 0;
    int sum = 0;

    for(i=1; i <=10; i++) {
        out.println(i+"<br>");
        sum += i; // sum = sum+ i;
    }
%>

<h1> 총합: <%=sum%></h1>

<!-- 보통 forward가 있는 페이지는 뷰를 만들지 않는다. -->
<jsp:forward page="forwardResult.jsp" >
    <jsp:param name="sum" value="<%=sum%>"/>
    <jsp:param name="homework" value="오늘과제는?"/>
</jsp:forward>
</body>
</html>
