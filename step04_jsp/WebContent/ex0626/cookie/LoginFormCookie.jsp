<%--
  Created by hkarling
  Date: 2019-06-26
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>회원인증 Page - Cookie</title>
</head>
<body>
<h2>회원인증 Page - Cookie</h2>
<%
    String saveId = "";
    // 쿠키쪽에 저장된 id가 있는지 체크한다.
    Cookie[] cookies = request.getCookies();
    if(cookies != null){
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals("saveId")){
                saveId = cookie.getValue();
                break;
            }
        }
    }
%>
<form method="get" action="LoginPro.jsp">
    ID :   <input type="text" name="userId" value="<%=saveId%>"><br>
    PWD :  <input type="password" name="userPwd"><br>
    NAME : <input type="text" name="userName"><br>
    <input type="submit" value="로그인">
</form>
</body>
</html>