<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.concurrent.atomic.AtomicInteger" %>
<%--
  Created by hkarling
  Date: 2019-06-27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Application Listener Test</title>
</head>
<body>
<h1>ServletContextListener - 저장된 map 가져오기</h1>
<fieldset>
    <legend>나라선택</legend>
    <%
        Map<String, String> map = (Map<String, String>)(application.getAttribute("map"));

        for(String key : map.keySet()) {
            %>
            <input type="radio" name="nation" value="<%=map.get(key)%>"> <%=key%>
        <%
        }
    %>
</fieldset>
<h3>현재 접속자수 : <%=((AtomicInteger)application.getAttribute("counter")).get()%></h3>
</body>
</html>
