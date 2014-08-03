<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form:form action="${pageContext.servletContext.contextPath}/web/hostler/payment/history" method="post" >

<table >
<tr>
<td>Select hostler</td> <td> <select name="hostlerId" >
<c:forEach items="${hostlers}" var="hostler">

<option value="${hostler.hostlerId}" >${hostler.name}-${hostler.mobileNumber}</option>



</c:forEach>
</select></td>
</tr>

<tr>
<td><input type="submit" name="submit" value="Submit"/></td>
</tr>
</table>
</form:form>
