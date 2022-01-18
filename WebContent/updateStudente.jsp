<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Modifica Studente</title>
</head>
<body>
		
	
 <%@ include file="navbar.jsp" %>
	
		<c:if test="${!empty error}">
			<div class="alert alert-danger" role="alert">
	  			<h6> ${error}</h6>
			</div>
		</c:if>
		
	
	
	<div class="container my-5">
		<div class="row">
			<h3 class="my-3">Modifica Studente</h3>
		    <div class="col-6">
			    <form action="ModifyServlet" method="post">
			    	<input type="hidden" name="id_studente" value="${studente.getIdStudente()}">
				  <div class="mb-3">
				    <input type="text" name="name" class="form-control" id="name" value="${ studente.getName()}" required>
				  </div>
				  <div class="mb-3">
				    <input type="text" name="surname" class="form-control" id="surname" value="${ studente.getSurname()}" required>
				  </div>
				  <div class="mb-3">
				    <input type="number" name="age" class="form-control" id="age" value="${ studente.getAge()}" required>
				  </div>	
				  <button type="submit" class="btn btn-primary">Modifica Studente</button>
				</form>
		    </div>
		</div>
	</div>
	
	
<!-- 	faccio una visualizzazione i tabella degli studenti  con all'interno un update  ed una delete-->
		
		
		
	
	
</body>
</html>