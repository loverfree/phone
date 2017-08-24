<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机商城</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/menuStyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

	$(function() {
		$('ul span#xiaomi').on('click',function(){
			$(this).next().slideToggle('fast',function(){
				
			})
		})
	})
</script>
</head>
<body>
<h2>我们的商品</h2>
<div id="leftPanel">
	<c:forEach items="${brands }" var="brand" begin="0" end="1" step="1">
		<li><a href = "./${brand.b_id}">${brand.b_name }</a></li>

	</c:forEach>
		<li class="menu"><span id="xiaomi">安卓Android</span>
			<ol style="display: none;">
		<c:forEach items="${brands }" var="brand" begin="2" end="4" step="1">
				<li><a href = "./${brand.b_id}">${brand.b_name }</a></li>
		</c:forEach>
			</ol>
		</li>
		<li class="menu"><span id="xiaomi">小米</span>
			<ol style="display: none;">
				<li>小米5</li>
				<li>小米Mix</li>
			</ol>
		</li>
	</ul>
</div>
</body>
</html>