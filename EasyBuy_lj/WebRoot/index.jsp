<%@page import="cn.easybuy.entity.Prolist"%>
<%@page import="cn.easybuy.entity.Phoneinfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<%-- <%Map<String, Phoneinfo> map1=(Map)request.getAttribute("map1");
 List<Prolist> list1=(List)request.getAttribute("list1"); 
Phoneinfo info=map1.get("phoneinfo"); --%>

<!--  %> -->
<%--  <%=map1 %>
 <%=list1 %>
<%=info %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>unique</title>
<link type="text/css" href="<%=path %>/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/js.js"></script>
</head>

<body>

<%
String loginName =(String)request.getAttribute("loginName");
session.setAttribute("loginName", loginName);
 %>


 <div class="hrader">
 
  <a href="<%=path %>/login.jsp" style="color:#FD7306;margin-left:20px;"><%if(loginName!=null){ %><%=loginName %><%} %><%else{ %>请登录<%} %></a> 
  <a href="<%=path %>/reg.jsp">注册</a>
  <div class="topNav">
   <a href="<%=path %>/index.jsp" style="color:#FD7306;">首页</a>
   <a href="<%=path %>/buy.jsp">买家</a>
   <a href="<%=path %>/sell.jsp">卖家</a>
   <a href="<%=path %>/vip.jsp?loginChenggong=<%=loginName %>">会员中心</a>
   <a href="<%=path %>/xuanshang.jsp">悬赏榜</a>
   <a href="<%=path %>/luntan.jsp" class="luntan">论坛</a>
   <a href="<%=path %>/help.jsp">帮助</a>
   <a href="#">&nbsp;</a>
   <a href="#" class="lan">中文</a>
   <a href="#" class="lan">English</a>
  </div><!--topNav/-->
 </div><!--hrader/-->
 <div class="inCont">
  <h1 class="logo"><a href="<%=path %>/index.jsp"><img src="<%=path %>/images/logo.png" width="304" height="74" /></a></h1>
  <form class="select" action="<%=path%>/servlet/ProListfenjiServlet?name=<%=loginName %>" method="post">
   <div>
    <input type="text" value="请输入你需要的产品" class="selName" onFocus=OnEnter(this) onBlur=OnExit(this) />
    <input type="image" src="<%=path %>/images/sub.png" width="99" height="36" class="sel" />
   </div>
  </form><!--select/-->
  <div class="ban">
   <a href="<%=path %>/prolist.jsp"><img src="<%=path %>/images/phone.png" /></a>
  </div><!--ban/-->
 </div><!--inCont/-->
 <div class="footer">
  <a href="#">关于我们</a>
  <a href="#">友情链接</a>
  <a href="#">版权声明</a>
  <a href="#">网站地图</a>
  <br />
  <span>&copy; 2014 Unqezi 使用前必读 沪ICP备 12007626号-1</span>
 </div><!--footer/-->
</body>
</html>
