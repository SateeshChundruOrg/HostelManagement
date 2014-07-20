<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>

<form action="${pageContext.servletContext.contextPath}/web/form/createPayment" method="post">
<input type="hidden" name="hostlerId" value="${hostlerId}"/>
<table>


<tr>


<td>ActualAmount</td><td>     <input type="text" name="actualAmount"></td>

<td>Paid Amount</td><td>      <input type="text" name="paidAmount"></td>

</tr>

<tr>
<td>ActualDate</td>        <td>   <input type="text" name="actualDate" value="${actualDate}"></td>
</tr>
<tr>
<td>PaidDate </td>      <td>    <input type="text" name="paidDate"></td>
</tr>
<!-- <tr>
<td>hostlerId</td><td> <input type="text" name="hostlerId"></td>
</tr> -->
<tr>
<td><input type="submit" name="submit" value="Submit"></td>
</tr>
</table>
</form>

</body>
</html>