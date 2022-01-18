<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>InsertStudenteToDocente</title>
</head>
<body>

	<%@ include file="navbar.jsp" %>
	<c:if test="${!empty stato}">
		<div class="alert alert-success" role="alert">
  			<h6> ${stato}</h6>
		</div>
	</c:if>
	<c:if test="${!empty error}">
		<div class="alert alert-success" role="alert">
  			<h6> ${error}</h6>
		</div>
	</c:if>
		

	<div class="container">
		<div class="row">
			<div class="col-12">
				<h3>Collega studente a Docente</h3>
			</div>
			<div class="col-12 my-5">
			
				<form action="" method="post">
				  <div class="mb-3">
				  	<input type="hidden" name="id_docente" value="${loggedDocente.getId_docente()}">
				    <select name="id_studente" class="form-select" aria-label="Default select example">
					  <option selected>Seleziona studente</option>
					  
					  <c:forEach var="studente" items="${studenti}">
					  	<option value="${studente.getIdStudente()}" >${studente.getName()} ${studente.getSurname()} </option>
					  </c:forEach>

					</select>
				  </div>
				  <button type="submit" class="btn btn-primary">Assegna</button>
				</form>
			</div>
		</div>
	</div>
	

</body>
</html>