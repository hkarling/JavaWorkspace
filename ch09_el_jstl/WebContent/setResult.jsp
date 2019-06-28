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
    <title>setResult.jsp</title>
</head>
<body>

<h3>c:set 으로 저장된 정보 확인하기</h3>
이름: ${name} / ${sessionScope.name} / <c:out value="${name}"/> <br>
아이디: ${id} / ${applicationScope.id} / <c:out value="${id}"/> <br>
주소: ${addr} / ${pageScope.addr} / <c:out value="${addr}"/> <br>

<c:remove var="id" />

<h3>c:set 으로 저장된 정보 확인하기</h3>
이름: ${name} / ${sessionScope.name} / <c:out value="${name}"/> <br>
아이디: ${id} / ${applicationScope.id} / <c:out value="${id}"/> <br>
주소: ${addr} / ${pageScope.addr} / <c:out value="${addr}"/> <br>

</body>
</html>