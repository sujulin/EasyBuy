package cn.easybuy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.OrderInfo;
import cn.easybuy.service.OrderInfoService;
import cn.easybuy.service.impl.OrderInfoServiceimpl;

public class OrderInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String action=request.getParameter("action");
		System.out.println(action);
		

			System.out.println("111111");
			if("".equals(action)||action==null){
			
			try {
				OrderInfoService service=new OrderInfoServiceimpl();
				List<OrderInfo> list = service.Select();
				
				request.setAttribute("list", list);
				request.getRequestDispatcher("/vipOrder.jsp").forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			}
		
	}

}
