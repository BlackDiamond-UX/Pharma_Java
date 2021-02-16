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
<div class="container col-md-5">
	<div class="card">
		<div class="card-body">
			<c:if test="${item != null}">
			<form action="update" method="post">
				</c:if>
				<c:if test="${item == null}">
				<form action="insert" method="post">
					</c:if>

					<caption>
						<h2>
							<c:if test="${item != null}">
								Edit Article
							</c:if>
							<c:if test="${item == null}">
								Add New Article
							</c:if>
						</h2>
					</caption>

					<c:if test="${item != null}">
						<input type="hidden" name="id" value="<c:out value='${item.id}' />" />
					</c:if>

					<fieldset class="form-group">
						<label>Article Name</label> <input type="text"
														   value="<c:out value='${item.nom}' />" class="form-control"
														   name="nom" required="required">
					</fieldset>

					<fieldset class="form-group">
						<label>Article Company</label> <input type="text"
															  value="<c:out value='${item.company}' />" class="form-control"
															  name="company">
					</fieldset>

					<fieldset class="form-group">
						<label>Article Price</label> <input type="text"
															value="<c:out value='${item.price}' />" class="form-control"
															name="price">
					</fieldset>
						<fieldset class="form-group">
							<label>Article Quantity</label> <input type="text"
																value="<c:out value='${item.qun}' />" class="form-control"
																name="qun">
						</fieldset>
						<fieldset class="form-group">
							<label>Article Description</label> <input type="text"
																   value="<c:out value='${item.description}' />" class="form-control"
																   name="description">
						</fieldset>
					<button type="submit" class="btn btn-success">Save</button>
				</form>
		</div>
	</div>
</div>
</body>
</html>
