<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
  <script type="text/javascript" src="js/jQuery1.11.1.js"></script>
	<script type="text/javascript">
	   $(function(){
		   $("[name=password1]").blur(function(){
			   var myval=$("[name=password1]").val();
			    var myval2=$("[name=password]").val();
			 // oldAjax();`
			   $.ajax(
					   {
						   
						   url:"<%=path%>/servlet/FirstServlet?password1="+myval+"&password="+myval2,
						 
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
		   xhr.open("get","<%=path%>/servlet/FirstServlet?password1="+$("[name=password1]").val(),true);
		 
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
	
	function reloadCode1(){
	var time=new Date().getTime();
	document.getElementById("imagecode1").src="<%=request.getContextPath()%>/servlet/ImageServlet?d="+time; 
	}
	

   
	
	</script>
	
	
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>unique</title>
<link type="text/css" href="<%=path%>/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=path%>/js/js.js"></script>
</head>

<body>
 <div class="hrader" id="header">
  <a href="<%=path%>/login.jsp" style="color:#FD7306;margin-left:20px;">请登录</a> 
  <a href="<%=path%>/reg.jsp">注册</a>
  <div class="topNav">
   <a href="<%=path%>/index.jsp" style="color:#FD7306;">首页</a>
   <a href="<%=path%>/buy.jsp">买家</a>
   <a href="<%=path%>/sell.jsp">卖家</a>
   <a href="<%=path%>/vip.jsp">会员中心</a>
   <a href="<%=path%>/xuanshang.jsp">悬赏榜</a>
   <a href="<%=path%>/luntan.jsp" class="luntan">论坛</a>
   <a href="<%=path%>/help.jsp">帮助</a>
   <a href="#">&nbsp;</a>
   <a href="#" class="lan">中文</a>
   <a href="#" class="lan">English</a>
  </div><!--topNav/-->
 </div><!--hrader/-->
 <div class="mainCont">
  <h1 class="logo" style="text-align:left;">
  <a href="<%=path%>/index.jsp"><img src="<%=path%>/images/logo.png" width="304" height="74" /></a>
  </h1>
  <div class="loginBuy">
  <div class="loginBuyLeft">
   <ul class="regEq">
    <li class="regEqBg1">供应商</li>
    <li class="regEqBg2">采购商</li>
    <div class="clears"></div>
   </ul><!--regEq/-->
   
   
   
   <form action="<%=path%>/servlet/RegisterinfoServlet?action=regist" method="post" class="regForm">
    <div class="loginBuyList">
     <label for="name" >用户名：</label>
     <input type="text" id="name" name="loginName"/>
    </div><!--loginBuyList/-->
    <div class="loginBuyList">
     <label for="email" >邮箱：</label>
     <input type="text" id="email" name="email"/>
    </div><!--loginBuyList/-->
    <div class="loginBuyList">
     <label for="tel" >手机号码：</label>
     <input type="text" id="tel" name="mobile"/>
    </div><!--loginBuyList/-->
    <div class="loginBuyList" >
     <label for="pwd">设置密码：</label>
     <input type="password" id="pwd" name="password"/>
    </div><!--loginBuyList/-->
    <div class="loginBuyList" style="border:#DEDEDE 1px solid;">
     <label for="pwd1">确认密码：</label>
    
     <input type="password" id="pwd1" name="password1"/> 
    
    
    </div>
 
     <span id="msg"></span>
    
    
    
   
    <!--loginBuyList/-->
    
    
    
     <div class="loginBuyyan">
     <label for="yanzheng">验证码：</label>
     <input type="text" name="checkScode" id="yanzheng" />
     <div class="yanzhengma">
      <img alt="验证码" id="imagecode" src="<%=request.getContextPath() %>/servlet/ImageServlet" width="124" height="52"/>
      <a href="javascript:reloadCode()"><span>换一张</span></a>
     </div>
     
     
    
     
     
     
     
     
     
     
     
     
    </div><!--loginBuyList/-->
    <div class="falv">
     <input type="checkbox" /> <span>我已阅读并同意<a href="xieyi.jsp" target="_blank">《uniqueZi协议》</a></span>
    </div><!--falv/-->
    <div class="regSubs">
     <input type="submit" value=" 注 册 " onclick="regist()" />
    </div><!--regSub/-->
   </form><!--/-->
   
   <form action="" method="post" class="regForm">
    <div class="loginBuyList">
     <label for="name" >用户名：</label>
     <input type="text" id="name" />
    </div><!--loginBuyList/-->
    <div class="loginBuyList">
     <label for="email">邮箱：</label>
     <input type="text" id="email" />
    </div><!--loginBuyList/-->
    <div class="loginBuyList">
     <label for="tel">手机号码：</label>
     <input type="text" id="tel" />
    </div><!--loginBuyList/-->
    <div class="loginBuyList">
     <label for="pwd">设置密码：</label>
     <input type="text" id="pwd" />
    </div><!--loginBuyList/-->
    <div class="loginBuyList" style="border:#DEDEDE 1px solid;">
     <label for="pwd1">确认密码：</label><span id="m"></span>
     <input type="text" id="pwd1" />
    </div><!--loginBuyList/-->
    
    
    


 <div class="loginBuyyan">
     <label for="yanzheng">验证码：</label>
     <input type="text" id="yanzheng" />
     <div class="yanzhengma">
      <img alt="验证码" id="imagecode1" src="<%=request.getContextPath() %>/servlet/ImageServlet" width="124" height="52"/>
      <a href="javascript:reloadCode1()"><span>换一张</span></a>
     </div>
     


    
    
    
     
    </div><!--loginBuyList/-->
    <div class="falv">
     <input type="checkbox" /> <span>我已阅读并同意<a href="<%=path%>/xieyi.jsp" target="_blank">《uniqueZi协议》</a></span>
    </div><!--falv/-->
    <div class="regSubs">
     <input type="submit" value=" 注 册 " />
    </div><!--regSub/-->
    
   </form><!--/-->
  </div><!--loginBuyLeft-->
  <div class="loginBuyRight">
   <div class="regDl">
    <a href="<%=path%>/login.jsp"><img src="<%=path%>/images/dl.jpg" width="180" height="60" /></a>
    <p>已有<a href="<%=path%>/login.jsp">供应商</a>账号点击登录！</p>
   </div><!--regDl/-->
   <div class="regDl">
    <a href="<%=path%>/login.jsp"><img src="<%=path%>/images/dl.jpg" width="180" height="60" /></a>
    <p>已有<a href="<%=path%>/login.jsp">采购商</a>账号点击登录！</p>
   </div><!--regDl/-->
  </div><!--loginBuyRight/-->
  <div class="clears"></div>
  </div><!--loginBuy/-->
 </div><!--mainCont/-->
 <div class="footBox">
  <div class="footers">
   <div class="footersLeft">
    <a href="<%=path%>/index.jsp"><img src="<%=path%>/images/ftlogo.jpg" width="240" height="64" /></a>
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
