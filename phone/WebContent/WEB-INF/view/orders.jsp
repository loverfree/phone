<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人用户的订单查看</title>
</head>
<body>
   <table border="1">
     <tr>
       <th></th>
						<th>商品图片</th>
						<th>商品名</th>
						<th>商品单价</th>
						<th>数量</th>
						<th>操作</th>
     </tr>
     <c:forEach items="${carts }" var="cart">
					  <input type="hidden" name="p_id" value="${cart.product.p_id }" class="p_id">
						<tr>
							<td id="DQ"><input type="checkbox"></td>
							<td width="75px"><img style="width: 100%; height: 10%"
								src="${pageContext.request.contextPath }/${cart.product.p_image}"></td>
							<td id="DQ">${cart.product.p_name }</td>
							<td id="DQ">${cart.product.p_price }</td>
							<td id="DQ" class="c_amount">${cart.c_amount }</td>
							<td id="DQ"><a
								href="${pageContext.request.contextPath }/cart/removeCart/${cart.product.p_id}">删除</a></td>
						</tr>
					</c:forEach>
   </table>
   <form action="${pageContext.request.contextPath }/orders/pay" method="post">
     送货省份:<input name="a_province" type="text"><br>
     送货城市：<input name="a_city" type="text"><br>
     送货街道：<input name="a_street" type="text"><br>
     收货人：<input name="a_recv" type="text"><br>
     收货人电话：<input name="a_recvtel" type="number"><br>
     总价：<input name="o_total" type="text" value="${o_total }" readonly="readonly"><br>
     <input type="submit" value="付款">
   </form>
</body>
</html>