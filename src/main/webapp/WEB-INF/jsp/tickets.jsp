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
    <title>Title</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Купленные билеты:</h1>
<ul>
    <%--    <%--%>
    <%--        TicketService ticketService = TicketService.getInstance();--%>
    <%--        Long flightId = Long.valueOf(request.getParameter("flightId"));--%>
    <%--        for (TicketDto ticketDto : ticketService.findAllByFlightId(flightId)) {--%>
    <%--            out.write(String.format("<li>%s</li>", ticketDto.seatNo()));--%>
    <%--        }--%>
    <%--    %>--%>
    <c:if test="${not empty requestScope.tickets}">
        <c:forEach var="ticket" items="${requestScope.tickets}">
            <li>${fn:toLowerCase(ticket.seatNo())}</li>
        </c:forEach>
    </c:if>
</ul>
</body>
</html>
