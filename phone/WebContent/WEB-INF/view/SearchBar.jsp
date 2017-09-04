<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索框</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/menuStyle.css" />
<link rel="stylesheet" href="http://www.bootcss.com/p/buttons/css/buttons.css">
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.min.js"></script>
<script src="https://purecss.io/js/menus.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/mouseOver.js"></script>
<body>
<div id="searchBar"><img id="shopLogo" onclick="window.location.href='${pageContext.request.contextPath }/product/brand/list'" src="${pageContext.request.contextPath }/resources/image/shopLogo.png">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<form action="../fuzzy/list" method="post">
		<input class="search" type="text" name = "pname" />
	<input type="submit" value="搜索" class="submit">
	</form>
<%-- 	<div id="userMenu">
		<img id="userMenu" alt="当前状态" src="${pageContext.request.contextPath }/resources/image/uMenu.png">
	</div> --%>
</div>
<%-- 	<div class="dropDown">
		<ul class="dropDown">
			<li>
				<div class="curuser">当前用户</div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span
				style="display: inline-block; vertical-align: middle; font-size: 18px">${sessionScope.curuser.u_nickname}
			</span>
			</li>
			<li><span>查看订单 </span></li>
			<li><span><a href="../../user/userUpdate"> 个人信息</a> </span></li>
			<li>
				<form action="${pageContext.request.contextPath }/user/logout"
					method="post">
					<input type="submit" class="button button-pill button-tiny"
						value="注销" style="vertical-align: middle; position: absolute;">
				</form>
			</li>
		</ul>

	</div> --%>
	<div class="pure-menu pure-menu-horizontal"
		style="position: absolute; top: 7.5%; transform: translateY(-50%); margin-left: 74%; width: 270px;">

		<ul class="pure-menu-list" style="line-height: 300%;">
			<li
				class="pure-menu-item pure-menu-has-children pure-menu-allow-hover">
				<a href="#" id="menuLink1" class="pure-menu-link">我的信息</a>
				<ul class="pure-menu-children" style="border: 2px solid #A6C0D6;width: 240px">
					<li class="pure-menu-item"><div class="curuser" style="margin-left: 5%">用户名</div>
						&nbsp;&nbsp;&nbsp;&nbsp;<span
						style="display: inline-block; vertical-align: middle; font-size: 18px">${curuser.u_nickname}
					</span></li>
					<li class="pure-menu-item"><a href="#" class="pure-menu-link"><span>查看订单</span></a></li>
					<li class="pure-menu-item"><a href="../../user/userUpdate"
						class="pure-menu-link">个人信息</a></li>
					<li class="pure-menu-item">
						<form action="${pageContext.request.contextPath }/user/logout"
							method="post">
							<input type="submit" class="button button-pill button-small"
								value="注销">
						</form>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</body>
</html>