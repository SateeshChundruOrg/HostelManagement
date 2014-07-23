<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<style>
.error{
color:red
}
</style>
</head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script type="text/javascript">
function onSubmit(){
	if(isFormContainErrors()){
		return false;
	}
	return true;
}
function isFormContainErrors(){
	var hostelName="$(#hostelName)".val();
	var hostelAddress="$(#hostelAddress)".val();
	if(hostelName==''){
		$("#hostelName_error").html("hostel name is required");
		return true;
	}
	if(hostelAddress==''){
		$("#hostelAddress_error").html("hostel address is required");
		return true;
	}
		
}
</script>
</head>
<body>
<form:form action="${pageContext.servletContext.contextPath}/web/form/createHostel" method="post" modelAttribute="hostel" onsubmit="return onSubmit()">
<table>
<tr>
<td>HostelName</td> <td> <a>
</a>
<form:input path="hostelName"/>
<!-- <input type="text" name="hostelName"/></td> -->
<td><span id="hostelName_error" class="error"><form:errors path="hostelName"></form:errors></span></td>
</tr>
<tr>
<td>address</td> <td> 
<form:textarea path="hostelAddress"/>
<td><span id="hostelAddress_error" class="error"><form:errors path="hostelAddress"></form:errors></span></td>
<!-- <textarea rows="10" cols="10" name="hostelAddress"></textarea></td> -->
</tr>
<tr>
<td><input type="submit" name="submit" value="Submit"/></td>
</tr>
</table>

</form:form>
</body>
</html>