<%--
    Document   : login
    Created on : 05 mag 2018, 13:33:46
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
		<title>Login</title>
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
			<div class="nav-last nav-selected cornice"><a href="login.html">Login</a></div>
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
			<article>
				<div id="logotxt" class="clearfix centrato2">
					<img src="pics/logo.png"
						 alt="logo"
						 class="toleft shrink32px"
					/>
					<h1>Fast Press Writer</h1>
				</div>
				<div id="form1" class="cornice centrato intpad1">
					<form action="articoli.html" method="POST">
						<label class="block form-vert" for="username">Nome Utente</label>
						<input class="block form-vert" id="username" name="username" type="text" placeholder="nome utente"/>
						<label class="block form-vert" for="password">Password</label>
						<input class="block form-vert" id="password" name="password" type="password" placeholder="password"/>
						<input class="block form-vert" type="submit" value="Accedi"/>
					</form>
				</div>
			</article>
		</main>
	</body>
</html>