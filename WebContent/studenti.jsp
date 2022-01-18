<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Studenti</title>
</head>
<body>
		
	
	<%@ include file="navbar.jsp" %>
	
	
	
		<c:if test="${!empty stato}">
			<div class="alert alert-success" role="alert">
	  			<h6> ${stato}</h6>
			</div>
		</c:if>
		<c:if test="${!empty delete}">
			<div class="alert alert-success" role="alert">
	  			<h6> ${delete}</h6>
			</div>
		</c:if>
	
   		
   		<div class="container">
   			<div class="row">
   				<div class="col-12">
	 				<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">#Id</th>
					      <th scope="col">Nome</th>
					      <th scope="col">Cognome</th>
					      <th scope="col">Età</th>
					      <th scope="col">Modifica</th>
					      <th scope="col">Cancella</th>
					      <th scope="col">Profilo</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<c:forEach var="studente" items="${studenti}">
					  	  <tr>
					  		<th scope="row"><c:out value="${studente.getIdStudente()}"/></th>
			       			<td><c:out value="${studente.getName()}"/></td> 
			       			<td><c:out value="${studente.getSurname()}"/></td> 
			       			<td><c:out value="${studente.getAge()}"/></td>
			       			<td>
			       				<form action="UpdateServlet" method="post">
				       				<input type="hidden" name="id_studente" value="${studente.getIdStudente()}">
				       				<input class="btn btn-warning" type="submit" value="Modifica">
				       			</form>
			       			</td>
			       			<td>
				       			<form action="DeleteServlet" method="post">
				       				<input type="hidden" name="id_studente" value="${studente.getIdStudente()}">
				       				<input class="btn btn-danger" type="submit" value="Cancella">
				       			</form>
			       			</td>
			       			<td>
			       				<form action="ProfileServlet" method="post">
				       				<input type="hidden" name="id_studente" value="${studente.getIdStudente()}">
				       				<input class="btn btn-outline-dark" type="submit" value="${studente.getName()} ${studente.getSurname()}">
				       			</form>
			       			</td>
						  </tr>
			   			</c:forEach>	    
					  </tbody>
					</table>   					
   				</div>
   			</div>
   		</div>
		
	
</body>
</html>