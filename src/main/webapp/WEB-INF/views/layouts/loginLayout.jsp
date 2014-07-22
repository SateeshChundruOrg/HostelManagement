<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Spoors EFFORT | <tiles:insertAttribute name="title-content" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- <link rel="stylesheet" href="http://yui.yahooapis.com/3.8.0/build/cssreset/cssreset.css" type="text/css"> -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/menu.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/effort.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/layout.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/globalNav.css" />
<style type="text/css">
	.error {
		color: #ff0000;
	}
	.success {
		color: #00662e;
	}
</style>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
<tiles:insertAttribute name="js-content" />
<tiles:insertAttribute name="css-content" />
</head>
<body style="margin: 0px; padding: 0px; height: 100%;">
	<table class="layout" cellpadding="0" cellspacing="0" style="background-color: #fff;">
		<tr class="header"><td><%-- <tiles:insertAttribute name="header-content" /> --%></td></tr>
		<tr class="content"><td style="vertical-align: top;"><tiles:insertAttribute name="body-content" /></td></tr>
		<tr class="footer"><td><div style="width: 960px; margin: auto; "><tiles:insertAttribute name="footer-content" /></div></td></tr>
	</table>
</body>
</html>