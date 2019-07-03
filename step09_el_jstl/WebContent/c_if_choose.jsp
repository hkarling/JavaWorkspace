<%--
  Created by hkarling
  Date: 2019-06-28
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1> &lt;c:if>, &lt;c:choose> 연습하기 </h1>

<%--
    만약 http://localhost:8080/ch09_el_jstl_Web_exploded/c_if_choose.jsp?age=20 요청되면
    age가 18보다 크면 성인 아니면 미성년자
--%>

<c:if test="${param.age > 18}" var="result" scope="session">
    ${param.age}살은 <b style="color:red">성인</b>입니다.<br>
</c:if>
결과 : ${result} / <c:out value="${result}"/>

<hr style="color:rosybrown">

<c:choose>
    <c:when test="${param.age > 18}">
        ${param.age}살은 <b style="color:red">성인</b>입니다.<br>
    </c:when>
    <c:otherwise>
        ${param.age}살은 <b style="color:blue">미성년자</b>입니다.<br>
    </c:otherwise>
</c:choose>

<form name="f" action="c_if_choose.jsp" method="get">
    이름: <input type="text" name="name"><br>
    선택: <select name="job">
    <option value="0">---선택---</option>
    <option value="학생">학생</option>
    <option value="프리랜서">프리랜서</option>
    <option value="개발자">개발자</option>
    <option value="연예인">연예인</option>
</select>
    <input type="submit" value="전송">
</form>

<c:if test='${not empty param.name && not empty param.job}'>
    <%-- 1) name과 job 전송되면 ~~ 님의 직업은 ~ 입니다. 출력 --%>
    <h1> ${param.name} 님의 직업은 ${param.job} 입니다. </h1>

    <%-- 2) 직업에 메시지를 출력 --%>
    <c:choose>
        <c:when test='${param.job.equals("학생")}'>
            <h2>학생은 공부해라.</h2>
        </c:when>
        <c:when test='${param.job.equals("프리랜서")}'>
            <h2>프리랜서는 일감이나 따라.</h2>
        </c:when>
        <c:when test='${param.job.equals("개발자")}'>
            <h2>개발자는 코딩해라..</h2>
        </c:when>
        <c:when test='${param.job.equals("연예인")}'>
            <h2>연예인은 놀아라.</h2>
        </c:when>
    </c:choose>

    <%-- 3) name text박스에 이름이 출력되고 job에는 직업이 출력된다. --%>
    <script>
        document.f.name.value = "${param.name}"
        document.f.job.value = "${param.job}"
    </script>
</c:if>
</body>
</html>
