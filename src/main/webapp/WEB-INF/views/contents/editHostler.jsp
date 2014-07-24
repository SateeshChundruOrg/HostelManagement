<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
	var name=$("#name").val();
	var age=$("#age").val();
// 	var sex=$("#sex").val();
	var qualification=$("#qualification").val();
	var mobileNumber=$("#mobileNumber").val();
	var address=$("#address").val();
	
	if(name==''){
		$("#name_error").html("* Name is required");
		
		return true;
	}
	if(age==''){
		$("#age_error").html("* Age is required");
		return true;
	}
 	if(sex==''){
 		$("#sex_error").html("* sex is required");
 		return true;
 	}
	if(qualification==''){
		$("#qualification_error").html("*qualification is required");
		return true;
	}
	
	if(mobileNumber==''){
		$("#mobileNumber_error").html("*mobileNumber is required");
		return true;
	}
	if(address==''){
		$("#address_error").html("* address is required");
		return true;
	}
	return false;
}
</script>
</head>
<body>

<form:form action="${pageContext.servletContext.contextPath}/web/form/hostler/edit" method="post" modelAttribute="hostler" onsubmit="return onSubmit()" >
 <input type=hidden name="hostlerId" value="${hostler.hostlerId}">
<table>
<tr>
<td>Name*</td>     <td>  <form:input path="name" /></td>
<td><span id="name_error" class="error"><form:errors path="name"></form:errors></span></td>
</tr>

<tr>


<td>First Name</td><td>     <form:input path="firstName" /></td>
</tr>
<tr>
<td>Last Name</td><td>      <form:input path="lastName" /></td>

</tr>
<tr>
<td>Age*</td>        <td>   <form:input path="age" /></td>
<td><span id="age_error" class="error"><form:errors path="age"></form:errors></span></td>
</tr>
<tr>
<td>Sex* </td>      <td><form:radiobutton path="sex" value="M" checked="checked"/>Male 
                   <form:radiobutton path="sex" value="F"/>Female
                   </td>
<td><span id="sex_error" class="error"><form:errors path="sex"></form:errors></span></td>
</tr>
<tr>
<td>Qualification*</td><td> <form:input path="qualification" /></td>
<td><span id="qualification_error" class="error"><form:errors path="qualification"></form:errors></span></td>
</tr>


<tr>
<td>
Mobile Number*</td><td> <form:input path="mobileNumber"/></td>
<td><span id="mobileNumber_error" class="error"><form:errors path="mobileNumber"></form:errors></span></td>
</tr>
<tr>
<td>Address*</td><td><form:textarea path="address" rows="5" cols="20"></form:textarea>
<td><span id="address_error" class="error"><form:errors path="address"></form:errors></span></td>

</tr>
<tr>
<td><input type="submit" name="submit" value="Submit"></td>
</tr>
</table>
</form:form>
