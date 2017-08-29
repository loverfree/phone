<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户购物车页面</title>
</head>
<body>
    <a href="${pageContext.request.contextPath }/cart/emptyCart"></a>
    <c:if test="${empty carts }">无数据</c:if>
    <c:if test="${not empty carts }">
   <table border="1">
     <tr>
       <th>商品图片</th>
       <th>商品名</th>
       <th>商品单价</th>
       <th>数量</th>
       <th>操作</th>
     </tr>
     <c:forEach items="${carts }" var="cart">
       <tr>
         <td><img src="${pageContext.request.contextPath }/${cart.product.p_image}"></td>
         <td>${cart.product.p_name }</td>
         <td>${cart.product.p_price }</td>
         <td>${cart.c_amount }</td>
         <td><a href="${pageContext.request.contextPath }/cart/removeCart/${cart.product.p_id}">删除</a></td>
       </tr>
     </c:forEach>
   </table>
   </c:if>
</body>
</html>