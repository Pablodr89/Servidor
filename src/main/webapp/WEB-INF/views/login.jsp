<jsp:include page="header.jsp"/>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.beer.spring.models.User" %>
<%@ page import="java.util.ArrayList" %>

<body>

    <h1>BeerWorld</h1>
		
    <main class="contenedor seccion contenido-centrado">
   	<div class="main-login">
   		<form class="formulario main-login" method="post" action="tienda">
            <fieldset>
                <legend>Email y Password</legend>
    
                <label for="email">E-mail</label>
                <input type="email" name="email" placeholder="Tu Email" id="email">
    
                <label for="password">Password</label>
                <input type="password" name="password" placeholder="Tu Password" id="password">
            </fieldset>
            <div class="barra">
                <input type="submit" value="Iniciar Sesion" class="boton boton-amarillo boton-index">
            </div>
        </form>
        <div class="errores">
        	<!-- Printa los errores si los hubiera -->
        	<% User user = (User)request.getAttribute("user"); 
			ArrayList<String> mensaje = (ArrayList<String>)request.getAttribute("mensaje"); 
			
			 if(mensaje != null) {
				for(String error : mensaje) { %>
					<p class="error"><%= error %></p>
				<% } %>
			<% } %>
        </div>
   	</div>
    </main>
	
    <jsp:include page="footer.jsp"/>
