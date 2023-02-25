<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.beer.spring.models.Delivery" %>
<%@ page import="com.beer.spring.models.User" %>
<%@ page import="com.beer.spring.BBDD.BBDDRepository" %>
<%@ page import="java.util.List" %>
<% HttpSession sesion = request.getSession(); %>

<footer class="footer seccion">
	<div class="contenedor contenedor-footer">
    	<div class="barra">
	    	<div>
            	<p>Calle Falsa 123, Dos Hermanas, 41089</p>
           	    <p>Teléfono: 955475687/664839321</p>
           	</div>
           	<div class="derecha">
           		<nav class="navegacion">
                	<a href="tienda">Tienda</a>
                	<!-- Controla que el usuario logueado sea admin para mostrar el boton de admin, si no es admin lo deja oculto -->
<%--                     <% if(session.getAttribute("admin") != null) {  --%>
<%--                         	if(sesion.getAttribute("login") == session.getAttribute("admin")) { %> --%>
<!--                         <a href="admin">Admin</a> -->
                        <a href="adminRest">Zona Usuario</a>
<%--                         	<% } %> --%>
<%--                         <% } %> --%>
                    <!-- Controla si ha iniciado sesion para mostar u ocultar el boton de Iniciar Sesion -->
                    <% if(sesion.getAttribute("login") == null) { %>
                    <a href="login">Iniciar Sesión</a>
                    <% } %>
                    <!-- Controla si ha iniciado sesion para mostar u ocultar el boton de Cerrar Sesion -->
                    <% if(sesion.getAttribute("login") != null) { %>
   	                <a href="logout">Cerrar Sesión</a>
   	                <% } %>
   	                <a href="contacto">Contacto</a>
   	            </nav>
            </div>
        </div>
     </div>
     <p class="copyright">Todos los derechos reservardos 2022 ©</p>
</footer>

</body>
</html>