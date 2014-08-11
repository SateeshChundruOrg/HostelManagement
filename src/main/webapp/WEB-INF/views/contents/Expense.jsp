<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
<table class="grid" cellpadding="8" cellspacing="0">
<tr>
<th>
Reason
</th>
<th>
Amount
</th>
<th>
Date
</th>
<th colspan="3">
<b>
Actions
</b>
</th>
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
<a href="javascript:if(confirm('Delete this form submission?')){window.location='${pageContext.servletContext.contextPath}/web/form/expense/delete/${expense.expenseId}'}">Delete Expense </a>

</td>
<td>

<a href="${pageContext.servletContext.contextPath}/web/expense/edit/${expense.expenseId}">Edit expense</a>

</td>
</tr>

</c:forEach>


</table>


