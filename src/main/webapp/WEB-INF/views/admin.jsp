<jsp:include page="header.jsp"/>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.beer.spring.models.Delivery" %>
<%@ page import="com.beer.spring.models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>

<body>
	<!-- Printa la sesion -->
	<p class="sesion">User: <%= session.getAttribute("login") %></p>
	
    <main class="contenedor seccion contenido-centrado admin">
        <form class="formulario">
            <label>Elija cliente</label>
            <select name="cliente" id="cliente">
            <option value="" selected> --Seleccionar-- </option>
			<!-- Printa los clientes -->
             <% ArrayList<User> users = (ArrayList<User>)request.getAttribute("users");
             	ArrayList<Delivery> deliverys = (ArrayList<Delivery>)request.getAttribute("delivery");
            	if(users != null) {
            		for(User user : users) { %>
                <option value="<%= user.getId() %>"><%= user.getNombre() + " " + user.getApellidos() %></option>
	                <% } %>
	            <% } %>
            </select>
            <input type="submit" value="Ver Pedidos" class="boton boton-amarillo">
        </form>
        <!-- Printa el nombre del cliente elegido -->
        <% if(deliverys != null) {
        		int idUsuario = 0; 
        
	        	if(deliverys.size() == 0) { %>
	        	
	        		<p>Admin: <%= users.get(0).getNombre() + " " + users.get(0).getApellidos() %></p>
	        		
	        	<% } else { 
	        		
	        		int id = Integer.parseInt(deliverys.get(0).getUsuarios_id());
	        		idUsuario = id - 1;%>
	        		<p>Cliente: <%= users.get(idUsuario).getNombre() + " " + users.get(idUsuario).getApellidos() %></p>
	        		
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
            <tbody>
                <tr>
                    <th><%= delivery.getId_venta() %></th>
                    <th><%= delivery.getNombre() %><br></th>
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
