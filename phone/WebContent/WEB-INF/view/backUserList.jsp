<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台查看所有用户界面</title>
</head>
<body>
   <table border="1">
       <tr>
         <th>用户ID</th>
         <th>用户名</th>
         <th>密码</th>
         <th>昵称</th>
         <th>用户卡号</th>
         <th>操作</th>
       </tr>
       <c:forEach items="${users }" var="user">
        <tr>
         <td>${user.u_id }</td>
         <td>${user.u_name }</td>
         <td>${user.u_pwd }</td>
         <td>${user.u_nickname }</td>
         <td>${user.u_card }</td>
         <td><a href="${pageContext.request.contextPath }/bUser/update/${user.u_id}">编辑</a></td>
        </tr>
       </c:forEach>
   </table>
</body>
</html>