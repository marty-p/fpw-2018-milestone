/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function createCategoryElement(elem)
{
	return "<li><a href='notizie.html?cid="+elem.id+"'>"+elem.name+"</a></li>";
}

function createAuthorElement(elem)
{
	return "<li class='underline'>"+
	"<img src='"+elem.imageUrl+"' alt='avatar'>"+
	"<a href='notizie.html?uid="+elem.id+"'>"+elem.name+" "+elem.surname+"</a>"+
	"</li>";
}

function showNewsCategory(ncList){
	// get news list container
	var cList = $("#category-list");
	var aList = $("#author-list");
	// clear the old news list
	$(cList).empty();
	$(aList).empty();
	// add the new news list
	for (var i in ncList.category)
		$(cList).append(createCategoryElement(ncList.category[i]));
	for (var i in ncList.author)
		$(aList).append(createAuthorElement(ncList.author[i]));
}

$(document).ready(function () {
	$("#search-txt").keyup(function (){
		// alert("keyup '" + $("#search-txt").val() + "'");
		$.ajax({
			url: "./filter.json",
			data: {
				q: $("#search-txt").val()
			},
			dataType: 'json',
			success: function (data, state) {
				showNewsCategory(data);
			},
			error: function (data, state) {
				/* TEST CODE
				var ncList = {
					author : [
						{
							id : 1,
							name : "Pinco",
							surname : "Pallino",
							imageUrl : "pics/icon1.png"
						},
						{
							id : 3,
							name : "Pinco",
							surname : "Palloncino",
							imageUrl : "pics/icon3.png"
						}
					],
					category: [
						{
							id : 0,
							name : "Politica"
						},
						{
							id : 3,
							name : "Economia"
						},
						{
							id : 5,
							name : "Cultura"
						}
					]
				};
				showNewsCategory(ncList);
				/**/
			} });
		// console.log($("#search").val());
	});

});

