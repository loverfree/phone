<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height: 100%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品后台管理</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/mgrStyle.css" />
<link rel="stylesheet" href="http://www.bootcss.com/p/buttons/css/buttons.css">
 <link href="http://cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body style="height: 100%">
<jsp:include page="MgrLeft.jsp"></jsp:include>
	<div id="topBar">
		<span class="nav" style="float: right;">
			<ul>
				<li><i class="fa fa-search"></i></li>
				<li><i class="fa fa-bell-o"></i></li>
				<li><i class="fa fa-cog fa-spin fa-fw"></i></li>
			</ul>
		</span>
	</div>
	<div id="rightFunc">
	<br>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">注册用户</h3>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead style="font-weight: bolder; background-color: #FAFCF6">
						<tr>
							<th>用户ID</th>
                            <th>用户名</th>
                             <th>密码</th>
                            <th>昵称</th>
                        <th>用户卡号</th>
                      <th>操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${page.getList() }" var="user">
						<tr>
							<td>${user.u_id }</td>
         <td>${user.u_name }</td>
         <td>${user.u_pwd }</td>
         <td>${user.u_nickname }</td>
         <td>${user.u_card }</td>
							<td><a class="fa fa-pencil-square-o" aria-hidden="true" 
							href="${pageContext.request.contextPath }/bUser/update/${user.u_id}"></a>编辑|
								<i class="fa fa-trash-o" aria-hidden="true"></i>删除</td>
						</tr>
						</c:forEach>
						<tr>
							<td colspan="3"><a>上页</a></td>
							<td colspan="3"><a>下页</a></td>
						</tr>
					</tbody>
				</table>

			</div>
		</div>
		<br>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">商品库存</h3>
			</div>
			<div class="panel-body">面板内容</div>
		</div>
		<br>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">订单管理</h3>
			</div>
			<div class="panel-body">面板内容</div>
		</div>
	</div>
</body>
</html>