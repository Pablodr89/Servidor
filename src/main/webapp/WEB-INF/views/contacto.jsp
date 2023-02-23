<jsp:include page="header.jsp"/>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.beer.spring.models.Contact" %>
<%@ page import="java.util.ArrayList" %>
<body>

    <main class="contenedor seccion contenido-centrado">
        <h1>Rellene el formulario de contacto</h1>

        <form class="formulario" method="post">
            <fieldset>
                <legend>Informacion Personal</legend>
                <label for="nombre">Nombre</label>
                <input type="text" placeholder="Tu Nombre" id="nombre" name="nombre">
                <label for="email">Email</label>
                <input type="email" placeholder="Tu Email" id="email" name="email">
                <label for="telefono">Teléfono</label>
                <input type="tel" placeholder="Tu Teléfono" id="telefono" name="telefono">
                <label for="mensaje">Mensaje</label>
                <textarea id="mensaje" name="mensaje"></textarea>
            </fieldset>
            <input type="submit" value="Enviar" class="boton boton-amarillo">
        </form>
        <!-- Printa los errores si los hubiera -->
        <% Contact contact = (Contact)request.getAttribute("contacto"); 
		ArrayList<String> mensaje = (ArrayList<String>)request.getAttribute("mensaje"); 
		if(mensaje != null) {
			for(String error : mensaje) { %>
				<p class="error"><%= error %></p>
			<% } %>
		<% } %>
    </main>

    <jsp:include page="footer.jsp"/>
