<jsp:include page="header.jsp"/>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.beer.spring.models.User" %>
<%@ page import="com.beer.spring.models.Person" %>
<%@ page import="com.beer.spring.models.Product" %>
<%@ page import="com.beer.spring.BBDD.BBDDRepository" %>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<body>
	<!-- Printa la sesion -->
	<p class="sesion">User: <%= session.getAttribute("login") %></p>
	
    <main class="contenedor seccion">

        <h1>Tu Carrito</h1>
        <div class="contenedor-carrito">
            <div class="contenido-anuncios">

                <table>
                    <thead>
                        <tr>
                            <th>Producto</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                        </tr>
                    </thead>
                    
                    <div class="anuncios"> 
                    <!-- Printa los productos añadidos al carrito, si no hay nada printa un mensaje de no hay productos -->
                    <% ArrayList<Product> products = (ArrayList<Product>)request.getAttribute("compra");
                    if(session.getAttribute("compra") == null) { %>
                    	<h1>Oooohhh, tu carrito está vacío :(</h1>
                    <% } %>
                	<% if(products != null) {
                		for(Product product : products) { %> 
                		
                        <tbody>
                            <tr>
                                <td class="imagen-carrito">
                                 	<img class="imagen-carrito" loading="lazy" src="/img/<%= product.getImagen() %>" alt="imagen/jpg">
                                </td>   
                                <td><h3 class="nombre"><%= product.getNombre() %></h3></td>
                                <td><p class="precio"><%= product.getPrecio() %> €</p> </td>
                            </tr>
                        </tbody>  
                        <% } %>  
           			 <% } else { %>
           			   
           			 <% } %>
                    </div>
                </table>
            </div>
            <!-- Printa el resumen del pedidos con el precio total -->
			<% ArrayList<Product> prices = (ArrayList<Product>)request.getAttribute("compra");
				double totalPr = 0;
				double imp = 0;
				double total = 0;
				double impuesto = 0.21;
				double envio = 7.99;
				NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "ES"));
				
                if(prices != null) {
                	for(Product price : prices) { 
                		totalPr = totalPr + price.getPrecio();
                		imp = totalPr * impuesto;	
                		total = totalPr + envio; 
                	}  
                 } %> 
            <% if(session.getAttribute("compra") != null) { %> 
            <aside class="resumen">
                <h3>Resumen del pedido</h3>
                <div class="contenido-precios">
                    <p>Total productos</p>
                    <p><%= nf.format(totalPr) %> </p>
                </div>
                <div class="contenido-precios">
                    <p>Gastos de envio</p>
                    <p><%= nf.format(envio) %></p>
                </div>
                <div class="contenido-precios">
                    <p>IVA 21%</p>
                    <p><%= nf.format(imp) %></p>
                </div>
                <div class="contenido-precios">
                    <p>Total</p>
                    <p><%= nf.format(total) %></p>
                </div>
            </aside>
            <% } %>
        </div>

    </main>

    <section class="contenedor seccion">
        <form class="formulario" method="post" action="compra">
            <fieldset>
                <legend>Dirección de envio</legend>
                <!-- Printa los datos del usuario en el formulario de envio -->
                <% ArrayList<User> users = (ArrayList<User>)request.getAttribute("user");
            	if(users != null) {
            		for(User user : users) { %>
                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" id="nombre" placeholder="Nombre *" value="<%= user.getNombre() %>">
                <label for="apellidos">Apellidos</label>
                <input type="text" name="apellidos" id="apellidos" placeholder="Apellidos *" value="<%= user.getApellidos() %>">
                <label for="nacimiento">Fecha de Nacimiento</label>
                <input type="date" name="nacimiento" id="nacimiento" value="<%= user.getNacimiento() %>">
                <label for="telefono">Teléfono</label>
                <input type="number" name="telefono" id="telefono" placeholder="Teléfono *" value="<%= user.getTelefono() %>">
                <label for="dni">DNI</label>
                <input type="text" name="dni" id="dni" placeholder="DNI *" value="<%= user.getDni() %>">
                <label for="direccion">Dirección</label>
                <input type="text" name="direccion" id="direccion" placeholder="Dirección *" value="<%= user.getDireccion() %>">
                <label for="CP">Código Postal</label>
                <input type="text" name="CP" id="CP" placeholder="Código Postal *" value="<%= user.getCp() %>">
                <label for="ciudad">Ciudad/Municipio</label>
                <input type="text" name="ciudad" id="ciudad" placeholder="Ciudad/Municipio *" value="<%= user.getCiudad() %>">
                <label>Condiciones de Privacidad</label>
            	<input type="checkbox" name="privado">
                   <% } %>
	            <% } %>
            </fieldset>
            <div class="formasPago">
            	<h3>Formas de pago aceptadas</h3>
                <img src="https://www.tiendanimal.es/on/demandware.static/Sites-TiendanimalES-Site/-/default/dwf5b0f709/images/logos-payment.svg">
       	    </div>            
   	        <input type="submit" value="Pagar" class="boton boton-amarillo-block">
        </form>
        <!-- Printa los errores si los hubiera -->
        <% Person person = (Person)request.getAttribute("person"); 
			ArrayList<String> mensaje = (ArrayList<String>)request.getAttribute("mensaje"); 
			if(mensaje != null) {
				for(String error : mensaje) { %>
					<p class="error"><%= error %></p>
			<% } %>
		<% } %>
		<% ArrayList<String> producto = (ArrayList<String>)request.getAttribute("producto"); 
		if(producto != null) {
			for(String pro : producto) { %>
				<p class="error"><%= pro %></p>
		<% } %>
	<% } %>
    </section>
  
    <jsp:include page="footer.jsp"/>
