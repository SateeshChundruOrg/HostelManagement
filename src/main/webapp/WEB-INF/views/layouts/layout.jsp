<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Ateam | <tiles:insertAttribute name="header-title-content" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<tiles:insertAttribute name="css-content" />
<tiles:insertAttribute name="js-content" />
</head>
<body style="margin: 0px; padding: 0px;">

	<table border="0" cellspacing="0" cellpadding="0" class="layout">
		<tr class="header"><td colspan="2"><tiles:insertAttribute name="header-content" /></td></tr>
		<tr style="height: 5em;"><td colspan="2"><tiles:insertAttribute name="nav-menu-content" /></td></tr>
		<tr class="content">
			<%-- <td class="side-panel" nowrap="nowrap">
				<div class="menu-title">Usage</div>
				<div class="menu-content"><tiles:insertAttribute name="side-panel-content"/></div>
			</td> --%>
			<td class="content">
				<h1 class="title"><tiles:insertAttribute name="title-content" /></h1>
				<tiles:insertAttribute name="body-content" />
			</td>
		</tr>
		<tr class="footer"><td colspan="2"><tiles:insertAttribute name="footer-content" /></td></tr>
	</table>
	
</body>
</html>