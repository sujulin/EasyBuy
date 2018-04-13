
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="<%=path %>/Backstage/css/style.css" />
<script type="text/javascript" src="<%=path %>/Backstage/scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=path %>/Backstage/scripts/function.js"></script>
</head>
<script type="text/javascript">
 

</script>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="<%=path %>/Backstage/images/logo.gif" /></div>
	<div class="help"><a href="<%=path %>/Index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="<%=path %>/Index.jsp">首页</a></li>
			<li><a href="<%=path %>/Backstage/user.jsp">用户</a></li>
			<li><a href="<%=path %>/Backstage/product.jsp">商品</a></li>
			<li><a href="<%=path %>/Backstage/order.jsp">订单</a></li>
			<li class="<%=path %>/Backstage/current"><a href="guestbook.jsp">留言</a></li>
			<li><a href="<%=path %>/Backstage/news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="<%=path %>/Index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><a href="<%=path %>/Backstage/user.jsp">用户管理</a></dd>
			  <dt>商品信息</dt>
				<dd><em><a href="<%=path %>/Backstage/productClass-add.jsp">新增</a></em><a href="<%=path %>/Backstage/productClass.jsp">分类管理</a></dd>
				<dd><em><a href="<%=path %>/Backstage/product-add.jsp">新增</a></em><a href="<%=path %>/Backstage/product.jsp">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="<%=path %>/Backstage/order.jsp">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="<%=path %>/Backstage/guestbook.jsp">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="<%=path %>/Backstage/news-add.jsp">新增</a></em><a href="<%=path %>/Backstage/news.jsp?action=findAll">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>新闻管理</h2>
		<div class="manage">
			<table class="list">
			    <tr>
					<th>ID</th>
					<th>新闻标题</th>
					<th>操作</th>
				</tr>
				  
			</table>
		</div>
	</div>
	<div class="clear"></div>
    <div class="pager">
				<ul class="clearfix">
					<li><a >首页</a></li>
					<li>...</li>
					<li><a >4</a></li>
					<li class="current">5</li>
                    <li><a >6</a></li>
                    <li>...</li>
					<li><a >尾页</a></li>
				</ul>
			</div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
