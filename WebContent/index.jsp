<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	
  <%@ include file="navbar.jsp" %>
  
  	<c:if test="${!empty stato}">
			<div class="alert alert-success" role="alert">
	  			<h6> ${stato}</h6>
			</div>
		</c:if>
		
		<c:if test="${!empty loggedDocente}">
			<div class="container">
				<div class="row">
					<div class="col-12">
			  			<h5> Benvenuto ${loggedDocente.getName()} ${loggedDocente.getSurname()}</h5>
			  			<h6>${loggedDocente.getEmail()}</h6>
					</div>
				</div>
			</div>
		</c:if>
	
	<div class="container my-5">
		<div class="row">
		    <div class="col-6">
			    <form action="HomeServlet" method="post">
				  <div class="mb-3">
				    <input type="text" name="name" class="form-control" id="name" placeholder="Inserisci nome...">
				  </div>
				  <div class="mb-3">
				    <input type="text" name="surname" class="form-control" id="surname" placeholder="Inserisci cognome...">
				  </div>
			
				  <button type="submit" class="btn btn-primary">Submit</button>
				</form>
		    </div>
		</div>
	</div>

		<c:if test="${!empty name} || ${!empty surname}">

		    <h1>Ciao a tutti da ${name} ${surname}</h1>
		</c:if>
		
		
		
</body>
</html>