<jsp:include page="header.jsp"/>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.beer.spring.models.Product" %>
<%@ page import="java.util.ArrayList" %>

<body>
	<!-- Printa la sesion -->
	<p class="sesion">User: <%= session.getAttribute("login") %></p>

    <main class="contenedor seccion">
        <h1>Cervezas en Venta</h1>

        <div class="contenedor-anuncios">
        	<!-- Printa los todos productos -->
        	<% ArrayList<Product> products = (ArrayList<Product>)request.getAttribute("product"); 
				for(Product product : products) { %>
	            <div class="anuncio">
	      	        <img loading="lazy" src="/img/<%= product.getImagen() %>" alt="imagen/jpg">
	                <div class="contenido-anuncio">
	                    <h3 class="nombre"><%= product.getNombre() %></h3>
	                    <p class="precio"><%= product.getPrecio() %> €</p>  
	                    <form method="POST" action="">
	                        <input type="submit" value="Añadir al carrito" class="boton boton-rojo-block"></input>
	                        <input type="hidden" name="id" value="<%= product.getId() %>" id="id">
	                        <input type="hidden" name="tipo">
	                    </form>      
	                </div>
	            </div>
        	<% } %>
        </div>
    </main>
    <jsp:include page="footer.jsp"/>
