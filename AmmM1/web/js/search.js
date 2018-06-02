/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function createNewsElement(news)
{
	return $("<article>").attr("class", "centrato").html("\
	<a href='notizia.html?nid="+news.id+"'><h3 class='underline'>"+news.title+"</h3></a>\
	<div class='clearfix'>\
		<a href='notizia.html?nid="+news.id+"'><img src='"+news.imageUrl+"' alt='image' class='toleft shrink'>\
		</a>\
		<p class='newsdet'>di "+news.author.name+" "+news.author.surname+"\
			"+news.category+"\
			"+news.shortDate+"\
		</p>\
		<p class='newsdid'>"+news.shortDesc+"</p>\
	</div>");
}

function showNews(newsList){
	// get news list container
	var newsDiv = $("#main1");
	// clear the old news list
	$(newsDiv).empty();
	// add the new news list
	for (var n in newsList)
		$(newsDiv).append(createNewsElement(newsList[n]));
}

$(document).ready(function () {
	$("#search-txt").keyup(function (){
		alert("keyup" + $("#search-txt").val());
		$.ajax({
			url: "./filter.json",
			data: {
				q: $("#search-txt").val()
			},
			dataType: 'json',
			success: function (data, state) {
				showNews(data);
			},
			error: function (data, state) {
				/*var news = {
					id : 8,
					title : "Festa delle feste annunciata",
					imageUrl : "pics/partyhard.png",
					author : {
						name : "Pinco",
						surname : "Palloncino"
					},
					category : "[Cultura]",
					shortDate : "04/05/18",
					shortDesc : "GONNA PARTY HARD"
				};
				showNews([news, news, news]); //test
				*/
			} });
		//console.log($("#search").val()); //test
	});

});

