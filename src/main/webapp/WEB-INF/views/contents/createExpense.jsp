<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.error{
color:red
}
</style>

</head>
<body>
<form:form action="${pageContext.servletContext.contextPath}/web/form/createExpense" method="post" modelAttribute="expense">
<table>
<tr>
<td>Reason</td> <td> <form:input path="expense"/></td><td><span class="error"><form:errors path="expense"></form:errors></span>
</tr>
<tr>
<td>Amount</td> <td> <form:input path="amount"/><td><span class="error"><form:errors path="amount"></form:errors></span></td>
</tr>
<tr>
<td>Date</td> <td> <form:input path="date"/></td>
</tr>

<tr>
<td><input type="submit" name="submit" value="Submit"></td>
</tr>
</table>

</form:form>
</body>
</html>