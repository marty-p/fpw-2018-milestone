<%--
    Document   : login
    Created on : 05 mag 2018, 13:33:46
    Author     : Marty
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
	<!-- HEAD START -->
	<c:set var="title" value="Login" scope="request"/>
	<jsp:include page="inc/head.jsp"/>
	<!-- HEAD END -->
	<body>
		<!-- NAV START -->
        <c:set var="page" value="login" scope="request"/>
        <jsp:include page="inc/nav.jsp"/>
		<!-- NAV END -->

		<!-- ASIDE START -->
        <jsp:include page="inc/aside.jsp"/>
		<!-- ASIDE END -->

		<main id="main1" class="cornice">
			<article>
				<div id="logotxt" class="clearfix centrato2">
					<img src="pics/logo.png"
						 alt="logo"
						 class="toleft shrink32px"
					/>
					<h1>Fast Press Writer</h1>
				</div>
				<div id="form1" class="cornice centrato intpad1">
					<form action="articoli.html" method="POST">
						<label class="block form-vert" for="username">Nome Utente</label>
						<input class="block form-vert" id="username" name="username" type="text" placeholder="nome utente"/>
						<label class="block form-vert" for="password">Password</label>
						<input class="block form-vert" id="password" name="password" type="password" placeholder="password"/>
						<input class="block form-vert" type="submit" value="Accedi"/>
					</form>
				</div>
			</article>
		</main>
	</body>
</html>
