<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table class="grid" cellpadding="8" cellspacing="0">
<tr>
<th>
<b>
 RoomNumber
</b>
</th>
<th>
<b>
 HostelName
</b>
</th>
<th>
<b>
 availableBeds
</b>
</th>
</tr>
<c:forEach items="${rooms}" var="rooms">
<tr>
<td>
${rooms.roomNumber}
</td>
<td>
${rooms.hostelName}
</td>
<td>
${rooms.availableBeds}
</td>

</tr>
</c:forEach>
</table>


