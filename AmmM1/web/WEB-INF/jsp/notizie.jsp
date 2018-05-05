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
			<c:forEach items="${newsList}" var="item">
			<article class="centrato">
				<a href="notizia.html?nid=${item.id}" target="blank"><h3 class="underline">${item.title}</h3></a>
				<div class="clearfix">
					<a href="notizia.html?nid=${item.id}" target="blank"><img src="${item.imageUrl}"
						 alt="image"
						 class="toleft shrink"
						 >
					</a>
					<p class="newsdet">di ${item.author.name} ${item.author.surname}
						${item.category}
						${item.shortDate}
					</p>
					<p class="newsdid">${item.shortDesc}</p>
				</div>
			</article>
			</c:forEach>
		</main>
	</body>
</html>
