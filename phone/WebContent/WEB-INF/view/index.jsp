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
			<c:set var="total" value="${brands.size() }"></c:set>
			
		 <c:forEach items="${brands }" var="brand" varStatus="abc">
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
</table>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/clickFont.js"></script>
</body>
</html>