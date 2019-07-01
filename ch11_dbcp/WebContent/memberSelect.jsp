<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <style>
        table {
            width: 100%;
            border: 5px double red
        }

        th, td {
            padding: 5px;
            border: 1px solid pink;
            text-align: center
        }

        a {
            text-decoration: none
        }
    </style>
    <script>
        $(function() {
            // alert('jQuery Start');

            $('input[value=삭제]').click(function() {
                // 현재 버튼을 기준으로 ID찾기
                // var id = ?;
                //location.href="delete?id=id";
            });
        });
    </script>
</head>

<body>
<center>
    <h1>[ 회원 정보 LIST ]</h1>
    <table cellspacing="0">
        <tr>
            <th colspan="9" style="text-align:right">
                <a href="memberForm.html">[ 회원가입 ]</a>&nbsp;&nbsp;&nbsp;
                <a href="#">[ 새로고침 ]</a>&nbsp;&nbsp;&nbsp;
            </th>
        </tr>
        <tr bgColor="pink">
            <th>번호</th>
            <th>아이디</th>
            <th>비밀번호</th>
            <th>이름</th>
            <th>나이</th>
            <th>주소</th>
            <th>연락처</th>
            <th>가입일</th>
            <th>삭제</th>
        </tr>
        <c:forEach items="${list}" var="member" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${member.id}</td>
                <td>${member.pwd}</td>
                <td>${member.name}</td>
                <td>${member.age}</td>
                <td>${member.addr}</td>
                <td>${member.phone}</td>
                <td>${member.joinDate}</td>
                <td><input type="button" value="삭제"></td>
            </tr>
        </c:forEach>
    </table>
    <p>

    <form name="search" action="" method="post">
        <select name="keyField">
            <option value="0">--선택--</option>
            <option value="id">아이디</option>
            <option value="name">이름</option>
            <option value="addr">주소</option>
        </select>
        <input type="text" name="keyWord"/>
        <input type="button" value="검색"/>
    </form>
</center>
</body>
</html>




