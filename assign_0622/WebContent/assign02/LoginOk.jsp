<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    // 브라우저 캐시 사용안함.
    response.setHeader("cache-control","no-store");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>LoginOk</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(function() {
            $("input[type=button]").click(function() {
                if(confirm('나갈거임?')) {
                    location.href="../LogoutPro";
                } else {
                    alert('오키');
                }
            });
        });
    </script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <%
            if (session.getAttribute("userName") != null) {
        %>
                <h3 class='display-4'><%=session.getAttribute("userName")%> 님 환영합니다.</h3>
                <br><br>
                <img src='https://cdn.arstechnica.net/wp-content/uploads/2016/02/5718897981_10faa45ac3_b-640x624.jpg'><br>
                <input type="button" value="로그아웃">
        <%
            } else {
        %>
                <script>
                    alert('도라가 -_-');
                    location.href='LoginForm.html';
                </script>
        <%
            }
        %>
    </div>
</div>
</body>
</html>
