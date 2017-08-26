<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机商城</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/menuStyle.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<jsp:include page="SearchBar.jsp"></jsp:include>
<h2>我们的商品</h2>
<jsp:include page="LeftNavi.jsp"></jsp:include>
<div id="rightPanel">
<form id="pageForm" action="${pageContext.request.contextPath }/product/brand/list" method="post">
<table border="0" cellspacing="5px" width="100%">
			<c:set var="total" value="${brands.size() }"></c:set>
<%-- 			<tr> <td><img src ="${pageContext.request.contextPath }/resources/image/logo/All.png">
			<br><a href="../all/list">所有手机</a></td></tr> --%>
		 <c:forEach items="${page.getList() }" var="brand" varStatus="abc">
		   <c:if test="${abc.count%3==1}">
		     <tr>
		 </c:if>
	  	 <td><img src ="${pageContext.request.contextPath }/${brand.b_logo}">
	  	 	<br>
	  	 	
	  	 	<a href="../${brand.b_id }/list">${brand.b_name }</a>
	  	 </td>

	  	 <c:if test="${abc.count%3== 0 || abc.count==total}">
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
    <c:if test="${empty page.getList() }">
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

 	function goPage(currentPage) {
		// 将页码和当前页显示的记录数 隐藏起来
		if(currentPage<=1) {
			currentPage = 1;
		}
		if(currentPage>${page.getLastPage()}){
			  currentPage = ${page.getLastPage()};
		  }
		  document.getElementById("curPage").value=currentPage;
		  document.getElementById("pageForm").submit();	
	}
	
	 function goPage2(){
		  var gPage = document.getElementById("gpage").value;
		  goPage(gPage);
	 }

</script>
</html>