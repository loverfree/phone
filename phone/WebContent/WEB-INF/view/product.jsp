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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/menuStyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/paging.js"></script>
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
			<div style="background-color: pink;bottom: 2%">
			<div class="panel panel-success" style="display: inline">
				<div style="margin-left: 15%; float: left;margin-top: 1%">
					<ul class="nav nav-pills">
						<li><a href="javascript:goSort('p_price')">价格</a></li>
						<li><a href="javascript:goSort('p_price')">销量</a></li>
						<li><a href="javascript:goSort('asc')">升序</a></li>
						<li><a href="javascript:goSort('desc')">降序</a></li>
					</ul>
				</div>
			</div>
			<div style="margin-left: 45%;margin-bottom: 1%">
					价格区间<input type="text" id="sinput" class="form-control"
						name="start">~ <input type="text" id="sinput"
						class="form-control" name="end"> <input type="submit"
						class="btn btn-info" value="搜索"
						style="height: 20px; width: 38px; font-size: 11px">
				</div>
				<input type="hidden" name="order" id="order"> <input
					type="hidden" name="sort" id="sort">
					</div>
		</form>

		<form id="pageForm" action="${pageContext.request.contextPath }/product/${bid}/list" method="post">


<table border="0" cellspacing="5px" width="80%">
	<c:set var="total" value="${page.getList().size() }"></c:set>
			
		 <c:forEach items="${page.getList() }" var="product" varStatus="abc">
		   <c:if test="${abc.count%3==1}">
		     <tr>
		 </c:if>
	  	 <td><img src ="${pageContext.request.contextPath }/${product.p_image}">
	  	 	<br>
	  	 	<a href = "../${product.p_id}/details">${product.p_name } 
			&nbsp;&nbsp;&nbsp;&nbsp;<label style="color: #FF6F3B">¥${product.p_price }</label></a>
	  	 </td>

	  	 <c:if test="${abc.count%3== 0 || abc.count==total}">
<%-- 	  	 <c:if test="${total == 2 }">
	  	 	<td></td>
	  	 </c:if> --%>
	  	     </tr>
	  	 </c:if>	
	  	</c:forEach>
	 <tr>
	 <td colspan="3" align="right">
         <a href="javascript:goPage(1)">首页</a>
         <a href="javascript:goPage(${page.getPageNum()-1 })">上一页</a>
         <a href="javascript:goPage(${page.getPageNum()+1 })">下一页</a>
          <a href="javascript:goPage(${page.getLastPage() })">末页</a>
           跳转到<input type="text" name="gpage" id="gpage" size="5" style="border-radius:5px;background-color: #FDE56A">页，<a href="javascript:goPage2()">跳转 </a>
         ${page.getPageNum() }/${page.getPages() }
    </td>
    </tr>
	<c:if test="${empty page.getList()}">
   <tr><td colspan="6">没有更多数据！</td></tr>
  </c:if>
</table>
	<input type="hidden" name="pageNo" id="curPage" value="${page.getPageNum()}">
  	<input type="hidden" name="pageSize" id="pSize" value="${page.getPageSize()}">
</form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/clickFont.js"></script>
</body>
<script type="text/javascript">
	function goSort(sort){
		if(sort =="p_price"){
			document.getElementById("sort").value = "p_price";
			document.getElementById("seach").submit();	
		}
		if(sort == "asc"){
			document.getElementById("order").value = "asc";
			document.getElementById("seach").submit();
		}
		if(sort == "p_sale"){
			document.getElementById("sort").value = "p_sale";
			document.getElementById("seach").submit();
		}
		if(sort == "desc"){
			document.getElementById("order").value = "desc";
			document.getElementById("seach").submit();
		}
	}

 	function goPage(currentPage) {
		// 将页码和当前页显示的记录数 隐藏起来
		if(currentPage<=1) {
			currentPage = 1;
		}
		if(currentPage>${page.getLastPage()}){
			  currentPage = ${page.getLastPage()};
		  }
		  $("#curPage").value=currentPage;
		  $("#pageForm").submit();	
	}
	
	 function goPage2(){
		  var gPage = $("#gpage").value;
		  goPage(gPage);
	 }


</script>
</html>