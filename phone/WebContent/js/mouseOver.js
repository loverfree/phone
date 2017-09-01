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
	
	$("div#userMenu").mouseover(function() {
		$("div.dropDown").css("visibility","visible");
	});
	
	$("div.dropDown").focus(function() {
		$(this).css("visibility","hidden");
	});
	
	 $("div.curuser").mouseover(function(){  
         var wValue=1.05 * $(this).width();  
         var hValue=1.05 * $(this).height();        
         $(this).animate({width: wValue,  
                         height: hValue,  
                         left:("-"+(0.1 * $(this).width())/2),  
                         top:("-"+(0.1 * $(this).height())/2)}, 1000);
                         fontSize: '20px';
     }).mouseout(function(){  
         $(this).animate({width: "20%",  
                                      height: "32",  
                                      left:"0px",  
                                      top:"0px"}, 1000 );  
     });  
})