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
				<h3 class="panel-title">商品管理</h3>
			</div>
			<div class="panel-body">
			<form id = "pageForm" action="${pageContext.request.contextPath }/product/backlist" method="post">
				<table class="table table-hover">
					<thead style="font-weight: bolder; background-color: #FAFCF6">
						<tr>
							<th>商品编号</th>
							<th>商品名</th>
							<th>商品图片</th>
							<th>商品进价</th>
							<th>商品售价</th>
							<th>商品库存</th>
							<th>商品销量</th>
							<th>商品信息</th>
							<th>商品品牌</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.getList()}" var="list">
							<tr>
								<td>${list.p_id}</td>
								<td>${list.p_name }</td>
								<td><img src="${pageContext.request.contextPath }/${list.p_image}" width="30px" height="30px"></td>
								<td>${list.p_import}</td>
								<td>${list.p_price}</td>
								<td>${list.p_stock}</td>
								<td>${list.p_sale}</td>
								<td>${list.p_info}</td>
								<td>${list.brand.b_name}</td>
								<td><a
									href="${pageContext.request.contextPath }/product/${list.p_id}/remove">删除</a>
									|| <a
									href="${pageContext.request.contextPath }/product/${list.p_id}/updateProduct">修改</a>
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
				<input type="hidden" name = "b_id" value = "${b_id }">
		<input type="hidden" name="pageNo" id="curPage" value="${page.getPageNum()}">
  		<input type="hidden" name="pageSize" id="pSize" value="${page.getPageSize()}">
				</form>
			</div>
		</div>
	</div>
</body>
</html>