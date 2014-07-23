<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="true" %>

<%-- background-repeat: repeat-x; background-image: url('<%=request.getContextPath()%>/resources/img/headerBg.jpg'); --%>
<div style="height: 90px; background: url(${pageContext.servletContext.contextPath}/resources/img/inner_header_bg.png) repeat-x;">
	<table style="width: 100%; height: 100%;" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td rowspan="2" style="width: 230px; vertical-align: middle; text-align: left;"><a href="${pageContext.servletContext.contextPath}/web" style="text-decoration: none;"><img border="0" alt="Hostel Management" title="Hostel Management" src="${pageContext.servletContext.contextPath}/resources/img/download.jpg" width="390" height="65" style="border: 0px;"></a></td>
			<td rowspan="2" style="text-align: center; font-size: 18px;">
				<sec:authorize access="isAuthenticated()">
					<%-- ${sessionData.companyInfo.companyName} --%>
				</sec:authorize>
			</td>
			<sec:authorize access="isAuthenticated()">
				<td style="width: 200px; vertical-align: top; padding-right: 5px; padding-top: 5px; text-align: right;">
					<sec:authentication property="principal.username" />
				</td>	
			</sec:authorize>
					
		</tr>
		<tr>
			<sec:authorize access="isAuthenticated()">
				<td style="width: 200px; vertical-align: bottom; text-align: right; padding-right: 5px; padding-bottom: 10px;"><a href="${pageContext.servletContext.contextPath}/logout"><img border="0" alt="Logout" title="Logout" src="${pageContext.servletContext.contextPath}/resources/img/logout.png"></a></td>
			</sec:authorize>			
		</tr>
	</table>
</div>
