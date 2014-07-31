<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body >
<form:form action="${pageContext.servletContext.contextPath}/web/form/hostler/room/mapping/create" method="post" >
<input type="hidden" name="hostlerId" value="${hostlerId}"/>
<table >
<tr>
<td>Select Room</td> <td> <select name="roomId" >
<c:forEach items="${rooms}" var="room">
<c:choose>
<c:when test="${hostlerRoomMapping.roomId==room.roomId }">
<option value="${room.roomId }" selected="selected">${room.hostelName}-${room.roomNumber}-${room.availableBeds} Available</option>
</c:when>
<c:otherwise>
<option value="${room.roomId }">${room.hostelName}-${room.roomNumber}-${room.availableBeds} Available</option>
</c:otherwise>
</c:choose>

</c:forEach>
</select></td>
</tr>
<tr>
<td>DateOfJoining</td>
<td> <input type="text" id="dateOfJoining" name="dateOfJoining" value="${hostlerRoomMapping.dateOfJoining}" class="Date"/></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="Submit"/></td>
</tr>
</table>
</form:form>
</body>
</html>