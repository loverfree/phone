<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户编辑信息</title>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" media="all"  type="text/css" href="${pageContext.request.contextPath }/resources/css/fileinput.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/userMenu.css" />
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js" ></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/fileinput.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/zh.js"></script>
</head>
<script type="text/javascript">

function checkPwd() {
	var pwdVal =document.getElementById("pwd"); 
	if (pwdVal.value.length==0) {
		alert('密码不能为空');
	}
}

</script>
<body>
	<div class="panel panel-default" style="margin-left: 3%;width: 76%;height: auto;float: left; font-family: Microsoft Yahei">
	<div class="panel-heading" >
		<h3 class="panel-title">
			我的信息 
		</h3>
	</div>
		<div class="panel-body">
			<form action="upt" method="post" class="bs-example bs-example-form"> 
				<h3>当前用户:${sessionScope.curuser.u_name} </h3><br> <input name="uid"
					type="hidden" value="${sessionScope.curuser.u_id}"> <br>

				<div class="input-group" style="margin-left: 33%">
					<span class="input-group-addon">当前昵称 </span> <input name="nickname"
						type="text" class="form-control"
						value="${nowNick} " style="width: 50%">
				</div>
				<br>
				<div class="input-group" style="margin-left: 33%">
					<span class="input-group-addon">新的密码 </span> <input id="pwd" name="password"
						class="form-control" type="text" style="width: 50%">
				</div>
				<br> <input id="change" name="change" class="btn" type="submit"
					value="提交" style="float: right;" onclick="checkPwd()">
			</form>
			<br>
			<hr>
			<form action="upPic" method="post" enctype="multipart/form-data">
				<div class="input-group" style="margin-left: 33%; width: 49%">
					<span class="input-group-addon">上传头像 </span> <input id="upPic"
						type="file" class="file" name="url">
				</div>
				<input name="uid"
					type="hidden" value="${sessionScope.curuser.u_id}">
				<br> <input id="upPic" name="upPic" class="btn" type="submit"
					value="上传" style="float: right;">
			</form>
		</div>
	</div>
</body>
</html>