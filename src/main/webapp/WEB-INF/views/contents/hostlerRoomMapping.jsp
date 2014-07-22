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
<table>
<tr>
<td>
RoomId
</td>
<td>
HostlerId
</td>
<td>
Date
</td>
<td colspan="3">
<b>
Actions
</b>
</td>
</tr>
<c:forEach items="${hostlerRoomMaping}" var="hostlerRoomMaping">
<tr>
<td>
${hostlerRoomMaping.roomId}
</td>
<td>
${hostlerRoomMaping.hostlerId}
</td>
<td>
${hostlerRoomMaping.dateOfJoining}
</td>

</tr>

</c:forEach>


</table>


</body>
</html>