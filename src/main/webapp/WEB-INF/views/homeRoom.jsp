<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<tr>
<td>
RoomNumber
</td>
<td>
No.of.Beds
</td>
<td>
HostelName
</td>
<td colspan="3">
<b>
Actions
</b>
</td>
</tr>
<c:forEach items="${room}" var="room">
<tr>
<td>
${room.roomNumber}
</td>
<td>
${room.noOfBeds}
</td>
<td>
${room.hostelName} 
</td>
<td>

<a href="${pageContext.servletContext.contextPath}/web/form/deleteRoom/${room.roomId}">Delete room</a>

</td>
<td>

<a href="${pageContext.servletContext.contextPath}/web/editRoom/${room.roomId}">Edit room</a>

</td>
</tr>

</c:forEach>


</table>

</body>
</html>