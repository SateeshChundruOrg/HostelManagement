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
</head>
<body>
<table>
<tr>
<td>
Reason
</td>
<td>
Amount
</td>
<td>
Date
</td>
<td colspan="3">
<b>
Actions
</b>
</td>
</tr>
<c:forEach items="${expenses}" var="expense">
<tr>
<td>
${expense.expense}
</td>
<td>
${expense.amount}
</td>
<td>
${expense.date}
</td>
<td>

<a href="${pageContext.servletContext.contextPath}/web/form/deleteExpense/${expense.expenseId}">Delete Expense</a>

</td>
<td>

<a href="${pageContext.servletContext.contextPath}/web/editExpense/${expense.expenseId}">Edit expense</a>

</td>
</tr>

</c:forEach>


</table>


</body>
</html>