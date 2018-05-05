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
	<head>
		<title>I miei Articoli</title>
		<meta charset="UTF-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link rel="stylesheet" href="style.css"/>
		<link rel="stylesheet" media="(min-width: 1024px)" href="style-min-1024px.css"/>
		<link rel="stylesheet" media="(max-width: 480px)" href="style-max-480px.css"/>
		<!--tra 480 e 1024-->
		<!-- <link rel="stylesheet" media="(min-width: 480px)" href="style-min-1024px.css"/> -->
		<link rel="stylesheet" media="(max-width: 1024px)" href="style-max-480px.css"/>
		<meta name="description" content="Milestone1"/>
		<meta name="keywords" content="HTML,CSS"/>
		<meta name="author" content="Martino Pinna"/>
	</head>
	<body>
		<!-- NAV START -->
        <c:set var="page" value="articoli" scope="request"/>
        <jsp:include page="inc/nav.jsp"/>
		<!-- NAV END -->

		<aside id="aside1" class="cornice">
			<section id="cerca" class="cornice intpad1">
				<h3><label class="centrato block" for="search-txt">Cerca</label></h3>
				<input class="block form-vert" id="search-txt" name="search-txt" type="text" placeholder="..."/>
			</section>
			<section id="categorie" class="cornice">
				<h3 class="centrato">Categorie</h3>
				<a href="#autori">Categorie</a>
				<ul class="centrato">
					<li>Politica</li>
					<li>Cronaca</li>
					<li>Esteri</li>
					<li>Economia</li>
					<li>Sport</li>
					<li>Cultura</li>
				</ul>
			</section>
			<section id="autori" class="cornice">
				<h3 class="centrato">Autori</h3>
				<a href="#autori">Autori</a>
				<ul class="centrato">
					<li class="icon1 underline">Pinco Pallino</li>
					<li class="icon2 underline">Pinco Pallone</li>
					<li class="icon3 underline">Pinco Palloncino</li>
				</ul>
			</section>
		</aside>
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
