<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>地址管理</title>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/userMenu.css" />
<script type="text/javascript">
	$(function(){
		$("#city").citySelect({
			nodata:"none",
			required:false
		}); 
	});
</script>
</head>
<style type="text/css"> 
th,td{
	text-align: center;
}
</style>
<body>
	<div class="panel panel-default"
		style="margin-left: 3%; width: 76%; height: auto; float: left; font-family: Microsoft Yahei">
		<div class="panel-heading">地址管理</div>
		<div class="panel-body" style="margin-top: -3%">
			<h4 class="page-header">已有地址</h4>
			<table class="table table-hover">
				<thead>
					<tr style="background-color: #FEA268">
						<th>省份</th>
						<th>城市</th>
						<th>街道</th>
						<th>收件人</th>
						<th>联系电话</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
						<c:forEach items="${alist }" var="it">
							<tr>
								<td>${it.a_province}</td>
								<td>${it.a_city }</td>
								<td>${it.a_street }</td>
								<td>${it.a_recv }</td>
								<td>${it.a_recvtel }</td>
								<td><input id="check" type="checkbox" />
								<label for="check"></label>|
								删除</td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
			<h4 class="page-header">添加新地址</h4>
		</div>
	</div>
</body>
</html>