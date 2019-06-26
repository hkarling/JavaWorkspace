<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:red">Hello! JSP 시작</h1>
<%
	// Java코드 영역
	String name = "이름이다";
	int age = 20;
	
	// 콘솔 출력
	System.out.println("이름: " + name);
	
	// 브라우저 출력
	out.println("이름: " + name + "<br>");
	out.println("나이: " + age+ "살");

    List<String> list = new ArrayList<>();

%>

<%!

    public String test (String name) {
        return name + "님 방가";
    }
%>

<br>
<h3>
    이름:<%=name %><br>
    나이:<%=age %><br>
    메시지 호출: <%=test("yoon")%>

</h3>
</body>
</html>