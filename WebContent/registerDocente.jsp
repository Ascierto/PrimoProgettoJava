<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>RegisterDocente</title>
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
 
 	<div class="container my-5">
		<div class="row">
			<h3 class="my-3">Registra Docente</h3>
		    <div class="col-6">
			    <form action="InsertServlet" method="post">
				  <div class="mb-3">
				    <input type="text" name="name" class="form-control" id="name" placeholder="Inserisci nome..." required>
				  </div>
				  <div class="mb-3">
				    <input type="text" name="surname" class="form-control" id="surname" placeholder="Inserisci cognome..." required>
				  </div>
				  <div class="mb-3">
				    <input type="email" name="email" class="form-control" id="email" placeholder="Inserisci email.." required>
				  </div>
				  <div class="mb-3">
				    <input type="password" name="password" class="form-control" id="password" placeholder="Inserisci password..." required>
				  </div>
				  <div class="mb-3">
				    <input type="password" name="passwordCheck" class="form-control" id="password-check" placeholder="Ripeti password..." required>
				  </div>	
				  <button type="submit" class="btn btn-primary">Crea Docente</button>
				</form>
		    </div>
		</div>
	</div>
	

</body>
</html>