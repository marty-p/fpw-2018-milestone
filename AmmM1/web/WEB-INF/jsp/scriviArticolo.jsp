<%--
    Document   : scriviArticolo
    Created on : 05 mag 2018, 13:34:39
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
	<c:set var="title" value="Nuovo/Modifica Articoli" scope="request"/>
	<jsp:include page="/WEB-INF/jsp/inc/head.jsp"/>
	<!-- HEAD END -->
	<body>
		<!-- NAV START -->
        <c:set var="page" value="articoli" scope="request"/>
        <jsp:include page="/WEB-INF/jsp/inc/nav.jsp"/>
		<!-- NAV END -->

		<!-- ASIDE START -->
        <jsp:include page="/WEB-INF/jsp/inc/aside.jsp"/>
		<!-- ASIDE END -->

		<main id="main1" class="cornice">
			<article class="centrato2">
				<h1>Scrivi un Articolo</h1>
				<form action="articoli.html" method="POST" class="form-hori">
					<div class="form-hori">
						<!-- Un titolo -->
						<label class="form-hori" for="titolo">Titolo</label>
						<input class="form-hori" type="text" id="titolo"/>
					</div>
					<div class="form-hori">
						<!-- La data di pubblicazione -->
						<label class="form-hori" for="data">Data</label>
						<input class="form-hori" type="text" id="data"/>
					</div>
					<div class="form-hori">
						<!-- La URL dell'immagine descrittiva -->
						<label class="form-hori" for="immagine">Immagine</label>
						<input class="form-hori" type="text" id="immagine"/>
					</div>
					<div class="form-hori">
						<!-- La didascalia per l'immagine -->
						<label class="form-hori" for="didascalia">Didascalia</label>
						<input class="form-hori" type="text" id="didascalia"/>
					</div>
					<div class="form-hori">
						<!-- Il testo dell'articolo -->
						<label class="form-hori" for="testo">Testo</label>
						<textarea class="form-hori" id="testo"></textarea>
					</div>
					<div class="form-hori">
						<!-- Il testo dell'articolo -->
						<span class="form-hori">Categoria</span>
						<div id="categoria">
							<div class="block">
								<input type="checkbox" id="Politica" checked />
								<label for="Politica">Politica</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Cronaca"/>
								<label for="Cronaca">Cronaca</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Esteri"/>
								<label for="Esteri">Esteri</label>
								<label for="Esteri">Esteri</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Economia"/>
								<label for="Economia">Economia</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Sport"/>
								<label for="Sport">Sport</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Cultura" checked />
								<label for="Cultura">Cultura</label>
							</div>
						</div>
					</div>
					<!-- Utilizzate i tipi di input corretti. -->
					<input type="submit" class="block form-hori" value="Salva"/>
				</form>
			</article>
		</main>
	</body>
</html>
