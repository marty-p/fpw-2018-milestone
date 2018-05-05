<%--
    Document   : scriviArticolo
    Created on : 05 mag 2018, 13:34:39
    Author     : Marty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
	<head>
		<title>Nuovo/Modifica Articoli</title>
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
		<nav id="nav1" class="navbar cornice">
			<div class="nav-main cornice"><a href="#">Fast Press Writer</a></div>
			<div class="nav cornice"><a href="notizia.html">Notizie</a></div>
			<div class="nav cornice"><a href="#">Profilo</a></div>
			<div class="nav nav-selected cornice"><a href="articoli.html">I miei Articoli</a></div>
			<div class="nav-last cornice"><a href="login.html">Logout</a></div>
		</nav>
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
			<article class="centrato2">
				<h1>Scrivi un Articolo</h1>
				<form action="articoli.html" method="POST" class="form-hori">
					<div class="form-hori">
						<!-- Un titolo -->
						<label class="form-hori" for="titolo">Titolo</label>
						<input class="form-hori" type="text" id="titolo"/>
					</div>
					<div class="form-hori">
						<!-- La data di pubblicazione -->
						<label class="form-hori" for="data">Data</label>
						<input class="form-hori" type="text" id="data"/>
					</div>
					<div class="form-hori">
						<!-- La URL dell'immagine descrittiva -->
						<label class="form-hori" for="immagine">Immagine</label>
						<input class="form-hori" type="text" id="immagine"/>
					</div>
					<div class="form-hori">
						<!-- La didascalia per l'immagine -->
						<label class="form-hori" for="didascalia">Didascalia</label>
						<input class="form-hori" type="text" id="didascalia"/>
					</div>
					<div class="form-hori">
						<!-- Il testo dell'articolo -->
						<label class="form-hori" for="testo">Testo</label>
						<textarea class="form-hori" id="testo"></textarea>
					</div>
					<div class="form-hori">
						<!-- Il testo dell'articolo -->
						<span class="form-hori">Categoria</span>
						<div id="categoria">
							<div class="block">
								<input type="checkbox" id="Politica" checked />
								<label for="Politica">Politica</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Cronaca"/>
								<label for="Cronaca">Cronaca</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Esteri"/>
								<label for="Esteri">Esteri</label>
								<label for="Esteri">Esteri</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Economia"/>
								<label for="Economia">Economia</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Sport"/>
								<label for="Sport">Sport</label>
							</div>
							<div class="block">
								<input type="checkbox" id="Cultura" checked />
								<label for="Cultura">Cultura</label>
							</div>
						</div>
					</div>
					<!-- Utilizzate i tipi di input corretti. -->
					<input type="submit" class="block form-hori" value="Salva"/>
				</form>
			</article>
		</main>
	</body>
</html>