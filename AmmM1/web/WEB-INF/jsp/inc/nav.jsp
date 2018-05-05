<%-- 
    Document   : nav
    Created on : 5-mag-2018, 14.59.29
    Author     : Marty
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
		<nav id="nav1" class="navbar cornice">
			<div class="nav-main cornice"><a href="#">Fast Press Writer</a></div>
			<div class="nav <c:if test="${page=='notizia'}">nav-selected</c:if> cornice"><a href="notizia.html">Notizie</a></div>
			<div class="nav <c:if test="${page=='profilo'}">nav-selected</c:if> cornice"><a href="profilo.html">Profilo</a></div>
			<div class="nav <c:if test="${page=='articoli'}">nav-selected</c:if> cornice"><a href="articoli.html">I miei Articoli</a></div>
			<div class="nav-last <c:if test="${page=='login'}">nav-selected</c:if> cornice"><a href="login.html">Logout</a></div>
		</nav>
