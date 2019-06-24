<%--
  Created by IntelliJ IDEA.
  User: hkarling
  Date: 2019-06-24
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%--
    actionTag include
        : include 되어지는 각각의 문서
--%>

<jsp:include page="top.jsp" />

<hr style="color:red">

<h1> 여기는 index.jsp영역임.</h1>

<hr style="color:red">
<%
    request.setCharacterEncoding("UTF-8");

    String addr = "경기도 성남시 분당구 ...";
%>
<jsp:include page="footer.jsp">
    <jsp:param name="addr" value="<%=addr%>" />
    <jsp:param name="id" value="yoon"/>
</jsp:include>

</body>
</html>
