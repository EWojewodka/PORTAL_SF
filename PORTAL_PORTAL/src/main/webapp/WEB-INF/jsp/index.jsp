<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="/css/mainStyle.css" />
<title>Insert title here</title>
</head>
<body>
	<header>index</header>
	<form:form action="/account/registration" method="POST"  >
		<table>
			<tr>
				<td><form:label path="login">Login:</form:label></td>
				<td><form:input path="login" /></td>
			</tr>
			<tr>
				<td><form:label path="password"> Password: </form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="email"> E-mail</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<input type="submit" value="submit" />
			</tr>
		</table>
	</form:form>
</body>
	</html>
</jsp:root>