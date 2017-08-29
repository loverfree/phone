<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台更新用户信息</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/bUser/updateUser" method="post">
        用户id：<input type="text" name="u_id" readonly="readonly" value="${user.u_id }"><br>
        用户名：<input type="text" name="u_name" readonly="readonly" value="${user.u_name }"><br>
       用户密码： <input type="text" name="u_pwd" value="${user.u_pwd }"><br>
        昵称：<input type="text" name="u_nickname" value="${user.u_nickname }"><br>
        用户卡号：<input type="text" name="u_card" value="${user.u_card }"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>