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
    \${map} = ${map} <br>
    <br><hr><br>
    map의 모든 key와 value를 출력해보자 <br>
    <c:forEach items="${map}" var="m">
        ${m.key} = ${m.value}<br>
    </c:forEach><br>
    <hr><br>
    작성자: ${map['name']}<br>
    제목 : ${map['subject']}<br>
    첨부파일이름(FileSystemName): ${map['fileName']}<br>
    첨부파일이름(OriginalFileName): ${map['originalName']}<br>
    첨부파일용량 : <fmt:formatNumber value="${map['fileSize']}" />byte<br>
</h3>

<hr>
<h1> 다운로드하기</h1>
<ul>
    <c:forEach items="${map['fileList']}" var="file">
        <li><a href="downLoad?fName=${file}">${file}</a></li>
    </c:forEach>
</ul>
</body>
</html>
