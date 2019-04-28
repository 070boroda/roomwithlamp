<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Room</title>
</head>
<body>
<div align="center">
    <c:url var="changeUrl" value="/changestatus?key=${key}"/>
    <p><form:label path="key">Number of Room:</form:label></p>
    <p><c:out value="${key + 1}"></c:out></p>
    <p>Light is:</p>
    <c:if test="${status == false}">
        <p></p><c:out value="off"></c:out></p>
    </c:if>
    <c:if test="${status == true}">
        <p><c:out value="on"></c:out></p>
    </c:if>
    <p><a href="${changeUrl}">On/off</a></p>

    <p><a href="<%="/"%>">Show all room</a></p>
</div>
</body>
</html>
