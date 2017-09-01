<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机商城</title>
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js "></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js "></script>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css ">
	<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/paging.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/sort.js"></script>
</head>
<style type="text/css">
	#sinput{
		height: 20px;
		width: 4em;
		display: inline;
		size="5";
	}
</style>
<body>
	<jsp:include page="SearchBar.jsp"></jsp:include>
	<h2>我们的商品</h2>
	<%-- <jsp:include page="LeftNavi.jsp"></jsp:include> --%>
	<div id="rightPanel" style="margin-left: 15%">

		<form id="seach"
			action="${pageContext.request.contextPath }/product/fuzzy/list"
			method="post">
			<div class="pure-menu pure-menu-horizontal"
				style="display: inline; margin-left: 5%">
				<ul class="pure-menu-list">
					<li class="pure-menu-item pure-menu-disabled">排序方式</li>
					<li class="pure-menu-item"><a href="javascript:goSort('p_price')" class="pure-menu-link">价格</a></li>
					<li class="pure-menu-item"><a href="javascript:goSort('p_sale')" class="pure-menu-link">销量</a></li>
					<li class="pure-menu-item"><a href="javascript:goSort('asc')" class="pure-menu-link">升序</a></li>
					<li class="pure-menu-item"><a href="javascript:goSort('desc')" class="pure-menu-link">降序</a></li>
				</ul>
			</div>
			<div style="bottom: 2%; display: inline;">
				<div style="margin-left: 3%; display: inline">
					价格区间：<input type="text" id="sinput" class="form-control" name="start">-
							<input type="text" id="sinput"class="form-control" name="end"> 
							<input type="submit" class="btn btn-info" value="搜索" style="height: 26px; width: 50px; font-size: 11px">
				</div>
				<input type="hidden" name="order" id="order">
				<input type="hidden" name="sort" id="sort">
				<input type="hidden" name="pname" value="${pname }">
			</div>

		</form>

		<form id="pageForm"
			action="${pageContext.request.contextPath }/product/fuzzy/list"
			method="post">
			<table border="0" cellspacing="5px" width="100%">
				<c:set var="total" value="${products.size() }"></c:set>

				<c:forEach items="${page.getList() }" var="product" varStatus="abc">
					<c:if test="${abc.count%3==1}">
						<tr>
					</c:if>
					<td><img
						src="${pageContext.request.contextPath }/${product.p_image}">
						<br> <a href="../${product.p_id}/details">${product.p_name }
							&nbsp;&nbsp;&nbsp;&nbsp;${product.p_price }元</a></td>
					<%-- <c:if test="${abc.count%3==2}">
			<td></td>
		</c:if> --%>
					<c:if test="${abc.count%3== 0 || abc.count==total}">
						</tr>
					</c:if>
				</c:forEach>
				<tr>
					<td colspan="3" align="right"><a
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
			</table>
			<input type="hidden" name="pageNo" id="curPage"
				value="${page.getPageNum()}"> <input type="hidden"
				name="pageSize" id="pSize" value="${page.getPageSize()}"> <input
				type="hidden" name="pname" value="${pname }">
		</form>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/resources/js/clickFont.js"></script>
</body>

</html>