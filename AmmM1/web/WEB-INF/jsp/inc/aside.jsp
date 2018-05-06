<%-- 
    Document   : aside
    Created on : 5-mag-2018, 15.31.00
    Author     : Marty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
		<aside id="aside1" class="cornice">
			<section id="cerca" class="cornice intpad1">
				<h3><label class="centrato block" for="search-txt">Cerca</label></h3>
				<input class="block form-vert" id="search-txt" name="search-txt" type="text" placeholder="..."/>
			</section>
			<section id="categorie" class="cornice">
				<h3 class="centrato hide-on-med-and-down">Categorie</h3>
				<a href="#categorie" class="hide-on-large-only">Categorie</a>
				<ul class="centrato hide-on-med-and-down">
					<li><a href="notizie.html">Tutte</a></li>
					<li><a href="notizie.html?cid=0">Politica</a></li>
					<li><a href="notizie.html?cid=1">Cronaca</a></li>
					<li><a href="notizie.html?cid=2">Esteri</a></li>
					<li><a href="notizie.html?cid=3">Economia</a></li>
					<li><a href="notizie.html?cid=4">Sport</a></li>
					<li><a href="notizie.html?cid=5">Cultura</a></li>
				</ul>
			</section>
			<section id="autori" class="cornice">
				<h3 class="centrato hide-on-med-and-down">Autori</h3>
				<a href="#autori" class="hide-on-large-only">Autori</a>
				<ul class="centrato hide-on-med-and-down">
					<li class="icon1 underline"><a href="profilo.html?uid=1">Pinco Pallino</a></li>
					<li class="icon2 underline"><a href="profilo.html?uid=2">Pinco Pallone</a></li>
					<li class="icon3 underline"><a href="profilo.html?uid=3">Pinco Palloncino</a></li>
				</ul>
			</section>
		</aside>
