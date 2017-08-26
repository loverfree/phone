$(function() {
	$(".search").hover(function() {
		$(this).toggleClass('shadowOut');
	});
	
	$("div#userMenu").mouseover(function() {
		$(this).css("background-color","#EDEDED");
	});
	
	$("div#userMenu").mouseout(function() {
		$(this).css("background-color","white");
	});
})