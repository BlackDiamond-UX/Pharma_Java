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
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Pharmacie App Management </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Item</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${medic != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${medic == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${medic != null}">
            			Edit Item
            		</c:if>
						<c:if test="${medic == null}">
            			Add New Item
            		</c:if>
					</h2>
				</caption>

				<c:if test="${medic != null}">
					<input type="hidden" name="id" value="<c:out value='${medic.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Medicament Item</label> <input type="text"
						value="<c:out value='${medic.item}' />" class="form-control"
						name="item" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Medicament Company</label> <input type="text"
						value="<c:out value='${medic.company}' />" class="form-control"
						name="company">
				</fieldset>

				<fieldset class="form-group">
					<label>Medicament Price</label> <input type="number"
						value="<c:out value='${medic.price}' />" class="form-control"
						name="price">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
