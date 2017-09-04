<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理银行卡面板</title>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="http://www.bootcss.com/p/buttons/css/buttons.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/userMenu.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/clickFont.js"></script>
</head>
<script type="text/javascript">

$(function() {
 
	document.querySelector('input[name=ucard]').addEventListener('input', function() {
	    //获取当前光标位置
	    var position = this.selectionStart;
	    var v = this.value;
	    //四个字符加一个空格
	    this.value = v.replace(/\s/g, '').replace(/(.{4})/g, "$1 ");
	    //优化语句：如果当前位置是空格字符，则自动清除掉
	    if (this.value.charAt(this.value.length - 1) == ' ') {
	        this.value = this.value.substring(0, this.value.length - 1);
	    }
	    var input = this;
	    //重新定位光标位置，start和end都需要设置，不然就是截取片段了
	    input.selectionStart = position + countSpace(this.value, position);
	    input.selectionEnd = position + countSpace(this.value, position);
	})
    
});

</script>
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
			<h3 class="panel-title">支付方式</h3>
		</div>
		<div class="panel-body">
			<c:if test="${empty userCard.u_card }">${noCard }
			<hr>
				<form action="addCard" method="post">
					<div class="form-group">
						<input name="uid" type="hidden"
							value="${sessionScope.curuser.u_id}"> <label for="cardno">银行卡号</label>
						<input type="text" class="form-control" id="ucard" name="ucard" maxlength="23"
							placeholder="银行卡号是19位" style="width: 27%"> <small id="cardHelp"
							class="form-text text-muted">您的信息不会泄露.</small>
					</div>
					<button type="submit" class="btn btn-primary">添加</button>
				</form>

			</c:if>
			<c:if test="${not empty userCard.u_card }">
			<label>已添加卡号：</label>${userCard.u_card}&nbsp;卡号长度：${fn:length(userCard.u_card)}

				<hr>
				<form action="addCard" method="post">
					<div class="form-group">
						<input name="uid" type="hidden"
							value="${sessionScope.curuser.u_id}"> <label for="cardno">更改卡号</label>
						<input type="text" class="form-control" id="ucard" name="ucard" maxlength="23"
							placeholder="银行卡号是19位" style="width: 27%"> <small id="cardHelp"
							class="form-text text-muted">您的信息不会泄露.</small>
					</div>
					<button type="submit" class="btn btn-primary">修改</button>
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>