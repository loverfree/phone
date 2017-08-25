<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台登录</title>
</head>
<body>
<div class="bubble"></div>

	<div id="panel">
		<br><br><br><br>
		<span id="loginInfo">欢迎光临！</span>
		<br><br><br>
		<form action="loginUser" method="post">
			<table id="regBlank" border="0">

				<tr>
					<td colspan="2"><input id="uname" type="text" value="用户名"
						name="uname" onblur="#" /> <span id="result"></span>
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
					<td><input id="reset" type="button" value="重置" />
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="sign" type="submit" value="登录" /></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td align="center">忘记密码了吗？<a id="backPwd">重置密码！</a></td>
				</tr>
			</table>
				<span> 当前用户：${sessionScope.curuname} </span>
		</form>
 		<form action="logout" method="get">
			<input type="submit" value="还不能退出登录">
		</form> 
	</div>
	<span id="one"></span>
</body>
</html>