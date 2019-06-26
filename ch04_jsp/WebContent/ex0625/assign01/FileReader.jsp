<%@ page import="java.io.File" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%
    String path = (String)application.getAttribute("path");
%>
<h3><%=path%></h3>
<h3>File 목록</h3>
<ul>
<%
    File[] filelist = new File(path).listFiles();
    for(File file: filelist) {
        out.println("<li>" + file.getName()+"</li>");
    }
%>
</ul><br>
<a href="board_Form.html">새 글 등록</a>
</body>
</html>
