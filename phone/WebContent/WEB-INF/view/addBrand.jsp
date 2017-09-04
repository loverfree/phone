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
<link rel="stylesheet" media="all"  type="text/css" href="${pageContext.request.contextPath }/resources/css/fileinput.min.css">
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/fileinput.min.js"></script>
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
	<!-- 后台添加品牌信息界面 -->
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">添加商品</h3>
			</div>
			<div class="panel-body">
				<form class="pure-form pure-form-aligned" 
				action="${pageContext.request.contextPath }/brand/addBrand"
				method="post" enctype="multipart/form-data">
					<fieldset>
						<div class="pure-control-group">
							<label for="pname">品牌类别名</label>
							<input type="text" name="b_name">
						</div>

						<div class="pure-control-group">
							<label for="price">品牌LOGO</label> 
							<input type="file" name="b_logo">
						</div>
						
						<div class="pure-control-group">
						
						  <button type="submit" class="pure-button pure-button-primary" style="margin-left: 14.5%">提交</button>
						  
						</div>

					</fieldset>
				</form>
				
				<hr>
				添加图片
				<form action="upPic" method="post" enctype="multipart/form-data">
					<div class="input-group" style="margin-left: 7%; width: 33%">
						<span class="input-group-addon">上传正面 </span> <input id="upPic"
							type="file" class="file" name="url">
					</div>
					<br>
					<div class="input-group" style="margin-left: 7%; width: 33%">
						<span class="input-group-addon">上传侧面 </span> <input id="upPic"
							type="file" class="file" name="url">
					</div>
					<br> <input id="upPic" name="upPic" class="btn" type="submit"
						value="上传" style="float: right;">
				</form>

			</div>
		</div>
</div>
</body>
</html>