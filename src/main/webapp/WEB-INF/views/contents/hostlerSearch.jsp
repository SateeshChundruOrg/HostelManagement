<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form:form action="${pageContext.servletContext.contextPath}/web/hostler/search" method="post" modelAttribute="search"  >
<table>
<tr >
<td>Name </td>     <td>  <form:input path="name" placeholder="name"/></td>

</tr>

<tr>


<td>First Name</td><td>     <form:input path="firstName"/></td>
</tr>
<tr>
<td>Last Name</td><td>      <form:input path="lastName"/></td>

</tr>



<tr>
<td>
Mobile Number </td><td> <form:input path="mobileNumber"/></td>

</tr>

<tr>
<td><input type="submit" name="submit" value="Submit"></td>
</tr>
</table>
</form:form>
