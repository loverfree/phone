<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索框</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/menuStyle.css" />
<body>
<div id="searchBar"><img id="shopLogo" onclick="window.location.href='brand'" src="${pageContext.request.contextPath }/resources/image/shopLogo.png">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<form action="../1/list" method="post">
		<input class="search" type="text" name = "pname" />
	<input type="submit" value="搜索" class="submit">
	</form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/mouseOver.js"></script>
</body>
</html>