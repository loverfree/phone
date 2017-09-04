<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户购物车面板</title>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="http://www.bootcss.com/p/buttons/css/buttons.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/userMenu.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/clickFont.js"></script>
 <script type="text/javascript">
/*     $(function(){
    	$("#pay").on("click",function(){
    		$.post("${pageContext.request.contextPath}/cart/payCart",
    				JSON.stringify([1,2,3]),
    				function(data){
    			
    		});
    	});
    }); */
 </script>
</head>
<style type="text/css">
#DQ,#title th{
	vertical-align: middle;
	text-align: center;
}
</style>
<body>
	<div class="Navi">
		<img id="shopLogo"
			onclick="window.location.href='${pageContext.request.contextPath }/product/brand/list'"
			src="${pageContext.request.contextPath }/resources/image/shopLogo.png">
	</div>
	<h2 style="margin-left: 2%">功能菜单</h2>
	<jsp:include page="userFunc.jsp"></jsp:include>

	<div class="panel panel-default"
		style="margin-left: 3%; width: 76%; height: auto; float: left; font-family: Microsoft Yahei">
		<div class="panel-heading">
			<h3 class="panel-title">购物车</h3>
		</div>
		<div class="panel-body">

			<a href="${pageContext.request.contextPath }/cart/emptyCart"></a>
			<c:if test="${empty carts }">购物车是空的呢~买点什么吧</c:if>
			<c:if test="${not empty carts }">
				<table class="table table-hover">
					<tr id="title" style="background-color: #F5F5F5">

						<th>商品图片</th>
						<th>商品名</th>
						<th>商品单价</th>
						<th>数量</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${carts }" var="cart">
						<input type="hidden" name="p_id" value="${cart.product.p_id }"
							class="p_id">
						<tr>

							<td width="75px"><img style="width: 100%; height: 10%"
								src="${pageContext.request.contextPath }/${cart.product.p_image}"></td>
							<td id="DQ">${cart.product.p_name }</td>
							<td id="DQ">${cart.product.p_price }</td>
							<td id="DQ" class="c_amount">${cart.c_amount }</td>
							<td id="DQ"><a
								href="${pageContext.request.contextPath }/cart/removeCart/${cart.product.p_id}">删除</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" align="right">总价：${o_total }</td>
					</tr>
					<tr>
						<td colspan="6"><a style="float: right; width: 9.1%"
							class="button button-highlight button-pill button-small" id="pay"
							href="${pageContext.request.contextPath }/cart/payCart/${o_total}">结算</a></td>
					</tr>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>