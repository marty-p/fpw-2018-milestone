<%--
    Document   : notizia
    Created on : 05 mag 2018, 13:34:10
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
	<c:set var="title" value="Lettura Articolo" scope="request"/>
	<jsp:include page="/WEB-INF/jsp/inc/head.jsp"/>
	<!-- HEAD END -->
	<body>
		<!-- NAV START -->
        <c:set var="page" value="notizia" scope="request"/>
        <jsp:include page="/WEB-INF/jsp/inc/nav.jsp"/>
		<!-- NAV END -->

		<!-- ASIDE START -->
        <jsp:include page="/WEB-INF/jsp/inc/aside.jsp"/>
		<!-- ASIDE END -->

		<main id="main1" class="cornice">
			<c:if test="${item!=null}">
			<article class="centrato">
				<h3 class="underline">${item.title}</h3>
				<div class="clearfix">
					<img src="${item.imageUrl}"
						 alt="image"
						 class="toleft shrink"
						 >
					<p class="newsdet">${item.category}</p>
					<p class="newsdet">${item.shortDate}</p>
					<p class="newsdet">di ${item.author.name} ${item.author.surname}</p>
					<p class="newsdid">${item.imageDesc}</p>
				</div>
				<div class="newstxt">${item.desc}</div>
			</article>
			</c:if>
		</main>
	</body>
</html>
