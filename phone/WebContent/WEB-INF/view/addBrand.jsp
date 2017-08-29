<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台商品类别添加</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/brand/addBrand" method="post" enctype="multipart/form-data">
       商品类别名：<input type="text" name="b_name"><br>
       商品LOGO<input type="file" name="b_logo"><br>
       <input type="submit" value="提交">
    </form>
  
</body>
</html>