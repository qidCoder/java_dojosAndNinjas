<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to ninjas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<a href="/ninjas/new">Add a new ninja</a>
		<a href="/dojos/new">Add a new dojo</a>

		<h1>All Dojos</h1>
		
		
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Name</th>


					
					<th>Actions</th>
				</tr>
			</thead>
			
			<tbody>
				<!-- loop through arraylist -->
				<c:forEach items="${allDojos}" var="dojo">
					<tr>
						<td><a href="/showDojo/${dojo.id}">${dojo.name}</a></td>

						
						<td><a href="/delete/${dojo.id}">Delete</a></td>
					</tr>
				
				</c:forEach>
			
			</tbody>
		
		
		
		
		
		
		</table>
	
	
	
	
	
	
	</div>
</body>
</html>