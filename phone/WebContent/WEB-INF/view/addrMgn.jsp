<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>地址管理</title>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/province.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/userMenu.css" />
</head>
<script type="text/javascript">
$(function() {
	$('h4#addAddr').on('click', function() {
		$('table#addAddr').slideToggle('fast', function() {
		})
	})
})
</script>
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
			<h4 id="addAddr" class="page-header">添加新地址</h4>
			<form action="addAddr" method="post">
			<table id="addAddr" class="table table-condensed" style="border: 1px solid #EDEDED">
				<tr>
					<td>
						<div class="input-group">
							<span class="input-group-addon">收件人</span> <input id="recv"
								name="a_recv" type="text" class="form-control" style="width: 31%">
						</div>
						<%-- <input name="u_id" type="text" value="${sessionScope.curuser.u_id}"> --%>
					</td>
				</tr>
				<tr>
					<td>
						<div class="input-group">
							<span class="input-group-addon">联系电话</span> <input id="recvtel"
								name="a_recvtel" type="text" class="form-control" style="width: 30%">
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="input-group">
							<span class="input-group-addon">省份 </span><select id="province"
								class="form-control" name="a_province" onchange="loadCity();"
								style="width: 149px">
								<option value=" ">--请选择省份--</option>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="input-group">
							<span class="input-group-addon">城市 </span><select id="city"
								class="form-control" name="a_city" style="width: 149px">
								<option value="">--请选择城市--</option>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="input-group">
							<span class="input-group-addon">街道 </span> <input id="street"
								name="a_street" type="text" class="form-control"
								style="width: 70%">
						</div>
					</td>
				</tr>
				<tr>
					<td><input id="change" name="change" class="btn btn-primary" type="submit"
						value="提交" style="margin-right: 5%">
						<input id="change" name="change" class="btn btn-default" type="submit"
						value="重置" style="float: right">
					</td>
				</tr>
			</table>
		</form>
		</div>
	</div>
</body>
</html>