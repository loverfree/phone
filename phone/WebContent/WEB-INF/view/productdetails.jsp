<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机商城</title>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js "></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js "></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
  $(function(){
	  $("#addCart").on("click",function(){
		  $.get("${pageContext.request.contextPath}/cart/addCart",
				  {"p_id":$("#p_id").val(),"c_amount":$("#amount").val()},
				  function(date){
					  alert(date);
				  });
	  });
  });
</script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css ">


</head>
<body>
<div id="searchBar">
<img id="shopLogo" onclick="window.location.href='${pageContext.request.contextPath }/product/brand/list'" src="${pageContext.request.contextPath }/resources/image/shopLogo.png">
</div>
<div>商品详情</div>
	<div style="background-color: #EDEDED">
		<div style="float:left; margin-left: 15%;">
			<c:forEach items="${details.images }" var="image">
	 			<img src = "../../${image.i_path }" height="150px" width="120px">
	 		</c:forEach>
		</div>
				<div class="panel panel-default" ; style="margin-left: 45%;margin-right: 25% ;border: 0" >
					<div class="panel-heading">商品名：${details.p_name }</div>
					<div class="panel-body">
						<p>商品描述：${details.p_info }</p>
					</div>
					<ul class="list-group">
						<li class="list-group-item">商品价格：${details.p_price }</li>
						<li class="list-group-item">商品销量：${details.p_sale }</li>
						<li class="list-group-item">商品库存：${details.p_sale }</li>
						<li class="list-group-item">购买数量：
						<input type=button value="-" id="sub" onClick="javascript:void(0);">
						<input type=text name="amount" id="amount" value="1" size="5">
						<!-- <input type="text" class="form-control" id="amount" name="amount" width="5px"> -->
						<input type=button value="+" id="add" onClick="javascript:void(0);">
						</li>
						
					</ul>
					<button type="button" class="btn btn-info" id="addCart">加入购物车</button>
				</div>
				
				
				<div>
					<div class="panel panel-info" style="margin-top:10%;  margin-left: 16%;margin-right: 16%">
						
						<div class="panel-body">
							<table class="table table table-hover">
								<thead>
									<tr style="background-color: #9DEDF6">
										<th>评论详情</th>
										<th>评论人</th>
										<th>评论时间</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${details.reviews }" var="review">
										<tr>
											<td>${review.r_info}</td>
											<td>${review.user.u_name }</td>
											<td>${review.r_time }</td>
										</tr>
									</c:forEach>

								</tbody>
								
							</table>
							
						</div>
					</div>
				</div>
	<input type = "hidden" name = "pid" value = "${details.p_id }" id="p_id">
	<input type = "hidden" name = "uid" value = "${sessionScope.curuser.u_id}">
</div>

</body>
<script type="text/javascript">
	$("#amount").keypress(function(b) {
	var keyCode = b.keyCode ? b.keyCode : b.charCode;
		if (keyCode != 0 && (keyCode < 48 || keyCode > 57) && keyCode != 8 && keyCode != 37 && keyCode != 39) {
			return false;
		} else {
			return true;
		}
		});
	
	$("#amount").keypress(function(b) {
	var keyCode = b.keyCode ? b.keyCode : b.charCode;
		if (keyCode != 0 && (keyCode < 48 || keyCode > 57) && keyCode != 8 && keyCode != 37 && keyCode != 39) {
			return false;
		} else {
			return true;
		};
			}).keyup(function(e) {
	var keyCode = e.keyCode ? e.keyCode : e.charCode;
		console.log(keyCode);
		if (keyCode != 8) {
			var numVal = parseInt($("#amount").val()) || 0;
			numVal = numVal < 1 ? 1 : numVal;
			numVal = numVal > ${details.p_sale } ? ${details.p_sale }:numVal;
		$("#amount").val(numVal);
			}
		}).blur(function() {
	var numVal = parseInt($("#amount").val()) || 0;
		numVal = numVal < 1 ? 1 : numVal;
		$("#amount").val(numVal);
	}); 

//增加
	$("#add").click(function() {
		var num = parseInt($("#amount").val()) || 0;
		num = num > ${details.p_sale } ? ${details.p_sale }:num;
	$("#amount").val(num + 1);
	});
//减去
	$("#sub").click(function() {
		var num = parseInt($("#amount").val()) || 0;
		num = num - 1;
		num = num < 1 ? 1 : num;
	$("#amount").val(num);
	}); 
</script>
</html>