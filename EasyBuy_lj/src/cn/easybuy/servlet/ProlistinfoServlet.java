package cn.easybuy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.dao.impl.ProlistinfoDaoimpl;
import cn.easybuy.entity.Prolist;
import cn.easybuy.service.ProlistinfoService;
import cn.easybuy.service.impl.prolistinfoServiceImpl;


public class ProlistinfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           request.setCharacterEncoding("utf-8");
           response.setCharacterEncoding("utf-8");
           List<Prolist> list4=null;
		ProlistinfoService service=new prolistinfoServiceImpl();
		
		String action=request.getParameter("action");
		System.out.println(action);
		
		if("find".equals(action)){
			
			String temp=request.getParameter("name");
			String name=new String(temp.getBytes("iso-8859-1"),"utf-8");
			System.out.println(name);
			try {
				list4=service.findByName(name);
				request.setAttribute("list4", list4);
				request.getRequestDispatcher("/prolist.jsp").forward(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if("".equals(action)||action==null){
			try{
				list4=service.findAll();
				request.setAttribute("list4", list4);
				request.getRequestDispatcher("/prolist.jsp").forward(request,response);
			
		}catch(SQLException e){
			e.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		}else if("findByPrice".equals(action)){
			System.out.println("ok");
		}
		
		
	}

}
