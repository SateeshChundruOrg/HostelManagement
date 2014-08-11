<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script>
$(document).ready(function(){
	 var url='${pageContext.servletContext.contextPath}/web/hostel/all';
	$('#page').xPagination({
		page : '${page}',
		total :'${total}',
		url : url,
		});
	
});
</script>

<div id="page">
<table class="grid xPagination" cellpadding="8" cellspacing="0">
<tr>
<th>
HostelName
</th>
<th>
HostelAddress
</th>
<th colspan="3">
<b>
Actions
</b>
</th>
</tr>
<c:forEach items="${host}" var="hostel">
<tr>
<td>
${hostel.hostelName}
</td>
<td>
${hostel.hostelAddress}
</td>
<td>
<a href="javascript:if(confirm('Delete this form submission?')){window.location='${pageContext.servletContext.contextPath}/web/form/hostel/delete/${hostel.hostelId}'}">Delete Hostel </a>


</td>
<td>

<a href="${pageContext.servletContext.contextPath}/web/hostel/edit/${hostel.hostelId}">Edit Hostel</a>

</td>
</tr>

</c:forEach>


</table>

</div>