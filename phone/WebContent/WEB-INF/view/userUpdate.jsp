<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人信息管理</title>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/userMenu.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/clickFont.js"></script>
</head>
<body>
<div class="Navi">
 <img id="shopLogo" onclick="window.location.href='${pageContext.request.contextPath }/product/brand/list'" src="${pageContext.request.contextPath }/resources/image/shopLogo.png">
 <img id="head" src="${pageContext.request.contextPath }/${sessionScope.curuser.u_pic}" class="img-circle" width="5%" height="10%" > 
 </div>
 <h2 style="margin-left: 2%">功能菜单</h2>
 <jsp:include page="userFunc.jsp"></jsp:include>
<jsp:include page="userMgn.jsp"></jsp:include>
</body>
</html>