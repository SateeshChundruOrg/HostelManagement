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

<table class="grid" cellpadding="8" cellspacing="0">
<tr>
<th>
Spent
</th>
<th>
Received
</th>
<th>
Gain/Loss
</th>
</tr>



<tr>
<td>
${amountSpent} 
</td>
<td>
${amountReceived}
</td>
<td>
${availableAmount}
</td>
</tr>

</table>

</body>
</html>