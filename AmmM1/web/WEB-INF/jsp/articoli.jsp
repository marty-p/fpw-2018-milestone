<%--
    Document   : articoli
    Created on : 05 mag 2018, 13:33:11
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
	<c:set var="title" value="I Miei Articoli" scope="request"/>
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
				<h1 class="underline">I miei Articoli</h1>
				<table class="articolo">
					<tr>
						<th>Data</th>
						<th>Titolo</th>
						<th>Modifica</th>
						<th>Cancella</th>
					</tr>
					<tr>
						<td>23/1/18</td>
						<td>I fantastici astici</td>
						<td><a href="#"><img class="shrink16px" src="pics/pencil.png" alt="edit"/></a></td>
						<td><a href="#"><img class="shrink16px" src="pics/trashbin.png" alt="delete"/></a></td>
					</tr>
					<tr class="evenrow">
						<td>25/2/18</td>
						<td>I castori rosicanti</td>
						<td><a href="#"><img class="shrink16px" src="pics/pencil.png" alt="edit"/></a></td>
						<td><a href="#"><img class="shrink16px" src="pics/trashbin.png" alt="delete"/></a></td>
					</tr>
					<tr>
						<td>27/3/18</td>
						<td>Holy moly</td>
						<td><a href="#"><img class="shrink16px" src="pics/pencil.png" alt="edit"/></a></td>
						<td><a href="#"><img class="shrink16px" src="pics/trashbin.png" alt="delete"/></a></td>
					</tr>
				</table>
				<form action="scriviArticolo.html" method="POST">
					<input type="submit" class="block form-vert" value="Nuovo Articolo"/>
				</form>
			</article>
		</main>
	</body>
</html>
