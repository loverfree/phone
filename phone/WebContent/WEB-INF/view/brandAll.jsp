<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台查看所有类别</title>
</head>
<body>
  <a href="${pageContext.request.contextPath }/brand/goadd">添加类别</a>
   <table border="1">
      <tr>
        <th>类别编号</th>
        <th>类别名</th>
        <th>类别状态</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${brands }" var="brand">
        <tr>
         <td>${brand.b_id }</td>
         <td>${brand.b_name }</td>
         <td>${brand.b_status }</td>
         <td><a href="${pageContext.request.contextPath }/brand/removeBrand/${brand.b_id}">删除</a></td>
        </tr>
      </c:forEach>
   </table>
</body>
</html>