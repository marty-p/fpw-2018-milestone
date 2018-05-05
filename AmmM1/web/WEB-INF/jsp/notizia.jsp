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
			<article class="centrato">
				<h3 class="underline">Autostrada A1 chiusa per neve</h3>
				<div class="clearfix">
					<img src="pics/snowman.png"
						 alt="pupazzo"
						 class="toleft shrink"
						 >
					<p class="newsdet">cronaca</p>
					<p class="newsdet">2/3/18</p>
					<p class="newsdet">di Pinco Pallino</p>
					<p class="newsdid">Pupazzi in autostrada</p>
				</div>
				<div class="newstxt">
					Lorem ipsum dolor sit amet, consectetur adipisci elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua.
					Ut enim ad minim veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.
					Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
					Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
				</div>
			</article>
		</main>
	</body>
</html>
