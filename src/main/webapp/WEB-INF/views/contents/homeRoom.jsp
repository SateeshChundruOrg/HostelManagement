<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<script>
$(document).ready(function(){
	 var url='${pageContext.servletContext.contextPath}/web/hostel/room/all';
	$('#page').xPagination({
		page : '${page}',
		total :'${total}',
		url : url,
		});
	
});
</script>

<div id="page">

<table class="grid xPagination" cellpadding="8" cellspacing="0">
<tr>
<th>
RoomNumber
</th>
<th>
No.of.Beds
</th>
<th>
HostelName
</th>
<th colspan="3">
<b>
Actions
</b>
</th>
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
<a href="javascript:if(confirm('Delete this form submission?')){window.location='${pageContext.servletContext.contextPath}/web/form/hostel/room/delete/${room.roomId}'}">Delete Room </a>

</td>
<td>

<a href="${pageContext.servletContext.contextPath}/web/hostel/room/edit/${room.roomId}">Edit room</a>

</td>
</tr>

</c:forEach>


</table>
</div>
