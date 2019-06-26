<%@ page import="java.util.Date" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.BufferedWriter" %>
<%@ page import="java.io.FileWriter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>File Writer</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");

    // 넘어오는 값 3개를 받는다.
    String name = request.getParameter("name");
    String title = request.getParameter("subject");
    String content = request.getParameter("content");

    long time = System.currentTimeMillis();

    // 저장위치를 선정한다.
    String path = request.getRealPath("/")+ "save/";

    File file = new File(path, name + "_" + time + ".txt");
    if(!file.exists()) {
        file.getParentFile().mkdir();
    }

    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
    bw.write("이름 : " + name + "\n");
    bw.write("제목 : " + title + "\n");
    bw.write("내용 : " + content);
    bw.flush();
    bw.close();

    application.setAttribute("path", path);
    response.sendRedirect("FileReader.jsp");
%>
</body>
</html>
