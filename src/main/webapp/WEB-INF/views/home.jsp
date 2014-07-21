<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Welcome!
</h1>

<P>  The time on the server is ${serverTime}. </P>
<table class="grid">
<tr>
<td>
<b>
 Name
</b>
</td>
<td>
<b>
 FirstName
</b>
</td>
<td>
<b>
 LastName
</b>
</td>
<td>
<b>
 Age
</b>
</td>
<td>
<b>
 Sex
</b>
</td>
<td>
<b>
 Qualification
</b>
</td>
<td>
<b>
 DateOfJoining
</b>
</td>
<td>
<b>
 MobileNumber
</b>
</td>
<td>
<b>
 Address
</b>
</td>
<td colspan="4">
<b>
Actions
</b>
</td>
</tr>
<c:forEach items="${hostlers}" var="hostler">
<tr>
<td>
${hostler.name}
</td>
<td>
${hostler.firstName}
</td>
<td>
${hostler.lastName}
</td>
<td>
${hostler.age}
</td>
<td>
${hostler.sex}
</td>
<td>
${hostler.qualification}
</td>
<td>
${hostler.dateOfJoining}
</td>
<td>
${hostler.mobileNumber}
</td>
<td>
${hostler.address}
</td>
<td>

<a href="${pageContext.servletContext.contextPath}/web/form/deleteHostler/${hostler.hostlerId}">Delete Hostler</a>

</td>
<td>

<a href="${pageContext.servletContext.contextPath}/web/form/editHostlerLand/${hostler.hostlerId}">Edit Hostler</a>

</td>
<td>
<c:choose>
<c:when test="${hostler.roomAssigned==true}">
<a href="${pageContext.servletContext.contextPath}/web/createHostlerRoomMappingLand/${hostler.hostlerId}">Re Assign</a>
</c:when>
<c:otherwise>
<a href="${pageContext.servletContext.contextPath}/web/createHostlerRoomMappingLand/${hostler.hostlerId}">Assign</a>
</c:otherwise>
</c:choose>



</td>

<td>
<c:if test="${unpaid==1}">
<a href="${pageContext.servletContext.contextPath}/web/hostler/createPaymentLand/${hostler.hostlerId}?actualDate=${hostler.actualDate}">Add Payment</a>
</c:if>
</td></tr>

</c:forEach>

</table>

</body>
</html>
