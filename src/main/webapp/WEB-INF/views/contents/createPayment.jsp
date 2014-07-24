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
	var actualAmount=$("#actualAmount").val();
	var paidAmount=$("#paidAmount").val();
	var actualDate=$("#actualDate").val();
	var paidDate=$("#paidDate").val();
	if(actualAmount==''){
		$("#actualAmount_error").html("actual amount is required");
		return true;
	}
	if(paidAmount==''){
		$("#paidAmount_error").html("paid amount is required");
		return true;
	}
	if(actualDate==''){
		$("#actualDate_error").html("actual date is required");
		return true;
	}
	if(paidDate==''){
		$("#paidDate_error").html("paid date is required");
		return true;
	}
	
}
</Script>


<form:form action="${pageContext.servletContext.contextPath}/web/form/payment/create" method="post" modelAttribute="payments" onsubmit="return onSubmit()">
<input type="hidden" name="hostlerId" value="${hostlerId}"/>
<table>


<tr>
<td>HostlerId</td>
<td><form:input path="hostlerId" value="${hostlerId}"/></td>
</tr>
<tr>
<td>ActualAmount</td><td>     <form:input path="actualAmount"/></td>
<td><span id="actualAmount_error" class="error"><form:errors path="actualAmount"></form:errors></span></td>
</tr>
<tr>
<td>Paid Amount</td><td>      <form:input path="paidAmount"/></td>
<td><span id="paidAmount_error" class="error"><form:errors path="paidAmount"></form:errors></span></td>

</tr>

<tr>
<td>ActualDate</td>        <td>   <form:input path="actualDate" value="${actualDate}" class="Date"/></td>
<td><span id="actualDate_error" class="error"><form:errors path="actualDate"></form:errors></span></td>
</tr>
<tr>
<td>PaidDate </td>      <td>    <form:input path="paidDate" class="Date"/></td>
<td><span id="paidDate_error" class="error"><form:errors path="paidDate"></form:errors></span></td>
</tr>
<!-- <tr>
<td>hostlerId</td><td> <input type="text" name="hostlerId"></td>
</tr> -->
<tr>
<td><input type="submit" name="submit" value="Submit"></td>
</tr>
</table>
</form:form>
