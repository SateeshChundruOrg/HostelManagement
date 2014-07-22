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
<form action="${pageContext.servletContext.contextPath}/web/unpaidHostlers" method="get">
<table>
<tr>
<td>Enter Starting Date:</td>
<td><input type="text"  name="fromDate"></td>
</tr>
<tr>
<td>Enter Ending Date:</td>
<td><input type="text"  name="toDate"></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="Submit"></td>
</tr>
</table>
</form>+
</body>
</html>