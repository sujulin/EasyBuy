package cn.easybuy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import cn.easybuy.dao.RegisterinfoDao;
import cn.easybuy.dao.UserinfoDao;
import cn.easybuy.dao.impl.RegisterinfoDaoimpl;
import cn.easybuy.dao.impl.UserinfoDaoimpl;
import cn.easybuy.entity.Address;
import cn.easybuy.entity.Userinfo;
import cn.easybuy.service.UserinfoService;
import cn.easybuy.service.impl.UserinfoServiceImpl;
public class UserinfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      
		String action = request.getParameter("action");
		System.out.println(action);
		String type=request.getParameter("type");
		System.out.println(type);
		if(action.equals("logout")){
			
			
			
			request.getRequestDispatcher("/servlet/UserinfoServlet?action=null").forward(request, response);
		}else if(action.equals("login")){
			
			
		//1.�������
		request.setCharacterEncoding("utf-8");
		//2.����service��Ķ���
		UserinfoService service=new UserinfoServiceImpl();
		//3.����service����
		String temp=request.getParameter("loginName");
		System.out.println(temp);
		
		if(temp!=null&&temp!=""){
		String loginName=request.getParameter("loginName");
		System.out.println(loginName);
		String password=request.getParameter("password");
	
		
		
		Userinfo info=new Userinfo();
		info.setLoginName(loginName);
        info.setPassword(password);
       
		try {
			boolean flag1 = service.login(info);
			if(flag1){
				System.out.println("5555");
				request.getSession().setAttribute("loginName",loginName);
				//request.getRequestDispatcher("/Backstage/index.jsp").forward(request, response);
				request.getRequestDispatcher("/servlet/UserinfoServlet?action=admin").forward(request, response);
			}else{
			boolean flag = service.islogin(info);
			//4.��ݷ�������ֵ���ж�        ת������  �ض����Ŀ��ҳ��
			if(flag){
				//��¼�ɹ�
				request.getRequestDispatcher("/servlet/UserinfoServlet?action=LoadUname").forward(request, response);
				//servlet/UserinfoServlet?action=back
			}else {
				//��¼ʧ��
				//ת�����㻹���¼�û���
				
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
	}
			
}else if ("LoadUname".equals(action)){
	
	String loginName = request.getParameter("loginName");
	System.out.println(loginName);
	request.setAttribute("loginName", loginName);
	request.getRequestDispatcher("/index.jsp").forward(request, response);
		
}else if ("update".equals(action)){
	
	/*System.out.println("8888");
	String loginName=request.getParameter("name");
	String password=request.getParameter("newpass");
	System.out.println(loginName+password);
	UserinfoService service=new UserinfoServiceImpl();
	Userinfo info=new Userinfo();
	info.setLoginName(loginName);
	info.setPassword(password);
	try {
		service.updatePassword(info);
		request.getRequestDispatcher("/adminjsp/index.jsp").forward(request, response);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
System.out.println("8888");
	
	
	//String loginName=request.getParameter("loginChenggong1");
	String loginChenggong1=request.getParameter("loginChenggong1");
	

	String password=request.getParameter("userpassword");
	
	
	System.out.println(loginChenggong1+"--------"+password);
	
	
	
	
	UserinfoService service=new UserinfoServiceImpl();
	Userinfo info=new Userinfo();
	info.setLoginName(loginChenggong1);
	info.setPassword(password);
	try {
		service.updatePassword(info);
		System.out.println(111);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	
    }else if("admin".equals(action)){
    	System.out.println("7---");
    	UserinfoService service=new UserinfoServiceImpl();
    	try {
			List<Userinfo>list=service.findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/Backstage/user.jsp").forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }else if("adminBack".equals(action)){
    	System.out.println("8==");
    	UserinfoService service=new UserinfoServiceImpl();
    	try {
			List<Userinfo>list=service.findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/Backstage/user.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }else if("adminDel".equals(action)){
    	int id=Integer.parseInt(request.getParameter("id"));
    	UserinfoService service=new UserinfoServiceImpl();
    	try {
			service.Deladmin(id);
			request.getRequestDispatcher("/servlet/UserinfoServlet?action=adminBack").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }else if("updateAdmin".equals(action)){
    	String name=request.getParameter("userName");
    	String passWord=request.getParameter("passWord");
    	String email=request.getParameter("email");
    	int mobile=Integer.parseInt(request.getParameter("mobile"));
    	int id=Integer.parseInt(request.getParameter("id"));
    	System.out.println(id);
    	Userinfo info=new Userinfo();
    	info.setId(id);
    	info.setEmail(email);
    	info.setLoginName(name);
    	info.setMobile(mobile);
    	info.setPassword(passWord);
    	UserinfoService service=new UserinfoServiceImpl();
    	try {
			service.Updateadmin(info);
			request.getRequestDispatcher("/servlet/UserinfoServlet?action=adminBack").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }else if("userByCar".equals(action)){
    	String name=request.getParameter("name");
    	UserinfoService service=new UserinfoServiceImpl();
    	try {
			List<Address>list=service.findAddressByName(name);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/car.jsp?name="+name).forward(request, response);
		} catch (Exception e) {
			
		}
    	
    }
	}

}
