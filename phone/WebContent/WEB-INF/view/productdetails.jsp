<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机商城</title>
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/menuStyle.css" /> --%>
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
<%-- <jsp:include page="SearchBar.jsp"></jsp:include> --%>
</div>
<h2>我们的商品</h2>
<div id="rightPanel">
<table border="0" cellspacing="5px" width="100%">
	<tr>
	 	<td rowspan="3">
	 		<c:forEach items="${details.images }" var="image">
	 			<img src = "../../${image.i_path }">
	 		</c:forEach>
	 	</td>
		<td>商品名：${details.p_name }<br>商品描述：${details.p_info }</td>
		
	</tr>
	
	<tr><td>商品价格：${details.p_price }<br>商品销量：${details.p_sale }</td></tr>
	<tr><td>商品库存：${details.p_sale }<br>
	购买数量：<input type=text name=amount value=1>
	<input type=button value="+" onClick="javascript:this.form.amount.value++;">
	<input type=button value="-" onClick="javascript:this.form.amount.value--;">
	<br><br>
	<input type="button" value="立即购买">
	</td></tr>

	<tr><td colspan="2"><c:forEach items="${details.reviews }" var="review">
			${review.r_info}&nbsp;&nbsp;&nbsp;${review.user.u_name }&nbsp;&nbsp;${review.r_time }<br>
			</c:forEach>
		</td></tr>

</table>
</div>
</body>
</html>