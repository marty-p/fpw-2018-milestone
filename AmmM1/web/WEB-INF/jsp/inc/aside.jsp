<%-- 
    Document   : aside
    Created on : 5-mag-2018, 15.31.00
    Author     : Marty
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<c:forEach items="${newsCategories}" var="item" varStatus="loopStatus">
					<li><a href="notizie.html?cid=${loopStatus.index}">${item.name}</a></li>
					</c:forEach>
				</ul>
			</section>
			<section id="autori" class="cornice">
				<h3 class="centrato hide-on-med-and-down">Autori</h3>
				<a href="#autori" class="hide-on-large-only">Autori</a>
				<ul class="centrato hide-on-med-and-down">
					<c:forEach items="${authorList}" var="item" varStatus="loopStatus">
					<li class="icon1 underline"><a href="profilo.html?uid=${item.id}">${item.name} ${item.surname}</a></li>
					</c:forEach>
				</ul>
			</section>
		</aside>
