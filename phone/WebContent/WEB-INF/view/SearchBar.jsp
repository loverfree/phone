<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索框</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/menuStyle.css" />
<link rel="stylesheet" href="http://www.bootcss.com/p/buttons/css/buttons.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
		<div class="dropdown" style="position: absolute; top: 7.5%; transform: translateY(-50%); margin-left: 74%;width: 270px">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				我的信息
				<span class="caret"></span>
			</button>
		<ul class="dropdown-menu"
			style="font-size: 15px;white-space: nowrap;overflow: hidden;line-height: 300%;padding-left: 20px;padding-right: 2px;width: 270px">
			<li>
				<div class="curuser">用户名</div> &nbsp;&nbsp;&nbsp;&nbsp;<span
				style="display: inline-block; vertical-align: middle; font-size: 18px">${sessionScope.curuser.u_nickname}
			</span>
			</li>
			<li><span>查看订单</span> </li>
			<li><span><a href="../../user/userUpdate"> 个人信息</a> </span></li>
			<li>
				<form action="${pageContext.request.contextPath }/user/logout"
					method="post">
					<input type="submit" class="button button-pill button-tiny"
						value="注销" >
				</form>
			</li>
		</ul>
	</div>
</body>
</html>