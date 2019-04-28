<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All rooms</title>
</head>
<body>
<div align="center">
    <table border="1px">
        <tr>
            <th>Number of room</th>
            <th>Lamp Off/On</th>
        </tr>
        <c:forEach var="room" items="${rooms}">
            <tr>
                <c:url var="editRoomUrl" value="/editroom?key=${room.key}"/>
                <td><c:out value="${room.key + 1}"></c:out></td>
                <c:if test="${room.value == false}">
                    <td><c:out value="OFF"></c:out></td>
                </c:if>
                <c:if test="${room.value == true}">
                    <td><c:out value="ON"></c:out></td>
                </c:if>
                <td><a href="${editRoomUrl}">Enter to room</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="<%="/"%>">Show All rooms</a>
</div>
</body>
</html>
