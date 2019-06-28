<%--
  Created by hkarling
  Date: 2019-06-28
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1> &lt;c:set>, &lt;c:out> 연습하기 </h1>

<c:out value="졸리다"/><br>
<c:out value="<h3>졸리다</h3>" escapeXml="true"/><br>
<c:out value="<h3>졸리다</h3>" escapeXml="false"/><br>

<%-- scope="page|request|session|application" --%>
<c:set var="name" value="이름" scope="session"/>
<!-- session.setAttribute("name","이름")과 같다. -->
<c:set var="id" value="yoon" scope="application"/>
<c:set var="addr" value="판교"/>

<h3>c:set 으로 저장된 정보 확인하기</h3>
이름: ${name} / ${sessionScope.name} / <c:out value="${name}"/> <br>
아이디: ${id} / ${applicationScope.id} / <c:out value="${id}"/> <br>
주소: ${addr} / ${pageScope.addr} / <c:out value="${addr}"/> <br>

<hr>

<%
    String menu = "짜장면";
    // request.setAttribute("menu", menu);
%>

메뉴 : <%=menu%> / ${menu} / <c:out value="${menu}" /> / <c:out value="<%=menu%>" /> <br>

<hr>

<a href="setResult.jsp">확인하러갑세다.</a>

</body>
</html>
