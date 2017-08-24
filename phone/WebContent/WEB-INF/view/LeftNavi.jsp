<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/menuStyle.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/my.js"></script>
<title>左边的导航栏</title>
</head>
<body>
<div id="leftPanel">
	<ul style="line-height:400%">
	 <c:forEach items="${brands }" var="brand" begin="0" end="1" step="1">
		<li><a href = "./${brand.b_id}/list">${brand.b_name }</a></li>

	</c:forEach>
		<li class="menu"><span id="xiaomi">安卓Android</span>
			<ol style="display: none;">
		<c:forEach items="${brands }" var="brand" begin="2" end="4" step="1">
				<li><a href = "./${brand.b_id}/list">${brand.b_name }</a></li>
		</c:forEach>
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
</body>
</html>