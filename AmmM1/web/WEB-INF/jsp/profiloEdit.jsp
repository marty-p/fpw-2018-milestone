<%-- 
    Document   : profilo
    Created on : 6-mag-2018, 6.30.04
    Author     : Marty
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<!-- HEAD START -->
	<c:set var="title" value="Modifica Profilo" scope="request"/>
	<jsp:include page="/WEB-INF/jsp/inc/head.jsp"/>
	<!-- HEAD END -->
	<body>
		<!-- NAV START -->
        <c:set var="page" value="profilo" scope="request"/>
        <jsp:include page="/WEB-INF/jsp/inc/nav.jsp"/>
		<!-- NAV END -->

		<!-- ASIDE START -->
        <jsp:include page="/WEB-INF/jsp/inc/aside.jsp"/>
		<!-- ASIDE END -->

		<main id="main1" class="cornice">
			<article class="centrato2">
				<h1>Il mio profilo</h1>
				<form action="profilo.html" method="POST" class="form-hori">
					<div class="form-hori">
					<img
						<c:choose>
							<c:when test="${item.imageUrl==null}">src="pics/noavatar.png"</c:when>
							<c:otherwise>src="${item.imageUrl}"</c:otherwise>
						</c:choose>
						alt="avatar"
						class="shrink150px"
					>
					</div>
					<div class="form-hori">
						<!-- Nome -->
						<label class="form-hori" for="name">Nome</label>
						<input class="form-hori" type="text" id="name" name="name" value="${item.name}"/>
					</div>
					<div class="form-hori">
						<!-- Cognome -->
						<label class="form-hori" for="surname">Cognome</label>
						<input class="form-hori" type="text" id="surname" name="surname" value="${item.surname}"/>
					</div>
					<div class="form-hori">
						<!-- Data di nascita -->
						<label class="form-hori" for="birthdate">Data di nascita</label>
						<input class="form-hori" type="text" id="birthdate" name="birthdate" value="${item.shortBirthDate}"/>
					</div>
					<div class="form-hori">
						<!-- La URL dell'avatar -->
						<label class="form-hori" for="imageurl">URL Immagine</label>
						<input class="form-hori" type="text" id="imageurl" name="imageurl" value="${item.imageUrl}"/>
					</div>
					<div class="form-hori">
						<!-- Frase di presentazione -->
						<label class="form-hori" for="introdesc">Frase di presentazione</label>
						<input class="form-hori" type="text" id="introdesc" name="introdesc" value="${item.introDesc}"/>
					</div>
					<div class="form-hori">
						<!-- Password (no autocompletamento) -->
						<label class="form-hori" for="password">Password</label>
						<input class="form-hori" type="password" id="password" name="password"/>
					</div>
					<div class="form-hori">
						<!-- Password (no autocompletamento) -->
						<label class="form-hori" for="password2">Conferma Password</label>
						<input class="form-hori" type="password" id="password2" name="password2"/>
					</div>
					<!-- Utilizzate i tipi di input corretti. -->
					<input type="submit" name="submit" class="block form-hori" value="Aggiorna"/>
				</form>
				<p>Mi sono stancato, <a href='profilo.html?deleteme'>Cancella il profilo</a></p>
			</article>
		</main>
	</body>
</html>
