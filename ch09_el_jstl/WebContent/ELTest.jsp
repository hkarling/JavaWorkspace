<%--
  Created by hkarling
  Date: 2019-06-28
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EL 표현식</title>
</head>
<body>

<h1> EL - 표현언어 </h1>
<h3>
    \${5} = ${5} <br>
    \${5+2} = ${5+2} <br>
    \${5*4} = ${5*4} <br>
    \${5/2} = ${5/2} <br>
    <hr>
    \${5 gt 2} = ${5 gt 2} <br>
    \${5==5 or 3>2} = ${5==5 or 3>2} <br>
    \${5==5 and 3>2} = ${5==5 and 3>2} <br>

    <hr>
    <%-- 만약 요청이 http://localhost:8080/ch09_el_jstl_Web_exploded/ELTest.jsp?id=값 있을때 --%>

    ${ param.id == null ? "Guest" : param.id } 님<br>
    ${ empty param.id ? "Guest" : param.id } 님<br>
    ${ not empty param.id ? param.id : "Guest" } 님<br>

    <hr>
    <%-- 문자열 붙이기--%>
    ${ empty param.id ? "Guest님 " : param.id.concat(" 님") }<br>
    ${ empty param.id ? "Guest님 " : param.id+=" 님" }<br>
    <hr>
    <%--
        만약 parameter로 age가 전송되었다고 가정하에 age의 값이 18보다 작으면 "~살은 미성년자입니다.", 크면 "~살은 성ㅇ인입니다."
    --%>
    ${ param.age < 18 ? param.age.concat("살은 미성년자입니다.") : param.age.concat("살은 성인입니다.")} <br>

    <hr color="red">

    <%-- scope에 저장된 정보 열기 --%>
    <%
        request.setAttribute("id", "jang");
        session.setAttribute("addr", "판교");
        session.setAttribute("message", "난 session 의 message");

        application.setAttribute("message", "난 application 의 메세지임.");
        application.setAttribute("menus", new String[]{"짜장면", "짬뽕", "우동"});
    %>

    id = <%=request.getAttribute("id")%> / ${requestScope.id} / ${id}<br>
    addr = <%=session.getAttribute("addr")%> / ${sessionScope.addr} / ${addr}<br>
    message = <%=session.getAttribute("message")%> / ${sessionScope.message} / ${message}<br>

    message = <%=application.getAttribute("message")%> / ${applicationScope.message} / error!:${message}<br>
    menus = <%=application.getAttribute("menus")%> / ${applicationScope.menus} / ${menus}<br>

    <hr color="red">

    <%--    자바 객체에 있는 getXxx() 메소드를 El로 접근하기 --%>

    <%--    객체를 생성하는 액션태그 --%>
    <jsp:useBean id="dto" class="ex0628.dto.productDTO"/>
    <h1>상품정보</h1>
    코드 : <%=dto.getCode()%> / ${dto.code} <br>
    이름 : <%=dto.getName()%> / ${dto.name} <br>
    가격 : <%=dto.getPrice()%> / ${dto.price} <br>
    수량 : <%=dto.getQyt()%> / ${dto.qyt} <br>
    총금액 : <%=dto.getPrice() * dto.getQyt()%> / ${dto.price * dto.qyt} <br>

</h3>
</body>
</html>
