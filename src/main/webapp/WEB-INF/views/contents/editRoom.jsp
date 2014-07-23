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
<form:form action="${pageContext.servletContext.contextPath}/web/form/hostel/room/edit" method="post" modelAttribute="room">
<input type=hidden name="roomId" value="${room.roomId}">
<table>
<tr>
<td>RoomNumber</td> <td> <a>
</a>
<form:input path="roomNumber" value="${room.roomNumber}"/>
<!-- <input type="text" name="hostelName"/></td> -->
</tr>
<tr>
<td>No.Of.Beds</td> <td> 
<form:input path="noOfBeds" value="${room.noOfBeds}"/>
<tr>
<td>
HostelName
</td>
<td>
<form:select path="hostelId">
<form:option value="0" label="Select" />
<form:options items="${hostels}" itemValue="hostelId" itemLabel="hostelName" />
</form:select>
</td>
</tr>
<!-- <textarea rows="10" cols="10" name="hostelAddress"></textarea></td> -->

<tr>
<td><input type="submit" name="submit" value="Submit"/></td>
</tr>
</table>
</form:form>
</body>
</html>