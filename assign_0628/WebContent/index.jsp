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
    <title>댓글게시판</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
</head>
<body>
<div class="container mt-5">
    <nav>
        <ul class="nav nav-tabs justify-content-end">
            <li class="nav-item"><a class="nav-link active" href="#">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="#">강좌</a></li>
            <li class="nav-item"><a class="nav-link" href="#">게시판</a></li>
            <li class="nav-item"><a class="nav-link" href="#">사이트맵</a></li>
        </ul>
    </nav>
    <div class="row">
        <aside class="col-md-3">
            <jsp:include page="aside.jsp"/>
        </aside>
        <main class="col-md-9">
            <jsp:include page="main.jsp"/>
        </main>
    </div>
    <footer class="mt-5">
        <h6 class="h6 text-info text-right">Created by Chamsol Yoon 2019</h6>
    </footer>
</div>
</body>
</html>
