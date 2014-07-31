<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form:form action="${pageContext.servletContext.contextPath}/web/hostel/room/search" method="post" modelAttribute="search"  >
<table>



<tr>
<td>
noOfAvailalableBeds</td><td> <form:input path="availableBeds"/></td>

</tr>

<tr>
<td><input type="submit" name="submit" value="Submit"></td>
</tr>
</table>
</form:form>
