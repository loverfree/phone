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
<table border="0" cellspacing="5px" width="100%">
	<tr>
	 <c:forEach items="${products }" var="product" begin="0" end="2" step="1">
	 <tr>
		<td><img src ="${pageContext.request.contextPath }/${product.images[0].i_path}"></td>
	</tr>
	<tr>	
		<td><a href = "../${product.p_id}/details">${product.p_name } 
			&nbsp;&nbsp;&nbsp;&nbsp;${product.p_price }元
		</a></td>
	</c:forEach>
	</tr>

</table>
</div>
</body>
</html>