<%@ page import="by.javaguru.je.jdbc.service.TicketService" %>
<%@ page import="by.javaguru.je.jdbc.dto.TicketDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>

<%--
Created by IntelliJ IDEA.
User: stas
Date: 12.03.2024
Time: 12:33
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Перелеты</title>
</head>
<body>
<%@ include file="header.jsp"%>
<h1>Список перелетов:</h1>
<ul>
    <c:if test="${not empty requestScope.flights}">
    <c:forEach var="flight" items="${requestScope.flights}">
        <li><a href="${pageContext.request.contextPath}/tickets?flightId=${flight.id()}">${flight.description()}</a> </li>
    </c:forEach>
    </c:if>
</ul>
</body>
</html>
