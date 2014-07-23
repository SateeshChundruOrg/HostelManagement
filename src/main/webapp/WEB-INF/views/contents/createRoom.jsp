<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>

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
		$("#hostelId_error").html("hostel id is required");
		return true;
	}
	
}
</Script>
</head>
<body>
<form:form action="${pageContext.servletContext.contextPath}/web/form/hostel/room/create" method="post" modelAttribute="room"  onsubmit="return onSubmit()">
<table >
<tr>
<td>RoomNo</td> <td> <form:input path="roomNumber"/></td>
<td><span id="roomNumber_error" class="error"><form:errors path="roomNumber"></form:errors></span></td>
</tr>
<tr>
<td>No.Of.Beds</td> <td> <form:input path="noOfBeds"/></td>
<td><span id="noOfBeds_error" class="error"><form:errors path="noOfBeds"></form:errors></span></td>
</tr>

<tr>
<td>Select Hostel</td> <td> <select name="hostelId" >

<c:forEach items="${hostels}" var="hostel">
<option value="${hostel.hostelId }">${hostel.hostelName }</option>
</c:forEach>
</select></td>
<td><span id="hostelId_error" class="error"><form:errors path="hostelId"></form:errors></span></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="Submit"></td>
</tr>
</table>

</form:form>
