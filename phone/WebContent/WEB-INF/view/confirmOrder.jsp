<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人用户查看他的确认收货订单页面</title>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="http://www.bootcss.com/p/buttons/css/buttons.css">
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/userMenu.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/clickFont.js"></script>
</head>
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
			<h3 class="panel-title">当前订单</h3>
		</div>
		<div class="panel-body">
<c:forEach items="${orders }" var="order">
			<table class="pure-table pure-table-horizontal">
				<thead>
					<tr>
						<th>订单编号</th>
						<th>收货地址</th>
						<th>收货人</th>
						<th>联系电话</th>
						<th>订单状态</th>
						<th>订单时间</th>
						<th>操作</th>
					</tr>
				</thead>

				<tbody>
					
						<tr>
							<td>${order.o_id }</td>
							<td>${order.a_province }${order.a_city }${order.a_street }</td>
							<td>${order.a_recv }</td>
							<td>${order.a_recvtel }</td>
							<td>${order.o_status }</td>
							<td>
							<fmt:formatDate value="${order.o_time }" pattern="yyyy-MM-dd hh:mm"/>
							</td>
							<td><a
								href="${pageContext.request.contextPath }/orders/removeOrders/${order.o_id}">删除</a>|
								<a href="${pageContext.request.contextPath }/orders/confirmOk/${order.o_id}">确认收货</a></td>
						</tr>
					
				</tbody>
			</table>

			<%-- <c:forEach items="${orders }" var="order"> --%>
				<%--   订单编号：<input type="text" value="${order.o_id }" readonly="readonly">
				<br>
  收货地址省份：<input type="text" value="${order.a_province }"
					readonly="readonly">
				<br>
  收货地址城市：<input type="text" value="${order.a_city }" readonly="readonly">
				<br>
  收货地址街道：<input type="text" value="${order.a_street }"
					readonly="readonly">
				<br>
  收货人<input type="text" value="${order.a_recv }" readonly="readonly">
				<br>
  收货人号码：<input type="text" value="${order.a_recvtel }"
					readonly="readonly">
				<br>
  订单状态：<input type="text" value="${order.o_status }" readonly="readonly">
				<br>
  订单时间：<input type="text" value="${order.o_time }"> --%>
				<br>
				<table class="pure-table pure-table-horizontal" width="600px">
					<thead>
						<tr>
							<th>商品图片</th>
							<th>商品名</th>
							<th>商品单价</th>
							<th>数量</th>
						</tr>
					</thead>
					<c:forEach items="${order.p_os }" var="po">
						<tr>
							<td width="85px"><img style="width: 100%; height: 10%"
								src="${pageContext.request.contextPath }/${po.product.p_image}"></td>
							<td id="DQ">${po.product.p_name }</td>
							<td id="DQ">${po.product.p_price }</td>
							<td id="DQ" class="c_amount">${po.c_amount }</td>
							
						</tr>
					</c:forEach>
				</table>
				<hr>
				<br>
			</c:forEach>
		</div>
	</div>


</body>
</html>