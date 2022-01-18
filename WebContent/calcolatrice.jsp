<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <%@ include file="navbar.jsp" %>
 
		<div class="container mt-5">
			<div class="row">
			    <div class="col-6">
				    <form action="CalcolatriceServlet" method="post">
					  <div class="mb-3">
					    <input type="number" name="num1" class="form-control" placeholder="Inserisci numero1...">
					  </div>
					  <div class="mb-3">
						  <select name="operation" class="form-select" placeholder="Seleziona operazione">
							  <option value="+"> + </option>
							  <option value="-"> - </option>
							  <option value="x"> x </option>
							  <option value="/"> / </option>
						  </select>
					  </div>
					  <div class="mb-3">
					    <input type="number" name="num2" class="form-control" placeholder="Inserisci numero2">
					  </div>
				
					  <button type="submit" class="btn btn-primary">Submit</button>
					</form>
			    </div>
			</div>
		</div>
		
		<c:if test="${!empty error}">
		    <h2>Errore : ${e}</h2>
		</c:if>
		
		<c:if test="${!empty risultato}">
		    <h2>Il risultato è : ${risultato }</h2>
		</c:if>
		

</body>
</html>