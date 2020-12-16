<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Dojo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<a href="/dashboard">Dashboard</a>

		<h1>${dojo.name} Dojo Location Ninjas</h1>
		
		
		<table class="table table-dark">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>


					
					<th>Actions</th>
				</tr>
			</thead>
			
			<tbody>
				<!-- loop through arraylist -->
				<c:forEach items="${dojo.ninja}" var="dojo">
					<tr>
						<td>${dojo.firstName}</td>
						<td>${dojo.lastName}</td>
						<td>${dojo.age}</td>

						
						<td><a href="/delete/${dojo.id}">Delete</a></td>
					</tr>
				
				</c:forEach>
			
			</tbody>
		
		
		
		
		
		
		</table>
	
	
	
	
	
	
	</div>
</body>
</html>