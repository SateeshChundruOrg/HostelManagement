<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form:form>
<table>
<tr>
<td>Old Password</td>
<td><form:input path="oldPassword"/></td>
</tr>
<tr>
<td>New Password</td>
<td><form:input path="newPassword"/></td>
</tr>
<tr>
<td>Confirm Password</td>
<td><form:input path="confirmPassword"/></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="submit"></td>
</tr>
</table>
</form:form>