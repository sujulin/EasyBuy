<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>unique</title>
<link type="text/css" href="css/css.css" rel="stylesheet" />
<script type="text/javascript" src="js/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/js.js"></script>
<script type="text/javascript" src="js/jQuery1.11.1.js"></script>
	<script type="text/javascript">
	   $(function(){
		   $("[name=userpassword2]").blur(function(){
			   var myval=$("[name=userpassword2]").val();
			    var myval2=$("[name=userpassword]").val();
			 // oldAjax();`
			   $.ajax(
					   {
						   
						   url:"<%=path%>/servlet/FirstServlet1?userpassword2="+myval+"&userpassword="+myval2,
						 
						   type:"get",
						   async:true,
						   success:function(data){
							   $("#msg").html(data);
						   }
						   
					   }
					  );
		   });
	   });
	   function oldAjax(){
		   //构建一个请求
		   //1.准备一个核心对象      进行真正的Ajax请求的发送  XMLHttpRequest
		   var xhr=null;
		   //根据不同的浏览器，能力检测 。不同的浏览器   有没有这个对象，不一定
		   if(window.XMLHttpRequest){  //证明是非IE浏览器 chrome firefox
			   xhr=new XMLHttpRequest();
		   }else{
			  //低版本的IE浏览器  微软那一套
			  xhr=new ActiveXObject("Microsoft.XMLHTTP");
		   }
		   
		   //2.属性  方法  事件构建请求
		   xhr.open("get","<%=path%>/servlet/FirstServlet1?userpassword2="+$("[userpassword2]").val(),true);
		 
		   //3.状态改变  事件
		   xhr.onreadystatechange=function(){
			   if(xhr.readyState==4&&xhr.status==200){
				   //成功接收到响应数据
				   
				   //谁能告诉我？？？？响应数据怎么拿？
				  var data= xhr.responseText;
				   $("#msg").html(data);
			   }
		   };
		   //最终的发送  get请求 null
		   xhr.send(null);
	   }
	</script>
<script type="text/javascript">
	function reloadCode(){
	var time=new Date().getTime();
	document.getElementById("imagecode").src="<%=request.getContextPath()%>/servlet/ImageServlet?d="+time; 
	}
	

   
	
	</script>

</head>

<body>
<%
String loginChenggong1=request.getParameter("loginChenggong1");

request.setAttribute("loginChenggong1", loginChenggong1);
 %>
 <div class="hrader" id="header">
  <div class="top">
   <a href="login.jsp" style="color:#C94E13;"><%if(loginChenggong1!=null){ %>       <%=loginChenggong1 %><%} %><%else{ %>请登录<%} %></a> 
   <a href="reg.jsp">注册</a>
   <ul class="topNav">
    <li><a href="order.jsp">我的订单 </a></li>
    <li class="gouwuche"><a href="car.jsp">购物车</a> <strong style="color:#C94E13;">3</strong></li>
    <li class="shoucangjia"><a href="shoucang.jsp">收藏夹</a></li>
    <li class="kefus"><a href="#">联系客服</a></li>
<li><a href="#" class="lan">中文</a></li>
    <li><a href="#" class="lan">English</a></li>
    <div class="clears"></div>
   </ul><!--topNav/-->
  </div><!--top/-->
 </div><!--hrader/-->
 <div class="mid">
  <h1 class="logo" style="text-align:left;">
  <a href="index.jsp"><img src="images/logo.png" width="304" height="74" /></a>
  </h1>
  <form action="#" method="get" class="subBox">
   <div class="subBox2">
    <input type="text" class="subText" />
    <input type="image" src="images/sub.jpg" width="95" height="32" class="subImg" />
    <div class="hotci">
    <a href="#">酷派大神</a>
    <a href="#">三星s5</a>
    <a href="#">诺基亚1020</a>
    <a href="#">Iphone 6</a>
    <a href="#">htc one</a>
   </div><!--hotci/-->
   </div><!--subBox2/-->
  </form><!--subBox/-->
  <div class="ding-gou">
   <div class="ding">
    <a href="order.jsp"><img src="images/dingdan.jpg" width="106" height="32" /></a>
   </div><!--ding/-->
   <div class="gou">
    <a href="car.jsp"><img src="images/gouwuche.jpg" width="126" height="32" /></a>
   </div><!--gou/-->
   <div class="clears"></div>
  </div><!--ding-gou/-->
 </div><!--mid-->
 <div class="navBox navBg3">
  <ul class="nav">
   <li><a href="index.jsp">首页</a></li>
   <li><a href="buy.jsp">买家</a></li>
   <li><a href="sell.jsp">卖家</a></li>
   <li class="navCur"><a href="vip.jsp">会员中心</a></li>
   <li><a href="xuanshang.jsp">悬赏榜</a></li>
   <li><a href="luntan.jsp" class="luntan">论坛</a></li>
   <li><a href="help.jsp">帮助</a></li>
   <div class="clears"></div>
  </ul><!--nav/-->
 </div><!--navBox/-->
 <div class="vipBox">
  <div class="vipLeft">
   <h2 class="headImg"><img src="images/vipImg.jpg" width="183" height="169" /></h2>
   <h3 class="vipName">测试webqin</h3>
   <dl class="vipNav">
    <dt class="vip_1 vipCur">买家中心</dt>
     <dd><a href="vipOrder.jsp">我的订单</a></dd>
     <dd><a href="vipShoucang.jsp">收藏关注</a></dd>
    <dt class="vip_2">账户设置</dt>
     <dd><a href="vip.jsp">个人信息</a></dd>
     <dd class="ddCur"><a href="vipPwd.jsp">密码修改</a></dd>
     <dd><a href="vipAddress.jsp">收货地址</a></dd>
     <dd><a href="vipXiaofei.jsp">消费记录</a></dd>
    <dt class="vip_3">客户服务</dt>
     <dd><a href="vipQuxiao.jsp">取消订单/退货</a></dd>
     
     <dd><a href="vipTousu.jsp">我的投诉</a></dd>
   </dl><!--vipNav/-->
  </div><!--vipLeft/-->
  <div class="vipRight">
   <h2 class="vipTitle">密码修改</h2>
   
   <form action="<%=path %>/servlet/UserinfoServlet?action=update&loginChenggong1=<%=loginChenggong1 %>" class="registerform" method="post">
      <table class="grzx" width="705" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="90">新密码：</td>
          <td width="430"><input type="text" class="text inputxt" name="userpassword" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！" /></td>
          <td rowspan="4" valign="top"><div id="tx"><img src="images/vipImg.jpg" /></div></td>
        </tr>
        <tr>
          <td>确认密码：</td>
          <td><input type="text" class="text inputxt"  name="userpassword2" datatype="*" recheck="userpassword" nullmsg="请再输入一次密码！" errormsg="您两次输入的账号密码不一致！"  /><span id="msg"></span></td>
        </tr>
         <tr>
          <td>验证码：</td>
          <td><input name="" type="text" class="text2" />&nbsp;&nbsp;<img alt="验证码" id="imagecode" src="<%=request.getContextPath() %>/servlet/ImageServlet" width="100" height="22"/>
      <a href="javascript:reloadCode()"><span>换一张</span></a></td>
          
          
     
      
          
          
          
          
          
        </tr>
        <tr>
          <td><input name="" value="马上修改" type="submit" class="submit" /></td>
          <td></td>
        </tr>
      </table>
      </form>
  </div><!--vipRight/-->
  <div class="clears"></div>
 </div><!--vipBox/-->
 <div class="footBox">
  <div class="footers">
   <div class="footersLeft">
    <a href="index.jsp"><img src="images/ftlogo.jpg" width="240" height="64" /></a>
    <h3 class="ftphone">400 000 0000 </h3>
    <div class="ftKe">
     客服 7x24小时(全年无休)<br />
     <span>客服邮箱：kefu@webqin.net </span>
    </div><!--ftKe/-->
   </div><!--footersLeft/-->
   <div class="footersRight">
    <ul>
     <li class="ftTitle">新手指南</li>
     <li><a href="#">购物流程</a></li>
     <li><a href="#">会员计划及划分</a></li>
     <li><a href="#">优惠券规则</a></li>
     <li><a href="#">联系客服</a></li>
     <li><a href="#">常见问题</a></li>
    </ul>
    <ul>
     <li class="ftTitle">付款方式</li>
     <li><a href="#">在线支付</a></li>
     <li><a href="#">礼品卡支付</a></li>
     <li><a href="#">货到付款</a></li>
     <li><a href="#">银行付款</a></li>
    </ul>
    <ul>
     <li class="ftTitle">配送服务</li>
     <li><a href="#">配送时效及运费</a></li>
     <li><a href="#">超时赔付</a></li>
     <li><a href="#">验货与签收</a></li>
     <li><a href="#">配货信息跟踪</a></li>
    </ul>
    <ul>
     <li class="ftTitle">售后服务</li>
     <li><a href="#">退换货政策</a></li>
     <li><a href="#">退换货区域</a></li>
     <li><a href="#">退款时限</a></li>
     <li><a href="#">先行赔付</a></li>
     <li><a href="#">发票说明</a></li>
    </ul>
    <ul>
     <li class="ftTitle">特色服务</li>
     <li><a href="#">礼品卡</a></li>
     <li><a href="#">产品试用</a></li>
     <li><a href="#">花粉中心</a></li>
     <li><a href="#">快速购物</a></li>
     <li><a href="#">推荐好友</a></li>
    </ul>
    
    <div class="clears"></div>
   </div><!--footersRight/-->
   <div class="clears"></div>
  </div><!--footers/-->
 </div><!--footBox/-->
 <div class="footer" style="text-align:left;">
  <a href="#">关于我们</a>
  <a href="#">友情链接</a>
  <a href="#">版权声明</a>
  <a href="#">网站地图</a>
  <br />
  <span>&copy; 2014 Unqezi 使用前必读 沪ICP备 12007626号-1</span>
 </div><!--footer/-->
</body>
</html>
