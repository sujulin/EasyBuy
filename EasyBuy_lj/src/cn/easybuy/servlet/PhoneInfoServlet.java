package cn.easybuy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.easybuy.dao.PhoneInfoDao;
import cn.easybuy.dao.RegisterinfoDao;
import cn.easybuy.dao.impl.PhoneInfoDaoimpl;
import cn.easybuy.dao.impl.RegisterinfoDaoimpl;
import cn.easybuy.entity.Cart;
import cn.easybuy.entity.Page;
import cn.easybuy.entity.Phoneinfo;
import cn.easybuy.entity.ProListfenji;
import cn.easybuy.entity.Prolist;
import cn.easybuy.entity.Userinfo;
import cn.easybuy.service.PhoneInfoService;
import cn.easybuy.service.ProListfenjiService;
import cn.easybuy.service.ProlistinfoService;
import cn.easybuy.service.impl.PhoneInfoServiceimpl;
import cn.easybuy.service.impl.ProListfenjiServiceImpl;
import cn.easybuy.service.impl.prolistinfoServiceImpl;




public class PhoneInfoServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String action ; //表示购物车的动作 ,add,show,delete
	//商品业务逻辑类的对象
	private PhoneInfoDaoimpl idao = new PhoneInfoDaoimpl() ;
		
	public PhoneInfoServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
   doPost(request,response);
   
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
/*if(action==null||action.equals("null")){
			
			//1.字符集  查询操作 ，，不带条件查询 ，不用设置
			//2.获取从client 提交的数据    不用做的
			//3.创建service实现对象
			PhoneInfoService service=new PhoneInfoServiceimpl();
			//4.调度方法，根据结果，转发或者重定向页面
			try {
				
			Page page=new Page();
				
				
				//先后去nitd
				String ntid=request.getParameter("id");
				int pageSize = 0;
				int totalCount = 0;
				int tid;
				if (ntid==null || ntid.equals("")) {
					//用户没有按分类查询
					pageSize=3;
					totalCount = service.getTotalCount();
				}else {
					//点击了分类
					pageSize=2;
					tid=Integer.parseInt(ntid);
					totalCount = service.getTotalCountByTid(tid);
				}
				//什么值  pageSize
				
				page.setPageSize(pageSize);
				//总记录数
				
				page.setTotalRecords(totalCount);
				//总页数
				int totalPages=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
				page.setTotalPages(totalPages);
				int pageIndex=1;
				if(request.getParameter("pageIndex")!=null&&request.getParameter("pageIndex")!=""){
					try{
						pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
					}catch(Exception ex){
						pageIndex=1;
					}
				}
				
				if(pageIndex>=totalPages){
					pageIndex=totalPages;
				}
				if(pageIndex<=0){
					pageIndex=1;
				}
				
				page.setPageIndex(pageIndex);
			
			
				List<Phoneinfo> list=null;
				if (ntid==null || ntid.equals("")) {
					//用户没有按分类查询
					list = service.getOnePage(pageIndex, pageSize);
				}else {
					tid=Integer.parseInt(ntid);
					list = service.getOnePageData(pageIndex, pageSize,tid);
				}
				
				
				
				page.setList(list);
				
				//非常重要的操作
				//你必须把泛型放入作用域，否则不能再界面上获取到数据
				//作用域：A类  要想和B类共享数据 ，，作用域能帮我们实现 
				//reqeust   还是Session？选择是痛苦的
				request.setAttribute("page", page);
				
		
		
		
		
		*/

		
		System.out.println("22222");
		System.out.println(action);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		 PhoneInfoService pro=new PhoneInfoServiceimpl();
		if(request.getParameter("action")!=null)
		{
			this.action = request.getParameter("action");
			if(action.equals("add")) //如果是添加商品进购物车
			{
				System.out.println("add");
				if(addToCart(request,response))
				{
					System.out.println("成功");
					request.getRequestDispatcher("/buyinfo.jsp?name="+name).forward(request, response);
				}
				else
				{
					System.out.println("失败");
					request.getRequestDispatcher("/failure.jsp?name="+name).forward(request, response);
				}
			}
			if(action.equals("show"))//如果是显示购物车
			{
				request.getRequestDispatcher("/car.jsp").forward(request, response);
			}
			if(action.equals("delete")) //如果是执行删除购物车中的商品
			{
				if(deleteFromCart(request,response))
				{
					request.getRequestDispatcher("/car.jsp").forward(request, response);
				}
				else
				{
					request.getRequestDispatcher("/car.jsp").forward(request, response);
				}
			
		
			}
			
			
			if("fenji".equals(action)){
	        	String temp=request.getParameter("ntid");
				int totalrecord=0;
				try {
					totalrecord=pro.getTotalCount();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				int pagesize=3;
				Page page=new Page();
				page.setPagesize(pagesize);
				page.setTotalrecord(totalrecord);
				int totalpage=totalrecord%pagesize==0?totalrecord/pagesize:totalrecord/pagesize+1;
				page.setTotalpage(totalpage);
				int pageindex=1;
				if(request.getParameter("pageindex")!=null&&request.getParameter("pageindex")!=""){
					 pageindex=Integer.parseInt( request.getParameter("pageindex"));
					}
					if(pageindex>=totalpage){
						pageindex=totalpage;
					}
					
					page.setPageindex(pageindex);
					List<Phoneinfo>list=null;
					if(temp==null||temp.equals("null")){
						try {
							list=pro.getOnePage(pageindex, pagesize);
						} catch (Exception e) {
							
							e.printStackTrace();
						}
					}
					page.setList1(list);
					request.setAttribute("page", page);
					request.getRequestDispatcher("/sell.jsp").forward(request, response);
	        }
		
		}
			
}
	/*		 catch (Exception e) {
	e.printStackTrace();


			 }

}*/

/*}*/

	
	
	
	
	
	private boolean addToCart(HttpServletRequest request, HttpServletResponse response)
	{
		
		System.out.println(action);
		String id = request.getParameter("id");
		System.out.println(id);
		String number = request.getParameter("num");
		System.out.println(number);
		Phoneinfo item = idao.getItemsById(Integer.parseInt(id));
		 PhoneInfoService pro=new PhoneInfoServiceimpl();
		
		
		//是否是第一次给购物车添加商品,需要给session中创建一个新的购物车对象
		if(request.getSession().getAttribute("cart")==null)
		{
			Cart cart = new Cart();
			request.getSession().setAttribute("cart",cart);
		}
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(cart.addGoodsInCart(item, Integer.parseInt(number)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
		
		
		

        
	}
	
	//从购物车中删除商品
	private boolean deleteFromCart(HttpServletRequest request, HttpServletResponse response)
	{
		String id = request.getParameter("id");
		Cart cart = (Cart)request.getSession().getAttribute("cart");
	   Phoneinfo item = idao.getItemsById(Integer.parseInt(id));
	    if(cart.removeGoodsFromCart(item))
	    {
	    	return true;
	    }
	    else
	    {
	    	return false;
	    }
	
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	
	
	
	
	
	
	
	
	
	
	

}
