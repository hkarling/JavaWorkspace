<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%
    String dbId = "jang", dbPwd = "1234";
    // 전송된 아이디와 패스워드를 인증하여 성공하면 LoginOk.jsp 로 이동하고 실패하면 LoginForm.html 로 이동한다.
    //      : 이동할 때 response.sendRedirect("LoginOk.jsp");

    String userid = request.getParameter("userId");
    String userpw = request.getParameter("userPwd");
    String name = request.getParameter("userName");

    if (userid.equals(dbId) && userpw.equals(dbPwd)) {
//        request.getRequestDispatcher("LoginOk.jsp").forward(request, response);
//        response.sendRedirect("LoginOk.jsp?userName=" + request.getParameter("userName"));

        response.sendRedirect("LoginOk.jsp?userName=" + URLEncoder.encode(name, "UTF-8"));

    } else {
        out.println("<script>");
        out.println("alert('" + name + "님 정보를 다시확인하시오.');");
        out.println("history.back();");
//        out.println("location.href='LoginForm.html';"); // 새로고침
        out.println("</script>");

//        response.sendRedirect("LoginForm.html");
    }
%>
</body>
</html>
