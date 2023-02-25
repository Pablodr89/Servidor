<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/app.css">
    <title>BeerWorld</title>
</head>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="com.beer.spring.models.Delivery" %>
<%@ page import="com.beer.spring.models.User" %>
<%@ page import="com.beer.spring.BBDD.BBDDRepository" %>
<%@ page import="java.util.List" %>
<% HttpSession sesion = request.getSession(); %>

	<header class="header">
        <div class="contenedor contenido-header">
            <div class="barra">
                <a href="index" class="titulo">
                    <h1>BeerWorld</h1>
                </a>
                <div class="derecha">
                    <nav class="navegacion">
                        <a href="tienda" class="icono">
                            <svg class="icono2" xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-building-store" width="44" height="44" viewBox="0 0 24 24" stroke-width="1.5" stroke="#2c3e50" fill="none" stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                                <line x1="3" y1="21" x2="21" y2="21" />
                                <path d="M3 7v1a3 3 0 0 0 6 0v-1m0 1a3 3 0 0 0 6 0v-1m0 1a3 3 0 0 0 6 0v-1h-18l2 -4h14l2 4" />
                                <line x1="5" y1="21" x2="5" y2="10.85" />
                                <line x1="19" y1="21" x2="19" y2="10.85" />
                                <path d="M9 21v-4a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v4" />
                              </svg>
                            Tienda
                        </a>
                        <!-- Controla que el usuario logueado sea admin para mostrar el boton de admin, si no es admin lo deja oculto -->
<%--                         <% if(session.getAttribute("admin") != null) {  --%>
<%--                         	if(sesion.getAttribute("login") == session.getAttribute("admin")) { %> --%>
<!--                         <a href="admin" class="icono"> -->
                        <a href="adminRest" class="icono">
                            <svg class="icono2" xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-user-exclamation" width="44" height="44" viewBox="0 0 24 24" stroke-width="1.5" stroke="#2c3e50" fill="none" stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                                <circle cx="9" cy="7" r="4" />
                                <path d="M3 21v-2a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v2" />
                                <line x1="19" y1="7" x2="19" y2="10" />
                                <line x1="19" y1="14" x2="19" y2="14.01" />
                              </svg>
                            Zona Usuario
                        </a>
<%--                         	<% } %> --%>
<%--                         <% } %> --%>
                        <!-- Controla si ha iniciado sesion para mostar u ocultar el boton de Iniciar Sesion -->
                		<% if(sesion.getAttribute("login") == null) { %>
                        <a href="login" class="icono">
                            <svg class="icono2" xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-user" width="44" height="44" viewBox="0 0 24 24" stroke-width="1.5" stroke="#2c3e50" fill="none" stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                                <circle cx="12" cy="7" r="4" />
                                <path d="M6 21v-2a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v2" />
                              </svg>
                            Iniciar Sesión
                        </a>
                        <% } %>
                        <!-- Controla si ha iniciado sesion para mostar u ocultar el boton de Cerrar Sesion -->
                        <% if(sesion.getAttribute("login") != null) { %>
                        <a href="logout" class="icono">
                            <svg class="icono2" xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-user" width="44" height="44" viewBox="0 0 24 24" stroke-width="1.5" stroke="#2c3e50" fill="none" stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                                <circle cx="12" cy="7" r="4" />
                                <path d="M6 21v-2a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v2" />
                              </svg>
                            Cerrar Sesión
                        </a>
                        <% } %>
                        <a href="carrito" class="icono">
                            <svg class="icono2" xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-shopping-cart" width="44" height="44" viewBox="0 0 24 24" stroke-width="1.5" stroke="#2c3e50" fill="none" stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                                <circle cx="6" cy="19" r="2" />
                                <circle cx="17" cy="19" r="2" />
                                <path d="M17 17h-11v-14h-2" />
                                <path d="M6 5l14 1l-1 7h-13" />
                              </svg>
                              Carrito
                        </a>
                        <a href="contacto" class="icono">
                            <svg class="icono2" xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-file-info" width="44" height="44" viewBox="0 0 24 24" stroke-width="1.5" stroke="#2c3e50" fill="none" stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none"/>
                                <path d="M14 3v4a1 1 0 0 0 1 1h4" />
                                <path d="M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2z" />
                                <path d="M11 14h1v4h1" />
                                <path d="M12 11h.01" />
                              </svg>
                            Contacto
                        </a>
                    </nav>
                </div>
            </div>
        </div>
    </header>