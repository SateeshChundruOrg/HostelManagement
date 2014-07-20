<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/web/form/createRoom" method="post">
<table>
<tr>
<td>RoomNo</td> <td> <input type="text" name="roomNumber"></td>
</tr>
<tr>
<td>No.Of.Beds</td> <td> <input type="text" name="noOfBeds"></td>
</tr>

<tr>
<td>Select Hostel</td> <td> <select name="hostelId" >
<c:forEach items="${hostels}" var="hostel">
<option value="${hostel.hostelId }">${hostel.hostelName }</option>
</c:forEach>
</select></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="Submit"></td>
</tr>
</table>

</form>
</body>
</html>