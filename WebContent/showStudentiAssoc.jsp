<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>ShowStudentiAssoc</title>
</head>
<body>

	<%@ include file="navbar.jsp" %>
	
	<c:if test="${!empty stato}">
		<div class="alert alert-success" role="alert">
  			<h6> ${stato}</h6>
		</div>
	</c:if>
	
	
   		<div class="container my-5">
   			<div class="row py-5">
   				<div class="col-12">
					<h3 class="">Ecco la lista Studenti del prof. 
						<span class="text-secondary h2">${loggedDocente.getName()} ${loggedDocente.getSurname()}</span> 
					</h3>
   				</div>
   			</div>
   			<div class="row">
   				<div class="col-12">
	 				<table class="table table-striped">
					  <thead>
					    <tr class="table-light">
					      <th scope="col">#Id</th>
					      <th scope="col">Nome</th>
					      <th scope="col">Cognome</th>
					      <th scope="col">Età</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<c:forEach var="studente" items="${studentiAssoc}">
					  	  <tr class="table-secondary">
					  		<th scope="row"><c:out value="${studente.getIdStudente()}"/></th>
			       			<td><c:out value="${studente.getName()}"/></td> 
			       			<td><c:out value="${studente.getSurname()}"/></td> 
			       			<td><c:out value="${studente.getAge()}"/></td>
						  </tr>
			   			</c:forEach>	    
					  </tbody>
					</table>   					
   				</div>
   			</div>
   		</div>

</body>
</html>