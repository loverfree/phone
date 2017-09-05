<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/loginStyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/bubble.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/userVerify.js"  charset="gb2312" ></script>
<style type="text/css">
.bubble {
  position: absolute;
  width: 20px;
  height: 20px;
  border-radius: 100%;
  background: rgba(255, 255, 255, .5);
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
</head>
<body>
<div class="bubble"></div>

	<div id="panel">
		<br><br><br><br>
		<span id="loginInfo">成为会员！</span>
		<br><br><br>
		<form name="regForm" action="regUser" method="post">
			<table id="regBlank" border="0">
				<tr>
					<td colspan="2"><input id="uname" type="text" value="用户名"
						name="uname" onclick="checkMobile(this.value)" onblur="checkName(this.value)" /> <span id="result"></span>
					</td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td colspan="2"><input id="password" type="password"
						value="密码" name="password" /></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><input id="reset" type="button" value="按钮" />
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="sign" type="submit" value="注册" /></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td align="center">已经是会员了？<a id="backPwd" href="login">立即登录！</a></td>				
				</tr>
			</table>
		</form>
	</div>
	<span id="one"></span>
</body>
</html>