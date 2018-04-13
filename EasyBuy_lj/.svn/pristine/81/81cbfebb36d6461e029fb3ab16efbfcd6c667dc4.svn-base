package cn.easybuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	/**
		   Happy  微冷的雨
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
		 Happy  微冷的雨
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		/*	String uname = request.getParameter("uname");
			if("admin".equals(uname)){
				//������
				//����Ӧ����ô�죿
				//exists
				response.getWriter().write("exists");
			}else {
				response.getWriter().write(" not exists,can use");
	}*/
		
		String password = request.getParameter("password");
		
	
		String password1 = request.getParameter("password1");
		
		
		System.out.println(password);
		
		
		if(password1.equals(password)){
		

			response.getWriter().write("");
		}else{
			
			response.getWriter().write("密码不一致");
			
		}
		
	}

}



