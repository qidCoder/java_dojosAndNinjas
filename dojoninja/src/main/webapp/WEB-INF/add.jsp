<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><!-- in order to use validations via JSTL -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new Ninja</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<h1>New Ninja</h1>	
		<a href="/dashboard">Dashboard</a>
		
		<form:form method="POST" action="/ninjas/create" modelAttribute="ninja">
		<div class="form-group row">
			<form:label path="dojo" class="col-sm-2 col-form-label">Dojo:
				<form:errors path="dojo" />
				<div class="col-sm-10">
					<select class="form-control" name="dojo" path="dojo">
						<c:forEach items="${allDojos}" var="dojo">
							<option value="${dojo.id}">${dojo.name}</option>								
						</c:forEach>
					</select>
				</div>
			</form:label>
		</div>
			<div class="form-group row">
				<form:label path="firstName" class="col-sm-2 col-form-label">First Name:
					<form:errors path="firstName"/>
					<div class="col-sm-10">
						<form:input path="firstName" class="form-control"/>
					</div>
				</form:label>
			</div>
			<div class="form-group row">
				<form:label path="lastName" class="col-sm-2 col-form-label">Last Name:
					<form:errors path="lastName"/>
					<div class="col-sm-10">
						<form:input path="lastName" class="form-control"/>
					</div>
				</form:label>
			</div>
			<div class="form-group row">
				<form:label path="age" class="col-sm-2 col-form-label">Age:
					<form:errors path="age"/>
					<div class="col-sm-10">
						<form:input path="age" class="form-control"/>
					</div>
				</form:label>
			</div>
			
			<button>Create</button>
			
		</form:form>

	</div>


</body>
</html>