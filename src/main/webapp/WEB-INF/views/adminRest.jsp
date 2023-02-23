<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.beer.spring.models.Delivery" %>
<%@ page import="com.beer.spring.models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>

<jsp:include page="header.jsp"/>

<body>
	<!-- Printa la sesion -->
	<c:set var="usuario" scope="session"><%= session.getAttribute("login") %></c:set>
	<p class="sesion">User: ${usuario}</p>
	
    <main class="contenedor seccion contenido-centrado admin">
        <form class="formulario">
            <label>Elija cliente</label>
            <select name="cliente" id="cliente">
            <option value="" selected> --Seleccionar-- </option>
<!-- 			Printa los clientes -->
             
            <c:if test="${users != null}">
           		<c:forEach var="user" items="${users}">
               		<option value="${user.getId()}">${user.getNombre()} ${user.getApellidos()}</option>
	          	</c:forEach>
	        </c:if>
            </select>
            <input type="submit" value="Ver Pedidos" class="boton boton-amarillo">
        </form>
        <% ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
             	ArrayList<Delivery> deliverys = (ArrayList<Delivery>)request.getAttribute("json");
        //Printa el nombre del cliente elegido
        if(deliverys != null) {
        		int idUsuario = 0; 
        		/* Comprueba si la longitud de users es 1 o mas, si solo hay uno esque no es admin y por lo tanto muestra 
        		solo los datos del usuario logueado */
	        	if(users.size() == 1) { %>
	        	
	        		<p>Cliente: ${users.get(0).getNombre()} ${users.get(0).getApellidos()}</p>
				<!-- Si es admin muestra todos los usuarios -->
	        	<% } else { %>
	        		<c:set var="id" value="${param.cliente}"></c:set>
	        		<c:set var="idUsuario" value="${id - 1}"></c:set>
	        		<p>Cliente: ${users.get(idUsuario).getNombre()} ${users.get(idUsuario).getApellidos()}</p>
	        		
				<% } %>
			<% } %>
        <table class="tabla-admin">
            <thead>
                <tr>
                    <th>ID Pedido</th>
                    <th>ID Productos</th>
                    <th>Total Producto</th>
                </tr>
            </thead>
           	<!-- Printa todos los pedidos realizados por un cliente -->
            <% double total = 0;
	           double totalPr = 0;
	           NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
	           	if(deliverys != null) {
	         		for(Delivery delivery : deliverys) { 
	            		totalPr = delivery.getTotal(); %>
				        <c:set var="idVenta"><%= delivery.getId_venta() %></c:set>
				        <c:set var="nombre"><%= delivery.getNombre() %></c:set>
			            <tbody>
			                <tr>
			                    <th>${idVenta}</th>
			                    <th>${nombre}<br></th>
			                    <th><%= nf.format(totalPr) %></th>
			                </tr>
			            </tbody>
			            <% total += totalPr; %>
            		<% } %>
		            <tbody>
						<tr>
							<th>Total Compras</th>
							<th></th>
			            	<th><%= nf.format(total) %></th>
			            </tr>
		           	</tbody>
            <% } %>
        </table>
    </main>
    
    <jsp:include page="footer.jsp"/>

