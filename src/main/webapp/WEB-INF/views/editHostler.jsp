<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="${pageContext.servletContext.contextPath}/web/form/editHostler" method="post" modelAttribute="hostler">
<%-- <input type=hidden name="hostlerId" value="${hostler.hostlerId}"> --%>
<table>
<tr>
<td>Name</td>     <td>  <form:input path="name" /></td>
<td><span id="age_error" class="error"><form:errors path="name"></form:errors></span></td>
</tr>

<tr>


<td>First Name</td><td>     <form:input path="firstName" /></td>

<td>Last Name</td><td>      <form:input path="lastName" /></td>

</tr>
<tr>
<td>Age</td>        <td>   <form:input path="age" /></td>
<td><span id="age_error" class="error"><form:errors path="age"></form:errors></span></td>
</tr>
<tr>
<td>Sex </td>      <td>    <form:input path="sex" /></td>
<td><span id="age_error" class="error"><form:errors path="sex"></form:errors></span></td>
</tr>
<tr>
<td>Qualification</td><td> <form:input path="qualification" /></td>
<td><span id="age_error" class="error"><form:errors path="qualification"></form:errors></span></td>
</tr>
<tr>
<td>Date Of Join</td><td>    <form:input path="dateOfJoining" /></td>
<td><span id="age_error" class="error"><form:errors path="dateOfJoining"></form:errors></span></td>
</tr>

<tr>
<td>
Mobile Number</td><td> <form:input path="mobileNumber"/></td>
<td><span id="age_error" class="error"><form:errors path="mobileNumber"></form:errors></span></td>
</tr>
<tr>
<td>Address</td><td><form:textarea path="address" rows="5" cols="20"></form:textarea>
<td><span id="age_error" class="error"><form:errors path="address"></form:errors></span></td>
</td>
</tr>
<tr>
<td><input type="submit" name="submit" value="Submit"></td>
</tr>
</table>
</form:form>
</body>
</html>