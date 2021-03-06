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
<link href="${pageContext.request.contextPath }/resources/css/css.css" type="text/css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">	
<%-- <script src="${pageContext.request.contextPath }/resources/js/jquery-1.2.6.pack.js" type=text/javascript></script> --%>
<script src="${pageContext.request.contextPath }/resources/js/base.js" type=text/javascript></script> 
<script src="${pageContext.request.contextPath }/resources/js/lib.js" type=text/javascript></script>
<script src="${pageContext.request.contextPath }/resources/js/zzsc.js" type=text/javascript></script> 
<script type="text/javascript">
  $(function(){
	  $("#addCart").on("click",function(){
		  $.get("${pageContext.request.contextPath}/cart/addCart",
				  {"p_id":$("#p_id").val(),"c_amount":$("#amount").val()},
				  function(date){
					  alert(date);
				  });
	  });
	  
	  $(".jqzoom").jqueryzoom({
			xzoom:400,
			yzoom:400,
			offset:10,
			position:"right",
			preload:1,
			lens:1
		});
		$("#spec-list").jdMarquee({
			deriction:"left",
			width:350,
			height:56,
			step:2,
			speed:4,
			delay:10,
			control:true,
			_front:"#spec-right",
			_back:"#spec-left"
		});
		$("#spec-list img").bind("mouseover",function(){
			var src=$(this).attr("src");
			$("#spec-n1 img").eq(0).attr({
				src:src.replace("\/n5\/","\/n1\/"),
				jqimg:src.replace("\/n5\/","\/n0\/")
			});
			$(this).css({
				"border":"2px solid #ff6600",
				"padding":"1px"
			});
		}).bind("mouseout",function(){
			$(this).css({
				"border":"1px solid #ccc",
				"padding":"2px"
			});
		});
  });
</script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css ">


</head>
<body>
<div id="searchBar">
<img id="shopLogo" onclick="window.location.href='${pageContext.request.contextPath }/product/brand/list'" src="${pageContext.request.contextPath }/resources/image/shopLogo.png"> 
			
		   <i class="fa fa-user fa-2x" 
			style="position: absolute; right: 13%; top: 5%" aria-hidden="true"
			onclick="javascript:window.location.href='${pageContext.request.contextPath }/user/userUpdate'"></i>
			
			<i class="fa fa-shopping-cart fa-2x" 
			style="position: absolute; right: 9.2%; top: 5%" aria-hidden="true"
			onclick="javascript:window.location.href='${pageContext.request.contextPath }/cart/'" ></i>
			<caution style="position: absolute; right: 8%; top: 4%">6</caution>
			
			<i class="fa fa-shopping-bag fa-2x" 
			style="position: absolute; right: 5.2%; top: 5%" aria-hidden="true"></i>
			<caution style="position: absolute; right: 4%; top: 4%">2</caution>
			
			<i class="fa fa-sign-out fa-2x"
			style="position: absolute; right: 1%; top: 5%" aria-hidden="true"
			onclick="javascript:window.location.href='${pageContext.request.contextPath }/user/logout'"></i>
	</div>

	<div style="background-color: #EDEDED;height: 60px;">
		<h3 style="padding-left: 10px;padding-top: 20px">${details.p_name }</h3>
	</div>
	<div id=preview style="margin-left: 10%;float: left">
		<div class=jqzoom id=spec-n1>
			<c:forEach items="${details.images }" var="image" step="1" begin="1"
				end="1">
				<li><img src="../../${image.i_path }"
					jqimg="../../${image.i_path }" height=320 " width=300></li>
			</c:forEach>
		</div>
		<div id=spec-n5>
			<div class=control id=spec-left>
				<img
					src="${pageContext.request.contextPath }/resources/image/left.jpg" />
			</div>
			<div id=spec-list>
				<ul class=list-h>
					<c:forEach items="${details.images }" var="image">
						<li><img src="../../${image.i_path }"></li>
					</c:forEach>
				</ul>
			</div>
			<div class=control id=spec-right>
				<img
					src="${pageContext.request.contextPath }/resources/image/right.jpg" />
			</div>
		</div>
	</div>
	<%-- 	<div style="background-color: white">
		<div style="float:left; margin-left: 15%;margin-top: 2%">
			<c:forEach items="${details.images }" var="image">
	 			<img src = "../../${image.i_path }" height="150px" width="120px">
	 		</c:forEach>
		</div> --%>
				<div class="panel panel-default"  style="margin-top: 2%;margin-left: 45%;margin-right: 25% ;border: 0" >
					<div class="panel-heading" style="font-size: 18px">${details.p_name }</div>
					<!-- <div class="panel-body"> -->
						<p style="font-size:22px ;font-weight: bolder;">${details.p_info }</p>
					<!-- </div> -->
					<ul class="list-group">
						<li class="list-group-item" style="font-size: 18px">商	城	价：<font color="red">¥${details.p_price }</font></li>
						<li class="list-group-item" style="font-size: 18px">销		量：<font color="#b3d1ea">${details.p_sale }</font></li>
						<li class="list-group-item">商品库存：${details.p_stock }</li>
						<li class="list-group-item">购买数量：
						<input type=button value="-" id="sub" onClick="javascript:void(0);">
						<input type=text name="amount" id="amount" value="1" size="5" style="text-align: center;">
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
			numVal = numVal > ${details.p_stock } ? ${details.p_stock }:numVal;
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
		num = num > ${details.p_stock } ? ${details.p_stock }:num;
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