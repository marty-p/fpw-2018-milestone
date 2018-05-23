<%--
    Document   : scriviArticolo
    Created on : 05 mag 2018, 13:34:39
    Author     : Marty
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
				<c:if test="${updated==true && item!=null}"><p>L'Articolo #${item.id} è stato aggiornato.</p></c:if>

				<c:choose>
				<c:when test="${item==null}">
				<h1>Scrivi un Articolo</h1>
				</c:when>
				<c:otherwise>
				<h1>Modifica Articolo #${item.id}</h1>
				</c:otherwise>
				</c:choose>

				<form action="scriviArticolo.html<c:if test="${param.edit!=null}">?edit=${param.edit}</c:if>" method="POST" class="form-hori">
					<div class="form-hori">
						<!-- Un titolo -->
						<label class="form-hori" for="title">Titolo</label>
						<input class="form-hori" type="text" id="title" name="title" value="${item.title}"/>
					</div>
					<div class="form-hori">
						<!-- La data di pubblicazione -->
						<label class="form-hori" for="date">Data</label>
						<input class="form-hori" type="date" id="date" name="date" value="${item.inputDate}"/>
					</div>
					<div class="form-hori">
						<!-- La URL dell'immagine descrittiva -->
						<label class="form-hori" for="imageUrl">Immagine</label>
						<input class="form-hori" type="text" id="imageUrl" name="imageUrl" value="${item.imageUrl}"/>
					</div>
					<div class="form-hori">
						<!-- La didascalia per l'immagine -->
						<label class="form-hori" for="imageDesc">Didascalia</label>
						<input class="form-hori" type="text" id="imageDesc" name="imageDesc" value="${item.imageDesc}"/>
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
							<c:forEach items="${newsCategories}" var="myEnum" varStatus="loopStatus">
							<div class="block">
								<input type="checkbox" id="${myEnum}" name="${myEnum}" value="${myEnum}"
										<c:if test="${fn:containsIgnoreCase(item.category, myEnum.name)}">checked</c:if>
								/>
								<label for="${myEnum}">${myEnum.name}</label>
							</div>
							</c:forEach>
						</div>
					</div>
					<!-- Utilizzate i tipi di input corretti. -->
					<input type="submit" name="submit" class="block form-hori" value="Salva"/>
				</form>
			</article>
		</main>
	</body>
</html>
