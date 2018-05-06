<%-- 
    Document   : profiloView
    Created on : 6-mag-2018, 7.47.26
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
        <c:set var="page" value="articoli" scope="request"/>
        <jsp:include page="/WEB-INF/jsp/inc/nav.jsp"/>
		<!-- NAV END -->

		<!-- ASIDE START -->
        <jsp:include page="/WEB-INF/jsp/inc/aside.jsp"/>
		<!-- ASIDE END -->

		<main id="main1" class="cornice">
			<article class="centrato">
				<h1>${item.name} ${item.surname}</h1>
				<div class="clearfix">
					<img
						<c:choose>
							<c:when test="${item.imageUrl==null}">src="pics/noavatar.png"</c:when>
							<c:otherwise>src="${item.imageUrl}"</c:otherwise>
						</c:choose>
						alt="avatar"
						class="left shrink150px"
					>
					<p class="newsdet">${item.shortBirthDate}</p>
				</div>
				<div class="newstxt">${item.introDesc}</div>
				<c:if  test="${updated==true}">
				<h3>Il profilo è stato aggiornato.</h3>
				</c:if>
			</article>
		</main>
	</body>
</html>
