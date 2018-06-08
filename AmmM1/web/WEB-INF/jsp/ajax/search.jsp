<%-- 
    Document   : search
    Created on : 8-giu-2018, 17.19.25
    Author     : Marty
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<json:object>
	<json:array name="author" var="item" items="${authorList}">
		<json:object>
			<json:property name="id" value="${item.id}"/>
			<json:property name="name" value="${item.name}"/>
			<json:property name="surname" value="${item.surname}"/>
			<json:property name="imageUrl" value="${item.imageUrl}"/>
		</json:object>
	</json:array>
	<json:array name="category" var="item" items="${categoryList}">
		<json:object>
			<json:property name="id" value="${item.id}"/>
			<json:property name="name" value="${item.name}"/>
		</json:object>
	</json:array>
</json:object>
