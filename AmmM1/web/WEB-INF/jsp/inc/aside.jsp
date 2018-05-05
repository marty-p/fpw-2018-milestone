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
