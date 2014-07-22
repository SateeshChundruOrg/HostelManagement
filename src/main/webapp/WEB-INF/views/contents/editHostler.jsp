<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.servletContext.contextPath}/web/editHostler" method="post">\
<input type=hidden name="hostlerId" value="${hostler.hostlerId}">
<table>
<tr>
<td>FullName</td>     <td>  <input type="text" name="name" value="${hostler.name} "></td>
</tr>

<tr>


<td>First Name</td><td>     <input type="text" name="firstName" value="${hostler.firstName} "></td>

<td>Last Name</td><td>      <input type="text" name="lastName" value="${hostler.lastName} "></td>

</tr>
<tr>
<td>Age</td>        <td>   <input type="text" name="age" value="${hostler.age} "></td>
</tr>
<tr>
<td>Sex </td>      <td>    <input type="text" name="sex" value="${hostler.sex} "></td>
</tr>
<tr>
<td>Qualification</td><td> <input type="text" name="qualification" value="${hostler.qualification} "></td>
</tr>
<tr>
<td>Date Of Join</td><td>    <input type="text" name="dateOfJoining" value="${hostler.dateOfJoining} "></td>
</tr>

<tr>
<td>
Mobile Number</td><td> <input type="text" name="mobileNumber"value="${hostler.mobileNumber} "></td>
</tr>
<tr>
<td>Address</td><td><textarea rows="5" cols="5" name="address" value="${hostler.address} "></textarea>
</td>
</tr>
<tr>
<td><input type="submit" name="submit" value="Submit"></td>
</tr>
</table>
</form>
</body>
</html>