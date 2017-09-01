<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人用户查看他的所有订单</title>
</head>
<body>
<c:forEach items="${orders }" var="order"></c:forEach>
  <input type="text" value="${order.o_id }" readonly="readonly">
  <input type="text" value="${order.a_province }" readonly="readonly">
  <input type="text" value="${order.a_city }" readonly="readonly">
  <input type="text" value="${order.a_street }" readonly="readonly">
  <input type="text" value="${order.a_recv }" readonly="readonly">
  <input type="text" value="${order.a_recvtel }" readonly="readonly">
  <input type="text" value="${order.o_status }" readonly="readonly">
  <input type="text" value='<fmt:parseDate pattern="yyyy-MM-dd HH:mm" value="${order.o_time }"></fmt:parseDate>'>
  <table border="1">
  <tr>
    <th>商品图片</th>
						<th>商品名</th>
						<th>商品单价</th>
						<th>数量</th>
						<th>操作</th>
						</tr>
    <c:forEach items="order.p_os" var="po">
       <tr>
         <td width="75px"><img style="width: 100%; height: 10%"
								src="${pageContext.request.contextPath }/${po.product.p_image}"></td>
							<td id="DQ">${po.product.p_name }</td>
							<td id="DQ">${po.product.p_price }</td>
							<td id="DQ" class="c_amount">${po.c_amount }</td>
							<td><a href="${pageContext.request.contextPath }/order/removeOrders/${order.o_id}">删除</a></td>
       </tr>
    </c:forEach>
  </table>
</body>
</html>