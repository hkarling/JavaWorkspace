<%--
  Created by hkarling
  Date: 2019-07-01
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Result</title>
</head>
<body>
<h1>Upload Result</h1>

<h3>
    작성자: ${name}<br>
    제목 : ${subject}<br>
    첨부파일이름(FileSystemName): ${fileName}<br>
    첨부파일이름(OriginalFileName): ${originalName}<br>
    첨부파일용량 : <fmt:formatNumber value="${fileSize}" />byte<br>
</h3>

<hr>
<h1> 다운로드하기</h1>
<ul>
    <c:forEach items="${fileList}" var="file">
        <li><a href="">${file}</a></li>
    </c:forEach>
</ul>
</body>
</html>
