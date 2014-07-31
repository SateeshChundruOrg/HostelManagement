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
 Name
</b>
</th>
<th>
<b>
 FirstName
</b>
</th>
<th>
<b>
 LastName
</b>
</th>
<th>
<b>
 Age
</b>
</th>
<th>
<b>
 Sex
</b>
</th>
<th>
<b>
 Qualification
</b>
</th>

<th>
<b>
 MobileNumber
</b>
</th>

<th>
<b>
 Address
</b>
</th>
<th>
<b>
 DateOfJoining
</b>
</th>
<th colspan="4">
<b>
Actions
</b>
</th>
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
${hostler.mobileNumber}
</td>
<td>
${hostler.address}
</td>
<td>
${hostlerRoomMapping.dateOfJoining}
</td>
<td>

<a href="${pageContext.servletContext.contextPath}/web/form/hostler/delete/${hostler.hostlerId}">Delete Hostler</a>

</td>
<td>

<a href="${pageContext.servletContext.contextPath}/web/hostler/edit/${hostler.hostlerId}">Edit Hostler</a>

</td>

<td>
<c:if test="${unpaid==1}">
<a href="${pageContext.servletContext.contextPath}/web/hostler/payment/create/${hostler.hostlerId}?actualDate=${hostler.actualDate}">Add Payment</a>
</c:if>
</td></tr>

</c:forEach>

</table>


