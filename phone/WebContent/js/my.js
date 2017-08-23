	
	$(function() {

	    $('ul span#xiaomi').on('click', function() {
			/* 左边导航栏滑动菜单 */
			$(this).next().slideToggle('fast', function() {
			})
		})

 		$('.search').mouseover(function() {
			/* 鼠标移动,搜索框产生阴影 */
			$(this).animate({boxShadow: '0 0 50px #EDEDED'})
		}) 
		
 		$('.search').mouseout(function() {
			$(this).animate({boxShadow: '0 0 0.1px #EDEDED'})
		}) 
		
 		$('a').mouseover(function() {
			/* 鼠标移动,改变链接颜色 */
			$(this).css("color", "#87CEFA")
		}) 
		
 		$('a').mouseout(function() {
			$(this).css("color", "black")
		}) 

	})