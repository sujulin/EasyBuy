
<%@page import="cn.easybuy.entity.Page"%>
<%@page import="cn.easybuy.dao.impl.PhoneInfoDaoimpl"%>
<%@page import="cn.easybuy.entity.Phoneinfo"%>
<%@page import="cn.easybuy.entity.Cart"%>
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
<link type="text/css" href="<%=path %>/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="<%=path %>/js/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/js.js"></script>

</head>

<body>
 <div class="hrader" id="header">
  <div class="top">
   <a href="<%=path %>/login.jsp" style="color:#C94E13;">请登录</a> 
   <a href="<%=path %>/reg.jsp">注册</a>
   <ul class="topNav">
    <li><a href="<%=path %>/order.jsp">我的订单 </a></li>
    <li class="gouwuche"><a href="<%=path %>/car.jsp">购物车</a> <strong style="color:#C94E13;">3</strong></li>
    <li class="shoucangjia"><a href="<%=path %>/vipShoucang.jsp">收藏夹</a></li>
    <li class="kefus"><a href="#">联系客服</a></li>
<li><a href="#" class="lan">中文</a></li>
    <li><a href="#" class="lan">English</a></li>
    <div class="clears"></div>
   </ul><!--topNav/-->
  </div><!--top/-->
 </div><!--hrader/-->
 <div class="mid">
  <h1 class="logo" style="text-align:left;">
  <a href="<%=path %>/index.jsp"><img src="<%=path %>/images/logo.png" width="304" height="74" /></a>
  </h1>
  <form action="#" method="get" class="subBox">
   <div class="subBox2">
    <input type="text" class="subText" />
    <input type="image" src="<%=path %>/images/sub.jpg" width="95" height="32" class="subImg" />
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
    <a href="<%=path %>/order.jsp"><img src="<%=path %>/images/dingdan.jpg" width="106" height="32" /></a>
   </div><!--ding/-->
   <div class="gou">
    <a href="<%=path %>/car.jsp"><img src="<%=path %>/images/gouwuche.jpg" width="126" height="32" /></a>
   </div><!--gou/-->
   <div class="clears"></div>
  </div><!--ding-gou/-->
 </div><!--mid-->
 <div class="navBox navBg2">
  <ul class="nav">
   <li><a href="<%=path %>/index.jsp">首页</a></li>
   <li><a href="<%=path %>/buy.jsp">买家</a></li>
   <li class="navCur"><a href="<%=path %>/sell.jsp">卖家</a></li>
   <li><a href="<%=path %>/vip.jsp">会员中心</a></li>
   <li><a href="<%=path %>/xuanshang.jsp">悬赏榜</a></li>
   <li><a href="<%=path %>/luntan.jsp" class="luntan">论坛</a></li>
   <li><a href="<%=path %>/help.jsp">帮助</a></li>
   <div class="clears"></div>
  </ul><!--nav/-->
 </div><!--navBox/-->
 <div class="banner">
  <div class="banLeft">
   <div class="focus">
    <ul class="rslides f426x240">
        <li><a href="#"><img src="<%=path %>/images/banner.jpg" width="750" height="300"  /></a></li>
        <li><a href="#"><img src="<%=path %>/images/banner.jpg" /></a></li>
        <li><a href="#"><img src="<%=path %>/images/banner.jpg" /></a></li>
        <li><a href="#"><img src="<%=path %>/images/banner.jpg" /></a></li>
        <li><a href="#"><img src="<%=path %>/images/banner.jpg" /></a></li>
    </ul>
   </div><!--focus/-->
  </div><!--banLeft/-->
  <div class="banRight">
   <img src="<%=path %>/images/xinpin.jpg" width="195" height="57" />
   <div class="newPhone"><img src="<%=path %>/images/newphone.jpg" width="87" height="163" /></div>
   <div class="phonePar">
    <span>华为荣耀6 H60-L01 移动4G</span><br />
    <strong class="cheng">￥2099</strong> <span class="hui">￥3099</span>
   </div><!---->
  </div><!--banRight/-->
  <div class="clears"></div>
 </div><!--banner/-->
 <div class="proBox">
  <ul class="proSelect">
   <li>功能机 &darr;</li>
   <li>智能机 &darr;</li>
   <li>原器件 &darr;</li>
   <li>其他 &darr;</li>
   <div class="clears"></div>
  </ul><!--proSelect/-->
  <div class="sells">
  
  
  
   <%-- 
    <%
				   //首先判断session中是否有购物车对象
				   if(request.getSession().getAttribute("cart")!=null)
				   {
				%>
    
    
    <!-- 循环的开始 -->
				     <% 
				         Cart cart = (Cart)request.getSession().getAttribute("cart");
				         HashMap<Phoneinfo,Integer> goods = cart.getGoods();
				         Set<Phoneinfo> items = goods.keySet();
				         Iterator<Phoneinfo> it = items.iterator();
				         
				         while(it.hasNext())
				         {
				            Phoneinfo i = it.next();
				     %> 
  
   --%>
   
   <% 
                PhoneInfoDaoimpl itemsDao = new PhoneInfoDaoimpl(); 
               ArrayList<Phoneinfo> list = itemsDao.getAllItems();
               Page page2=(Page)request.getAttribute("page");
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               { 
	             
	                  Phoneinfo item = list.get(i);
           %>   
   <dl>
    <dt><a href="<%=path %>/buyinfo.jsp?id=<%=item.getPid() %>"><img src="<%=path %>/images/<%=item.getFilename() %>" width="140" height="140" /></a></dt>
    <dd>
     <h3><a href="<%=path %>/buyinfo.jsp?id=<%=item.getPid() %>"><%=item.getName() %></a></h3>
     <h4><%=item.getDescription() %></h4>
     <h5>抢 购 价：<span><%=item.getPrice() %></span> (降价通知)</h5>
     <div class="tishi">
      <span>温馨提示：</span>
     </div>
     <div class="sellmails">
      <a href="quanjing/index.jsp">选用此模型</a>
      <a class="sellmai" href="<%=path %>/buyinfo.jsp?id=<%=item.getPid() %>">立即购买</a>
     </div><!--sellmails/-->
    </dd>
    <div class="clears"></div>
   </dl>
  <!--  <dl>
    <dt><a href="buyinfo.jsp"><img src="images/sell.jpg" width="140" height="140" /></a></dt>
    <dd>
     <h3><a href="buyinfo.jsp">三星手机 S5SM-G9006V (闪耀白)</a></h3>
     <h4>国行正品，机打发票，延长一年保修！S5联通版，防水防尘加指纹机密，机皇就是这么拽！</h4>
     <h5>抢 购 价：<span>￥3555.00</span> (降价通知)</h5>
     <div class="tishi">
      <span>温馨提示：</span>
     </div>
     <div class="sellmails">
      <a href="quanjing/index.jsp">选用此模型</a>
      <a class="sellmai" href="buyinfo.jsp">立即购买</a>
     </div>sellmails/
    </dd>
    <div class="clears"></div>
   </dl>
   <dl>
    <dt><a href="buyinfo.jsp"><img src="images/sell.jpg" width="140" height="140" /></a></dt>
    <dd>
     <h3><a href="buyinfo.jsp">三星手机 S5SM-G9006V (闪耀白)</a></h3>
     <h4>国行正品，机打发票，延长一年保修！S5联通版，防水防尘加指纹机密，机皇就是这么拽！</h4>
     <h5>抢 购 价：<span>￥3555.00</span> (降价通知)</h5>
     <div class="tishi">
      <span>温馨提示：</span>
     </div>
     <div class="sellmails">
      <a href="quanjing/index.jsp">选用此模型</a>
      <a class="sellmai" href="buyinfo.jsp">立即购买</a>
     </div>sellmails/
    </dd>
    <div class="clears"></div>
   </dl>
   <dl>
    <dt><a href="buyinfo.jsp"><img src="images/sell.jpg" width="140" height="140" /></a></dt>
    <dd>
     <h3><a href="buyinfo.jsp">三星手机 S5SM-G9006V (闪耀白)</a></h3>
     <h4>国行正品，机打发票，延长一年保修！S5联通版，防水防尘加指纹机密，机皇就是这么拽！</h4>
     <h5>抢 购 价：<span>￥3555.00</span> (降价通知)</h5>
     <div class="tishi">
      <span>温馨提示：</span>
     </div>
     <div class="sellmails">
      <a href="quanjing/index.jsp">选用此模型</a>
      <a class="sellmai" href="buyinfo.jsp">立即购买</a>
     </div>sellmails/
    </dd>
    <div class="clears"></div>
   </dl>
   <dl>
    <dt><a href="buyinfo.jsp"><img src="images/sell.jpg" width="140" height="140" /></a></dt>
    <dd>
     <h3><a href="buyinfo.jsp">三星手机 S5SM-G9006V (闪耀白)</a></h3>
     <h4>国行正品，机打发票，延长一年保修！S5联通版，防水防尘加指纹机密，机皇就是这么拽！</h4>
     <h5>抢 购 价：<span>￥3555.00</span> (降价通知)</h5>
     <div class="tishi">
      <span>温馨提示：</span>
     </div>
     <div class="sellmails">
      <a href="quanjing/index.jsp">选用此模型</a>
      <a class="sellmai" href="buyinfo.jsp">立即购买</a>
     </div>sellmails/
    </dd>
    <div class="clears"></div>
   </dl>
   <dl>
    <dt><a href="buyinfo.jsp"><img src="images/sell.jpg" width="140" height="140" /></a></dt>
    <dd>
     <h3><a href="buyinfo.jsp">三星手机 S5SM-G9006V (闪耀白)</a></h3>
     <h4>国行正品，机打发票，延长一年保修！S5联通版，防水防尘加指纹机密，机皇就是这么拽！</h4>
     <h5>抢 购 价：<span>￥3555.00</span> (降价通知)</h5>
     <div class="tishi">
      <span>温馨提示：</span>
     </div>
     <div class="sellmails">
      <a href="quanjing/index.jsp">选用此模型</a>
      <a class="sellmai" href="buyinfo.jsp">立即购买</a>
   
      
     </div> --><!--sellmails/-->
   
  <%--    <%
   }
   
    %> --%>
 <br />
   <%
        	}
       
        %>
   <div class="badoo"><span class="disabled"> <  Prev</span><span class="current">1</span><a href="#?page=2">2</a><a href="#?page=3">3</a><a href="#?page=4">4</a><a href="#?page=5">5</a><a href="#?page=6">6</a><a href="#?page=7">7</a>...<a href="#?page=199">199</a><a href="#?page=200">200</a>
   
   <a href="<%=path %>/servlet/PhoneInfoServlet?action=fenji&pageindex=<%=1+1%>">Next  > </a></div>
   
  <%
  }
   %>
  
  
  </div><!--sells/-->
 
  
 </div><!--proBox/-->
 <div class="footBox">
  <div class="footers">
   <div class="footersLeft">
    <a href="<%=path %>/index.jsp"><img src="<%=path %>/images/ftlogo.jpg" width="240" height="64" /></a>
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
