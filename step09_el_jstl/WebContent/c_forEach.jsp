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
    <title>c_forEach</title>
    <style>
        table {
            width: 800px;
            border: 5px double skyblue;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid gray;
        }

        td {
            text-align: center;
        }
    </style>
</head>
<body>
<h1> &lt;foreach> 테스트</h1>
<%--
<c:forEach begin="1" end="10" var="i">
    ${i},
</c:forEach>
--%>

<jsp:useBean id="bean" class="ex0628.dto.ForEachBean"/>
<%--${bean.menus} / ${bean.fruitList} / ${bean.memberList}--%>

<%-- 메뉴는 셀렉트박스로 출력 --%>
<select name="fruit">
    <option value="0">--메뉴선택--</option>
    <c:forEach items="${bean.menus}" var="menu">
        <option value="$menu">${menu}</option>
    </c:forEach>
</select><br><br>

<%-- fruit는 checkbox 출력 --%>
<fieldset>
    <legend>과일선택</legend>
    <c:forEach items="${bean.fruitList}" var="fruit">
        <input type="checkbox" name="fruit" value="${fruit}"> ${fruit}
    </c:forEach>
</fieldset><br><br>
<%-- member는 테이블 출력 --%>
<table>
    <caption>회원정보리스트</caption>
    <tr>
        <th>index</th>
        <th>순서</th>
        <th>아이디</th>
        <th>이름</th>
        <th>나이</th>
        <th>주소</th>
    </tr>
    <c:forEach items="${bean.memberList}" var="member" varStatus="state">
        <tr>
            <td>${state.index}</td>
            <td>${state.count}</td>
            <td>${member.id}</td>
            <td>${member.name}</td>
            <td>${member.age}</td>
            <td>${member.addr}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
