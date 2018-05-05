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
	<head>
		<title>Lettura Articolo</title>
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
        <c:set var="page" value="notizia" scope="request"/>
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
