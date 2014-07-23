<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form:form action="${pageContext.servletContext.contextPath}/web/form/hostel/edit" method="post" modelAttribute="hostel">
<input type=hidden name="hostelId" value="${hostel.hostelId}">
<table>
<tr>
<td>HostelName</td> <td> <a>
</a>
<form:input path="hostelName" value="${hostel.hostelName}"/>
<!-- <input type="text" name="hostelName"/></td> -->
</tr>
<tr>
<td>address</td> <td> 
<form:textarea path="hostelAddress" value="${hostel.hostelAddress}"/>

<!-- <textarea rows="10" cols="10" name="hostelAddress"></textarea></td> -->
</tr>
<tr>
<td><input type="submit" name="submit" value="Submit"/></td>
</tr>
</table>

</form:form>
</body>
</html>