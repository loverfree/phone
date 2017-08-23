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
	<form action="./fuzzy" method="post">
		<input class="search" type="text" name = "pname"/>
	<input type="submit" value="搜索" class="submit">
	</form>
</div>
<h2>我们的商品</h2>
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
<div id="rightPanel">
<table border="0" cellspacing="5px" width="100%">
	<%-- 	<c:forEach items="${brands }" var="brand" begin="0" end="2" step="1">
		<c:if test="${brand.count }%3==0"><br></c:if>
		 <tr>
			<td><img src ="${pageContext.request.contextPath }/${brand.b_logo}"></td>
		</tr>
		<tr>
			<td><a href = "./${brand.b_id}/list">${brand.b_name }</a></td>
		</tr>
		</c:forEach> --%>
	<tr>
	 <c:forEach items="${products }" var="product" begin="0" end="2" step="1">
	 <tr>
		<td><img src ="${pageContext.request.contextPath }/${product.images[0].i_path}"></td>
	</tr>
	<tr>	
		<td><a href = "../${product.p_id}/details">${product.p_name } 
			&nbsp;&nbsp;&nbsp;&nbsp;${product.p_price }元
		</a></td>
	</c:forEach>
	</tr>

</table>
</div>
</body>
</html>