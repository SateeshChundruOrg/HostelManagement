<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="${pageContext.servletContext.contextPath}/web/hostel/expense/amount" method="get">
<table>
<tr>
<td>Enter Starting Date:</td>
<td><input type="text" id="startDate"  name="startDate" class="Date"></td>
</tr>
<tr>
<td>Enter Ending Date:</td>
<td><input type="text" id="endDate" name="endDate" class="Date"></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="Submit"></td>
</tr>
</table>
</form>
