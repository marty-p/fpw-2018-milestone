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
			<article class="centrato">
				<div id='comments' class='cornice'>
					<h1>Commenti</h1>
					<c:forEach items="${comments}" var="comment">
						<div class='clearfix'>
							<form action="notizia.html?nid=${param.nid}" method="POST">
							<img src='${comment.author.imageUrl}' alt='avatar' class='shrink16px left'>
							<span class="newsdid"><a href='profilo.html?uid=${comment.author.id}'>${comment.author.name} ${comment.author.surname}</a>:</span>
							<span class="newsdet"><c:out value="${comment.desc}"/></span>
							<c:if test="${sessionScope.category=='AUTHOR' && sessionScope.id==item.author.id}">
								<input type="hidden" name="commentId" value="${comment.id}"/>
								<button type="submit" name="comment-delete-submit" class="btn-link right"><img class="shrink16px" src="pics/trashbin.png" alt="delete"></button>
							</c:if>
							</form>
						</div>
					</c:forEach>
					<c:if test="${sessionScope.loggedIn=='true'}">
						<div id="form1" class="cornice intpadt3">
							<form action="notizia.html?nid=${param.nid}" method="POST">
								<input class="block form-vert" id="comment" name="comment" type="text" placeholder="Scrivi un commento..."/>
								<input class="block form-vert" type="submit" name="comment-submit" value="Commenta"/>
							</form>
						</div>
					</c:if>
				</div>
			</article>
			</c:if>
		</main>
	</body>
</html>
