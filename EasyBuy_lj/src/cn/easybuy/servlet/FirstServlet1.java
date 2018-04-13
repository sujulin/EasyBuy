package cn.easybuy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet1 extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String userpassword = request.getParameter("userpassword");
		
	
		String userpassword2 = request.getParameter("userpassword2");
		
		
		System.out.println(userpassword);
		
		
		if(userpassword2.equals(userpassword)){
		

			response.getWriter().write("");
		}else{
			
			response.getWriter().write("俩次密码不一致");
			
		}
		
	}

}



