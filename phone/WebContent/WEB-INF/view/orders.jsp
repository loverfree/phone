<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单结算页面</title>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<link rel="stylesheet" href="http://www.bootcss.com/p/buttons/css/buttons.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/userMenu.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/clickFont.js"></script>
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

	<div class="panel panel-default"
		style="margin-top: 3%; margin-left: 20%; width: 60%">
		<div class="panel-heading">
			<h1 class="panel-title">订单结算</h1>
		</div>
		<div class="panel-body"
			style="font-family: Mircosoft Yahei; font-size: 18px; color: #FE4042">请仔细核对您购买的商品</div>
		<table class="table" border="0">
			<thead>
				<tr id="title">
					<th>商品图片</th>
					<th>商品名称</th>
					<th>单价</th>
					<th>数量</th>
					<th>操作</th>
				</tr>
			</thead>
			<tr>
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
			</tr>
			<tr>
				<td style="margin-left: 40%" colspan="6">
					<form class="pure-form pure-form-aligned"
						action="${pageContext.request.contextPath }/orders/pay"
						method="post">
						<fieldset>
							<div class="pure-control-group">
								<label for="a_province">送货省份</label> <input name="a_province"
									type="text">
							</div>

							<div class="pure-control-group">
								<label for="a_city">送货城市</label> <input name="a_city"
									type="text">
							</div>

							<div class="pure-control-group">
								<label for="a_street">送货街道</label> <input name="a_street"
									type="text">
							</div>

							<div class="pure-control-group">
								<label for="a_recv">收货人</label> <input name="a_recv" type="text">
							</div>

							<div class="pure-control-group">
								<label for="a_recvtel">收货人电话</label> <input name="a_recvtel"
									type="number">
							</div>

							<div class="pure-control-group">
								<label for="o_total">总价</label> <span
									class="pure-form-message-inline"
									style="color: red; font-size: 15px">${o_total }</span>
							</div>
							
							<input name="o_total" type="hidden" value="${o_total }">

							<div class="pure-controls">
								<label for="cb" class="pure-checkbox"> <input id="cb"
									type="checkbox"> 我已经阅读并同意《最终用户条款》
								</label> <br>
								<button type="submit"
									class="button button-highlight button-pill button-small">结算</button>
							</div>
						</fieldset>
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>