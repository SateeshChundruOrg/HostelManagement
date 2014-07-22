<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error{
color:red
}
</style>
</head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	//$("#first").hide();
});

function onSubmit(){
	
	if(isFormContainsErrors()){
		return false;
	}

	return true;
	
}
function isFormContainsErrors(){
	var roomNumber=$("#roomNumber").val();
	var noOfBeds=$("#noOfBeds").val();
	var hostelId=$("#hostelId").val();
	if(roomNumber==''){
		$("#roomNumber_error").html("room number is required");
		return true;
	}
	if(noOfBeds==''){
		$("#noOfBeds_error").html("no of beds is required");
	    return true;
	}
	if(hostelId==""){
		$("#hostelId_error").html("hostel id is require");
		return true;
	}
	
}
</Script>
</head>
<body>
<form:form action="${pageContext.servletContext.contextPath}/web/form/createRoom" method="post">
<table>
<tr>
<td>RoomNo</td> <td> <form:input path="roomNumber"/></td>
<td><span id="roomNumber_error" class="error"><form:errors path="roomNumber"></form:errors></span></td>
</tr>
<tr>
<td>No.Of.Beds</td> <td> <form:input path="noOfBeds"/></td>
<td><span id="noOfBeds_error" class="error"><form:errors path="noOfBeds"></form:errors></span></td>
</tr>

<tr>
<td>Select Hostel</td> <td> <form:select path="hostelId" >
<td><span id="hostelId_error" class="error"><form:errors path="hostelId"></form:errors></span></td>
<c:forEach items="${hostels}" var="hostel">
<option value="${hostel.hostelId }">${hostel.hostelName }</option>
</c:forEach>
</form:select></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="Submit"></td>
</tr>
</table>

</form:form>
</body>
</html>