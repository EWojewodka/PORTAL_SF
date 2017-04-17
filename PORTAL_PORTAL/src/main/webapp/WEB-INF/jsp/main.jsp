<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Portal</title>
<link rel="stylesheet" href="/css/mainStyle.css" />
<link rel="stylesheet" href="/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round'
	rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
</head>

<body>
	<div class="container">
	<div class="text-left">
		<div class="row">
			<div class="col-xs-2">
				<button type="button" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#postDialog">Public new post!</button>
			</div>
			<div class="col-xs-8"> CONTENTS ${friends}
				<div id="postDialog" class="modal fade" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				        <h4 class="modal-title">Public new post!</h4>
				      </div>
				      <div class="modal-body">
				        <div class="form-group">
				        	<form:form action="/posts/add" method="GET" cssClass="form-group">
								<select show-data-icon="true" class="selectpicker" name="postAccess">
									<c:forEach items="${listOfPostAccess}" var="listOfPostAccessValue">
										<option value="${listOfPostAccessValue.key }" >
										<i class="${listOfPostAccessValue.value}"></i> ${listOfPostAccessValue.key}
										</option>
									</c:forEach>
								</select>
				        		<textarea rows="4" cols="68" name="contents" >People likes your new experiences. </textarea>
				        		<div class="modal-footer">
				        		<input type="hidden" value="${userId}" name="owner" />
				        			<button type="submit" class="btn btn-default">Upload</button>
				     			 </div>			
				        	</form:form>
				        </div>
				      </div>
					</div>
				</div>
			</div>
			</div>
			<div class="col-xs-2">
			${userName} | <a href="<c:url value="/logout" />">Logout</a>
			</div>
		</div>
	</div>
	</div>
</body>
</html>