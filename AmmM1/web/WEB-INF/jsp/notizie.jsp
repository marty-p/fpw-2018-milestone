<%-- 
    Document   : notizie
    Created on : 5-mag-2018, 17.25.33
    Author     : Marty
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<!-- HEAD START -->
	<c:set var="title" value="Notizie" scope="request"/>
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
			</article>
			<article class="centrato">
				<h3 class="underline">Autostrada B1 chiusa per palle</h3>
				<div class="clearfix">
					<img src="pics/snowman.png"
						 alt="pupazzo"
						 class="toleft shrink"
						 >
					<p class="newsdet">cronaca</p>
					<p class="newsdet">3/4/18</p>
					<p class="newsdet">di Pinco Pallone</p>
					<p class="newsdid">Palle in autostrada</p>
				</div>
			</article>
		</main>
	</body>
</html>
