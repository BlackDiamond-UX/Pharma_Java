<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Pharmacie App Management</title>
	<link rel="stylesheet"
		  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		  crossorigin="anonymous">
</head>
<body>

<header>
	<nav class="navbar navbar-expand-md navbar-dark"
		 style="background-color: dodgerblue">
		<div>
			<a href="#" class="navbar-brand"> Pharmacie App Management </a>
		</div>

		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>/list"
				   class="nav-link">Article</a></li>
		</ul>
	</nav>
</header>
<br>

<div class="row">
	<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

	<div class="container">
		<h3 class="text-center">List Of Articles</h3>
		<hr>
		<div class="container text-left">

			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
				New Article</a>
		</div>
		<br>
		<table class="table table-bordered">
			<thead>
			<tr>
				<th>Article</th>
				<th>Company</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Description</th>
				<th>Actions</th>
			</tr>
			</thead>
			<tbody>
			<!--   for (Todo todo: todos) {  -->
			<c:forEach var="item" items="${listArticle}">

				<tr>
					<td><c:out value="${item.nom}" /></td>
					<td><c:out value="${item.company}" /></td>
					<td><c:out value="${item.price}" /></td>
					<td><c:out value="${item.qun}" /></td>
					<td><c:out value="${item.description}" /></td>
					<td><a href="edit?id=<c:out value='${item.id}' />" class="btn btn-outline-danger">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${item.id}' />" class="btn btn-outline-warning">Delete</a></td>
				</tr>
			</c:forEach>
			<!-- } -->
			</tbody>

		</table>
	</div>
</div>
</body>
</html>
