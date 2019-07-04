<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>LoginPro</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");

    String dbId = "jang", dbPwd = "1234";
    String userid = request.getParameter("userId");
    String userpw = request.getParameter("userPwd");
    String name = request.getParameter("userName");

    if (dbId.equals(userid) && dbPwd.equals(userpw)) {
        session.setAttribute("userId", userid);
        session.setAttribute("userName", name);
        session.setAttribute("createTime", new Date().toLocaleString());

        response.sendRedirect("LoginOk.jsp");
    } else {
        out.println("<script>");
        out.println("alert('" + name + "님 정보를 다시확인하시오.');");
        out.println("history.back();");
        out.println("</script>");
    }
%>
</body>
</html>
