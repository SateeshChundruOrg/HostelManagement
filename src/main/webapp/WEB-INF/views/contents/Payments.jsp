<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<table class="grid" cellpadding="8" cellspacing="0">
<tr>
<th>HostlerName</th>
<th>
<b>
ActualAmount
</b>
</th>
<th>
<b>
 PaidAmount
</b>
</th>
<th>
<b>
 ActualDate
</b>
</th>
<th>
<b>
 PaidDate
</b>
</th>


</tr>
<c:forEach items="${payments}" var="payments">
<tr>
<td> 
${payments.hostlerName}
</td>
<td>
${payments.actualAmount}
</td>
<td>
${payments.paidAmount}
</td>
<td>
${payments.actualDate}
</td>
<td>
${payments.paidDate}
</td>
</c:forEach>

</table>

