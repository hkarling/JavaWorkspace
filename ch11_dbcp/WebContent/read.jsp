<%--
  Created by hkarling
  Date: 2019-07-01
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detail page</title>
</head>
<body>
<h1>~~ 님 어서옵셔</h1>
<table cellspacing="0" align="center">
    <caption><h2> 회원가입 Form</h2></caption>
    <tr>
        <td width="100px">ID</td>
        <td width="400px"><input type="text" name="id"></td>
    </tr>
    <tr>
        <td>PWD</td>
        <td><input type="password" name="pwd"></td>
    </tr>
    <tr>
        <td>NAME</td>
        <td><input type="text" name="name"></td>
    </tr>
    <tr>
        <td>age</td>
        <td><input type="text" name="age"></td>
    </tr>
    <tr>
        <td>Phone</td>
        <td><input type="text" name="phone"></td>
    </tr>
    <tr>
        <td>Addr</td>
        <td><input type="text" name="addr" size="50"></td>
    </tr>
    <tr>
        <td colspan="2" style="text-align: center;background-color: pink">
            <a href="index.jsp">홈으로 이동</a>
        </td>
    </tr>
</table>
</body>
</html>
