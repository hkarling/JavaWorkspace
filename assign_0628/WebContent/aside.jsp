<%--
  Created by hkarling
  Date: 2019-06-30
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

</head>
<body class="container">
<div class="mt-5">
    <c:choose>
        <%-- Session에 아이디가 존재하면 로그인정보를 띄움--%>
        <c:when test="${sessionScope.userId != null}">
            <h4 class="h4">${userId} 님 <small>로그인 중..</small></h4>
            <h6 class="h6">접속시각:</h6>
            <h6 class="h6">${loginTime}</h6>
            <form action="logout" method="post" class="mt-3">
                <input type="submit" value="로그아웃"class="btn btn-light">
            </form>
            <h6 class="h6 mt-3">현재 접속자 수 : ${currentVisit}</h6>
            <h6 class="h6 mt-1">총 접속자 수 : ${totalVisit}</h6>
        </c:when>
        <%-- 존재하지 않으면 로그인폼을 띄움--%>
        <c:otherwise>
            <form action="login" method="post">
                <div class="input-group mb-3 input-group-sm">
                    <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-user"></i></span>
                    </div>
                    <input type="text" name="txtId" class="form-control">
                </div>
                <div class="input-group mb-3 input-group-sm">
                    <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-lock"></i></span>
                    </div>
                    <input type="password" name="txtPwd" class="form-control">
                </div>
                <input type="submit" name="btnSubmit" value="로그인" class="btn btn-light">
            </form>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
