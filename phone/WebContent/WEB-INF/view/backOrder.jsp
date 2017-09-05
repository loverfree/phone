<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/paging.js"></script>
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
				<h3 class="panel-title">订单管理</h3>
			</div>
			<div class="panel-body">
			<form id = "pageForm" action="${pageContext.request.contextPath }/product/backlist" method="post">
				<table class="table table-hover">
					<thead style="font-weight: bolder; background-color: #FAFCF6">
						<tr>
							<th>订单编号</th>
							<th>订单总价</th>
							<th>收货地址省份</th>
							<th>收货地址城市</th>
							<th>收货地址街道</th>
							<th>收货人姓名</th>
							<th>收货人手机号</th>
							<th>订单生成时间</th>
							<th>订单状态</th>
							<th>生成订单用户</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.getList()}" var="list">
							<tr>
								<td>${list.o_id}</td>
								<td>${list.o_total }</td>
								<td>${list.a_province}</td>
								<td>${list.a_city}</td>
								<td>${list.a_street}</td>
								<td>${list.a_recv}</td>
								<td>${list.a_recvtel}</td>
								<td><fmt:formatDate value="${list.o_time}" pattern="yyyy-MM-dd:hh:mm"/></td>
								<td>${list.o_status }
								</td>
								<td>${list.user.u_name}</td>
								<td><a
									href="">删除</a>
									|| <a
									href="">修改</a>
								</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="9" align="center"><a
								href="javascript:goPage(1,${page.getLastPage()})">首页</a> <a
								href="javascript:goPage(${page.getPageNum()-1 },${page.getLastPage()})">上一页</a>
								<a
								href="javascript:goPage(${page.getPageNum()+1 },${page.getLastPage()})">下一页</a>
								<a
								href="javascript:goPage(${page.getLastPage() },${page.getLastPage()})">末页</a>
								跳转到<input type="text" name="gpage" id="gpage" size="5"
								style="border-radius: 5px; background-color: #FDE56A">页，<a
								href="javascript:goPage2()">跳转 </a> ${page.getPageNum() }/${page.getPages() }
							</td>
						</tr>
						<c:if test="${empty page.getList()}">
							<tr>
								<td colspan="6">没有更多数据！</td>
							</tr>
						</c:if>
					</tbody>
				</table>
		<input type="hidden" name="pageNo" id="curPage" value="${page.getPageNum()}">
  		<input type="hidden" name="pageSize" id="pSize" value="${page.getPageSize()}">
				</form>
			</div>
		</div>
	</div>
</body>
</html>