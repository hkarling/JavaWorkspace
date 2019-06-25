<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%
	/*
		parameter로 전송되어지는 한글이 get방식인 경우 한글인코딩
			: tomcat 7.x version까지는 server.xml문서인 설정문서에 URIEncoding="인코딩방식"을 추가하였으나
			tomcat 8.x version get방식 한글처리 해결되었음.

		parameter로 전송되어지는 한글이 post방식인 경우 한글인코딩
			: request.setCharacterEncoding(인코딩방식) 설정한다.
			: Filter를 이용하여 프로젝트 전체에 처리하는 방법도 이다.

	 */
	request.setCharacterEncoding("UTF-8"); // post방식
	// 넘어오는 값.
	String bloodType = request.getParameter("blood");
%>
<!-- 
	forward 방식은 request, response를 유지하는 형태로 보여지는 page에서 request정보를 사용할 수 있다.
	-- url 주소창의 주소가 현재 주소를 유지한다.
-->
<%-- <jsp:forward page='<%=request.getParameter("blood") + ".jsp"%>' /> --%>
<%-- <jsp:forward page='<%=bloodType + ".jsp"%>' /> --%>
<%
	request.getRequestDispatcher(bloodType+".jsp").forward(request, response);

	
%>
</body>
</html>
