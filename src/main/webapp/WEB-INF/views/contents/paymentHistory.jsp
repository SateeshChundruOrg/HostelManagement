<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<table class="grid" cellpadding="8" cellspacing="0">
<tr>
<th>
name
</th>
<th>
actualAmount
</th>
<th>
PaidAmount
</th>
<th>
actualDate
</th>
<th>
PaidDate
</th>


</tr>

<c:forEach items="${payments}" var="payment">

<tr>
<td>
${payment.hostlerName} 
</td>
<td>
${payment.actualAmount}
</td>
<td>
${payment.paidAmount}
</td>
<td>
${payment.actualDate}
</td>
<td>
${payment.paidDate}
</td>
</tr>
</c:forEach>
</table>

