<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%--
    include 지시어
        : include되는 문서의 소스가 메인에 포함되어 서블릿문서 한개가 생성된다.
          그래서 변수나 메소드를 공유할 수 있는 반면 중복이름을 사용할 수 없다.
--%>

<%
    String addr= "성남시 분당구 운중동";
%>
<%@include file="top.jsp" %>
<hr style="color:red">
<h1> 여기는 index.jsp영역임.</h1>
<hr style="color:red">
<%@include file="footer.jsp" %>
</body>
</html>