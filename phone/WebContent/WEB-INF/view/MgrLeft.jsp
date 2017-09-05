<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台管理左侧导航</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/mgrStyle.css" />
 <link href="http://cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
<div id="leftFunc">
		<a id="panTitle" class="pure-menu-heading" href="/">后台管理系统</a>
		<br>
		<ul id="func" class="pure-menu-list">
			<li class="pure-menu-item pure-menu-has-children pure-menu-allow-hover" style="border-top: 1px solid #AABAC8;">
				<a href="#" id="infoMenu" class="pure-menu-link" >信息查看</a>
				<ul id="infoMenu" class="pure-menu-children">
					<li class="pure-menu-item"><a href="${pageContext.request.contextPath }/bUser/list" class="pure-menu-link">用户信息</a></li>
					<li class="pure-menu-item"><a href="${pageContext.request.contextPath }/order/list" class="pure-menu-link">订单查询</a></li>
				</ul>
			</li>
			<li class="pure-menu-item pure-menu-has-children pure-menu-allow-hover">
				<a href="#" id="uptMenu" class="pure-menu-link">商品管理</a>
				<ul id="infoMenu" class="pure-menu-children">
					<li class="pure-menu-item">
					<a href="${pageContext.request.contextPath }/brand/list" 
					class="pure-menu-link">品牌管理</a></li>
					<li class="pure-menu-item">
					<a href="${pageContext.request.contextPath }/product/backlist" class="pure-menu-link">商品管理</a> class="pure-menu-link">商品管理</a></li>
				</ul>
			</li>
			<li
				class="pure-menu-item pure-menu-has-children pure-menu-allow-hover">
				<a href="#" id="menuLink1" class="pure-menu-link">数据统计</a>
				<ul id="infoMenu" class="pure-menu-children">
					<li class="pure-menu-item"><a href="#" class="pure-menu-link">销量</a></li>
					<li class="pure-menu-item"><a href="#" class="pure-menu-link">营业额</a></li>
				</ul>
			</li>
		</ul>
		<i class="fa fa-sign-out fa-3x" style="position: absolute;left: 1%;bottom: 3%" aria-hidden="true"></i>
	</div>
</body>
</html>