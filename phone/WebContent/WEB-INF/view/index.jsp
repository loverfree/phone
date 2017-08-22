<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机商城</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/menuStyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/animate-shadow.js"></script>
<script type="text/javascript">

	$(function() {

	    $('ul span#xiaomi').on('click', function() {
			$(this).next().slideToggle('fast', function() {
			})
		})

 		$('.search').mouseover(function() {
			/* $(this).css("box-shadow", " 0 0 1px #000") */
			$(this).animate({boxShadow: '0 0 50px #EDEDED'})
		}) 
		
 		$('.search').mouseout(function() {
			/* $(this).css("box-shadow", " 0 0 1px #000") */
			$(this).animate({boxShadow: '0 0 0.1px #EDEDED'})
		}) 

	})
</script>
</head>
<body>
<div id="searchBar"><img id="shopLogo" src="${pageContext.request.contextPath }/resources/image/shopLogo.png">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input class="search" type="text"/></div>
<h2>我们的商品</h2>
<div id="leftPanel">
	<ul style="line-height:400%">
		<li>所有手机</li>
		<li>苹果iPhone</li>
		<li class="menu"><span id="xiaomi">安卓Android</span>
			<ol style="display: none;">
				<li>三星</li>
				<li>小米</li>
				<li>OPPO</li>
			</ol>
		</li>
		<li class="menu"><span id="xiaomi">小米MI</span>
			<ol style="display: none;">
				<li>小米5</li>
				<li>小米Mix</li>
			</ol>
		</li>
	</ul>
</div>
<div id="rightPanel">
<table border="0" cellspacing="5px" width="100%">
	<tr>
		<td><img src="${pageContext.request.contextPath }/resources/image/logo/All.png"></td>
		<td><img src="${pageContext.request.contextPath }/resources/image/logo/Apple.png"></td>
		<td><img src="${pageContext.request.contextPath }/resources/image/logo/Xiaomi.png"></td>
	</tr>
	<tr>
		<td>所有手机</td><td>苹果</td><td>小米</td>
	</tr>
	<tr>
		<td><img src="${pageContext.request.contextPath }/resources/image/logo/samsung.jpg"></td>
		<td><img src="${pageContext.request.contextPath }/resources/image/logo/oppo.png"></td>
		<td><img src="${pageContext.request.contextPath }/resources/image/logo/tools.ico"></td>
	</tr>
	<tr>
		<td>三星</td>
		<td>OPPO</td>
		<td>配件</td>
	</tr>
</table>
</div>
</body>
</html>