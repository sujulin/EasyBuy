<%@page import="cn.easybuy.entity.OrderDetail"%>
<%@page import="cn.easybuy.dao.impl.OrderDetailDaoimpl"%>
<%@page import="cn.easybuy.dao.impl.OrderInfoDaoimpl"%>
<%@page import="cn.easybuy.entity.OrderInfo"%>
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

</head>

<body>
<%int count=0; %>
<%int count1=0; %>

 <div class="hrader" id="header">
  <div class="top">
   <a href="login.jsp" style="color:#C94E13;">请登录</a> 
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
     <dd class="ddCur"><a href="vipOrder.jsp">我的订单</a></dd>
     <dd><a href="vipShoucang.jsp">收藏关注</a></dd>
    <dt class="vip_2">账户设置</dt>
     <dd><a href="vip.jsp">个人信息</a></dd>
     <dd><a href="vipPwd.jsp">密码修改</a></dd>
     <dd><a href="vipAddress.jsp">收货地址</a></dd>
     <dd><a href="vipXiaofei.jsp">消费记录</a></dd>
    <dt class="vip_3">客户服务</dt>
     <dd><a href="vipQuxiao.jsp">取消订单/退货</a></dd>
     
     <dd><a href="vipTousu.jsp">我的投诉</a></dd>
   </dl><!--vipNav/-->
  </div><!--vipLeft/-->
  <div class="vipRight">
   <h2 class="vipTitle">我的订单</h2>
   
  
    <table class="vipOrder">
     <% 
     
    OrderDetailDaoimpl itemDao = new OrderDetailDaoimpl(); 
                OrderInfoDaoimpl itemsDao = new OrderInfoDaoimpl(); 
               List<OrderInfo> list = itemsDao.Select();
               List<OrderDetail> list1 = itemDao.SelectDetail();
              
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
   { 
	             OrderDetail item1 = list1.get(i);
	                 OrderInfo item = list.get(i);
           %>   
     <tr>
      <td><a href="proinfo.jsp"><img src="images/phone.png" width="60" height="55"></a></td>
      <td><%=item.getLoginName() %></td>
      <td><%=item.getCost() %><br />支付宝支付</td>
      <td><%=item.getCreateTime() %></td>
      <td><a href="success.jsp"><strong>
      <%if((item.getPayType().equals("1"))==true ){%><%count++; %>等待付款<%} %>
      <%if((item.getPayType().equals("2"))==true){ %><%count1++; %>已付款<%} %>
     
      </td> </strong></a></td>
      <td><a href="<%=path %>/vipXiaofei.jsp?id=<%=item1.getOrderId() %>">查看</a></td> 
     </tr>
    <%
    }
    }
     %>
      <h2 class="oredrName">
    我的订单 <span style="margin-left:40px;">待发货 <span class="red"><%=count %></span> </span>
    <span>待收货 <span class="red"><%=count1 %></span></span>
    </h2>
    </table><!--vipOrder/-->
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
