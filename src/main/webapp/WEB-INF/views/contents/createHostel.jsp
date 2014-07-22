<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>

<form:form action="${pageContext.servletContext.contextPath}/web/form/createHostel" method="post" modelAttribute="hostel">
<table>
<tr>
<td>HostelName</td> <td> <a>
</a>
<form:input path="hostelName"/>
<!-- <input type="text" name="hostelName"/></td> -->
</tr>
<tr>
<td>address</td> <td> 
<form:textarea path="hostelAddress"/>

<!-- <textarea rows="10" cols="10" name="hostelAddress"></textarea></td> -->
</tr>
<tr>
<td><input type="submit" name="submit" value="Submit"/></td>
</tr>
</table>

</form:form>
