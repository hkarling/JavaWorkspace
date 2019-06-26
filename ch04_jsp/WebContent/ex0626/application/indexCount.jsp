<%--
  Created by hkarling
  Date: 2019-06-26
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Index Count</title>
</head>
<body>
<%
    // 저장된 방문자 수를 읽어온다. - application.
    /*if(application.getAttribute("visitors") == null) {
        application.setAttribute("visitors", 0);
    }
    int visitors = (int)application.getAttribute("visitors");

    if(session.isNew()){
        visitors++;
        application.setAttribute("visitors", visitors);
    }*/
    Object obj = application.getAttribute("visitors");

    if(obj == null)
        obj = 0;

    int visitors = (int)obj;

    if(session.isNew()) {
        visitors++;
        application.setAttribute("visitors", visitors);
    }
%>
<h1>총 방문자수 : <%=visitors%> 명</h1>
</body>
</html>
