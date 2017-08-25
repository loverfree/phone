$(function() {

		$('a').mouseover(function() {
			/* 鼠标移动,改变链接颜色 */
			$(this).css("color", "#87CEFA")
		}) 
		
 		$('a').mouseout(function() {
			$(this).css("color", "black")
		}) 

})