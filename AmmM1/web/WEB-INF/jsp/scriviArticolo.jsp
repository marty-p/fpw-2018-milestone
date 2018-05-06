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
				<c:choose>
				<c:when  test="${item==null}">
				<h1>Scrivi un Articolo</h1>
				</c:when>
				<c:otherwise>
				<h1>Modifica Articolo #${item.id}</h1>
				</c:otherwise>
				</c:choose>
				<form action="" method="POST" class="form-hori">
					<div class="form-hori">
						<!-- Un titolo -->
						<label class="form-hori" for="title">Titolo</label>
						<input class="form-hori" type="text" id="title" name="title" value="${item.title}"/>
					</div>
					<div class="form-hori">
						<!-- La data di pubblicazione -->
						<label class="form-hori" for="date">Data</label>
						<input class="form-hori" type="text" id="date" id="date" value="${item.shortDate}"/>
					</div>
					<div class="form-hori">
						<!-- La URL dell'immagine descrittiva -->
						<label class="form-hori" for="imageurl">Immagine</label>
						<input class="form-hori" type="text" id="imageurl" name="imageurl" value="${item.imageUrl}"/>
					</div>
					<div class="form-hori">
						<!-- La didascalia per l'immagine -->
						<label class="form-hori" for="imagedesc">Didascalia</label>
						<input class="form-hori" type="text" id="imagedesc" name="imagedesc" value="${item.imageDesc}"/>
					</div>
					<div class="form-hori">
						<!-- Il testo dell'articolo -->
						<label class="form-hori" for="desc">Testo</label>
						<textarea class="form-hori" id="desc" name="desc">${item.desc}</textarea>
					</div>
					<div class="form-hori">
						<!-- Il testo dell'articolo -->
						<span class="form-hori">Categoria</span>
						<div id="categoria">
							<div class="block">
								<input type="checkbox" id="Politica" name="Politica" <c:if test="${item.category=='POLITICA'}">checked</c:if> />
								<label for="Politica">Politica</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Cronaca" name="Cronaca" <c:if test="${item.category=='CRONACA'}">checked</c:if> />
								<label for="Cronaca">Cronaca</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Esteri" name="Esteri" <c:if test="${item.category=='ESTERI'}">checked</c:if> />
								<label for="Esteri">Esteri</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Economia" name="Economia" <c:if test="${item.category=='ECONOMIA'}">checked</c:if> />
								<label for="Economia">Economia</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Sport" name="Sport" <c:if test="${item.category=='SPORT'}">checked</c:if> />
								<label for="Sport">Sport</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Cultura" name="Cultura" <c:if test="${item.category=='CULTURA'}">checked</c:if> />
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
