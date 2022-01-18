<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>LoginDocente</title>
</head>
<body>
		
	
	<%@ include file="navbar.jsp" %>
	
	<c:if test="${!empty answer}">
		<div class="alert alert-success" role="alert">
  			<h6> ${answer}</h6>
		</div>
	</c:if>
	<c:if test="${!empty error}">
		<div class="alert alert-danger" role="alert">
  			<h6> ${error}</h6>
		</div>
	</c:if>
	
	<div class="container">
		<div class="row">
			<div class="col-8">
				<h2>Accedi</h2>
				<form method="post" action="LoginDocenteServlet">
				  <div class="mb-3">
				    <label for="exampleInputEmail1" class="form-label">Email address</label>
				    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
				  </div>
				  <div class="mb-3">
				    <label for="exampleInputPassword1" class="form-label">Password</label>
				    <input name="password" type="password" class="form-control" id="exampleInputPassword1">
				  </div>
				  <button type="submit" class="btn btn-primary">Entra</button>
				</form>
			</div>
		</div>
	</div>
	
	
	
</body>
</html>