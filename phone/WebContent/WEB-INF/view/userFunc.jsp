<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户功能面板</title>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/userMenu.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/clickFont.js"></script>
</head>
<body>
<div class="panel panel-default" style="margin-left: 2%;width: 16%;float: left;font-size: 15px;font-family: Microsoft Yahei">
	<div class="panel-heading">
		<h3 class="panel-title">
			功能
		</h3>
	</div>
	<div class="panel-body">
		<ul class="list-group">
        <li class="list-group-item"><a href="${pageContext.request.contextPath }/user/userUpdate">🙂&nbsp;更改个人信息</a></li>
        <li class="list-group-item"><a href="${pageContext.request.contextPath }/user/addrUpdate">📬&nbsp;账户收货地址</a></li>
        <li class="list-group-item"><a href="${pageContext.request.contextPath }/user/card">🏧&nbsp;绑定/更改银行卡</a></li>
        <li class="list-group-item"><a href="${pageContext.request.contextPath }/cart/">🛒&nbsp;购物车</a></li>
        <li class="list-group-item"><a  >💰&nbsp;我的订单</a></li>
    </ul>
	</div>
</div>
</body>
</html>