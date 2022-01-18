   <nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Primo Progetto demo</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
			
	      
	        <c:choose>
			    <c:when test="${empty loggedDocente}">
			        
			        <li class="nav-item">
			          <a class="nav-link active" href="InsertServlet">RegistraDocente</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link active" href="LoginDocenteServlet">Login</a>
			        </li>
			    </c:when>    
			    <c:otherwise>
					<li class="nav-item">
						<div class="align-items-center">
				          <h6 class="nav-link active">Bentornato ${loggedDocente.getName()}</h6>
						</div>
			        </li>
			        <li class="nav-item">
			        	<form action="LogoutDocenteServlet" method="post">
			        		<input class="nav-link active" type="submit" value="Logout">
			        	</form>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="HomeServlet">HomeServlet</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link active" aria-current="page" href="InsertStudenteToDocenteServlet">AssegnaStudente</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="CalcolatriceServlet">CalcolatriceServlet</a>
			        </li>
			         <li class="nav-item">
			        	<a class="nav-link" href="InserisciStudenteServlet">InserisciStudenteServlet</a>
			        </li>
			        <li class="nav-item">
			        	<a class="nav-link" href="StudentiServlet">StudentiServlet</a>
			        </li>
			        
			    </c:otherwise>
			</c:choose>
	      </ul>
	    </div>
	  </div>
	</nav>