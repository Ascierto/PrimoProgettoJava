<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Inserisci Studente</title>
</head>
<body>
		
	
 <%@ include file="navbar.jsp" %>
	
		<c:if test="${!empty stato}">
			<div class="alert alert-danger" role="alert">
	  			<h6> ${stato}</h6>
			</div>
		</c:if>
		
	
	
	<div class="container my-5">
		<div class="row">
			<h3 class="my-3">Inserisci un nuovo Studente</h3>
		    <div class="col-6">
			    <form action="InserisciStudenteServlet" method="post">
				  <div class="mb-3">
				    <input type="text" name="name" class="form-control" id="name" placeholder="Inserisci nome..." required>
				  </div>
				  <div class="mb-3">
				    <input type="text" name="surname" class="form-control" id="surname" placeholder="Inserisci cognome..." required>
				  </div>
				  <div class="mb-3">
				    <input type="number" name="age" class="form-control" id="age" placeholder="Inserisci età" required>
				  </div>	
				  <button type="submit" class="btn btn-primary">Crea Studente</button>
				</form>
		    </div>
		</div>
	</div>
	
	
<!-- 	faccio una visualizzazione i tabella degli studenti  con all'interno un update  ed una delete-->
		
		
		
	
	
</body>
</html>