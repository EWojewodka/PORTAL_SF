<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page import="pl.jemiol.model.AccountModel" />
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>welcome.jsp</title>
<link rel="stylesheet" href="/css/mainStyle.css" />
</head>
<body>
	<header> Portal Alpha </header>
	<ul class="site-nav">
		<li class="nav-item"><a href="#">home</a></li>
		<li class="nav-item"><a href="#">friends</a></li>
		<li class="nav-item"><a href="#">web</a></li>
		<li class="nav-item"><a href="#">#hash</a></li>
		<li class="nav-item"><a href="#">about</a></li>
	</ul>
	<section>
		<article>
			<h2>${account}</h2>
		</article>
		<article>
			<h3>${messenge }</h3>
		</article>
		<article>${result}</article>
	</section>
	<footer></footer>
</body>
	</html>
</jsp:root>