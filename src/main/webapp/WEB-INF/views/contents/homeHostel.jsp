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
<table class="grid" cellpadding=8 cellspaceing=0>
<tr>
<th>
HostelName
</th>
<th>
HostelAddress
</th>
<th colspan="3">
<b>
Actions
</b>
</th>
</tr>
<c:forEach items="${host}" var="hostel">
<tr>
<td>
${hostel.hostelName}
</td>
<td>
${hostel.hostelAddress}
</td>
<td>

<a href="${pageContext.servletContext.contextPath}/web/form/deleteHostel/${hostel.hostelId}">Delete Hostel</a>

</td>
<td>

<a href="${pageContext.servletContext.contextPath}/web/editHostel/${hostel.hostelId}">Edit Hostel</a>

</td>
</tr>

</c:forEach>


</table>

</body>
</html>