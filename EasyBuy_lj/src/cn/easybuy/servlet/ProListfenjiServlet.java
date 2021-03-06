package cn.easybuy.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.easybuy.entity.Page;
import cn.easybuy.entity.ProListfenji;
import cn.easybuy.entity.Prolist;
import cn.easybuy.service.ProListfenjiService;
import cn.easybuy.service.ProlistinfoService;
import cn.easybuy.service.impl.ProListfenjiServiceImpl;
import cn.easybuy.service.impl.prolistinfoServiceImpl;




public class ProListfenjiServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
            ProListfenjiService pro=new ProListfenjiServiceImpl();
            String action=request.getParameter("action");
            String name=request.getParameter("name");
            System.out.println("2222"+name);
            System.out.println(action);
           if("".equals(action)||action==null) {
           
            
            try {
				//获取到一级集合
				List<ProListfenji> menus1=pro.findAll();
				//获取到二级集合
				List<ProListfenji> menus2=null;
				//获取到三级集合
				List<ProListfenji> menus3=null;
				Map<Integer,List<ProListfenji>> map1 = new HashMap<Integer,List<ProListfenji>>();
				Map<Integer,List<ProListfenji>> map2 = new HashMap<Integer,List<ProListfenji>>();
 			    Set<Integer> set1=map1.keySet();  
				Set<Integer> set2=map2.keySet();  
				for(ProListfenji item1:menus1){
					menus2=pro.findPart(item1.getId());
					map1.put(item1.getId(), menus2);
					request.setAttribute("map1", map1);
					request.setAttribute("menus2", menus2);
				}
				for(Integer it:set1){
					for(ProListfenji item2:map1.get(it)){
						menus3=pro.findPart(item2.getId());
						map2.put(item2.getId(),menus3);
						request.setAttribute("map2", map2);
					}
				}
				
				for(Integer it:set2){
					for(ProListfenji item3:map2.get(it)){
						System.out.println(it+"---------"+item3.getParentId()+item3.getId()+"---------"+item3.getName());
					}
				}
				ProlistinfoService service=new prolistinfoServiceImpl();
	    		List<Prolist> list4=service.findAll();
	            request.setAttribute("list4", list4);
				request.getSession().setAttribute("menus1", menus1);
				request.getSession().setAttribute("set1", set1);
				request.getSession().setAttribute("set2", set2);
				request.getRequestDispatcher("/prolist.jsp?name="+name).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
            
           }else if("fenji".equals(action)){
            	String temp=request.getParameter("ntid");
				int totalrecord=0;
				try {
					totalrecord=pro.totalRecord();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				int pagesize=5;
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
					List<ProListfenji>list=null;
					if(temp==null||temp.equals("null")){
						try {
							list=pro.getOneDate(pageindex,pagesize);
						} catch (Exception e) {
							
							e.printStackTrace();
						}
					}
					page.setList(list);
					request.setAttribute("page", page);
					request.getRequestDispatcher("/Backstage/productClass.jsp").forward(request, response);
            }else if("showFenji".equals(action)){
            	System.out.println("sd");
            	try {
            		List<ProListfenji>list=pro.findAll();
            		
					request.setAttribute("list", list);
					
					request.getRequestDispatcher("/Backstage/productClass-add.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }else if("addfenji".equals(action)){
            	String parentName=request.getParameter("parentName");
            	String parentName2=request.getParameter("parentName2");
            	System.out.println(parentName);
            	System.out.println(parentName2);
            	String fenjiName=request.getParameter("className");
            	int frisrId=Integer.parseInt(parentName);
            	int secondId=Integer.parseInt(parentName2);
            	int typeId=0;
            	int parentId=0;
            	if("0".equals(parentName)){
            		typeId=1;
            	}else{
            		typeId=2;
            		parentId=frisrId;
            	}
            	
            	if("0".equals(parentName2)){
            		typeId=2;
            	}else{
            		typeId=3;
            		parentId=secondId;
            	}
            	if("0".equals(parentName2)&&"0".equals(parentName)){
            		typeId=1;
            	}
            	ProListfenji pfj=new ProListfenji();
            	pfj.setParentId(parentId);
            	pfj.setType(typeId);
            	pfj.setName(fenjiName);
            	try {
					boolean flag=pro.add(pfj);
					request.getRequestDispatcher("/servlet/ProListfenjiServlet?action=showFenji").forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	
            	
            	//根据一级找二级
            }else if("find".equals(action)){
            	response.setCharacterEncoding("utf-8");
            	int id=Integer.parseInt(request.getParameter("id"));
            	
            	try {
				List<ProListfenji>list=pro.findPart(id);
				Gson gson=new Gson();
				gson.toJson(list);
				response.getWriter().print(gson.toJson(list));
				} catch (Exception e) {
					
					e.printStackTrace();
				}
            }else if("del".equals(action)){
    			ProListfenjiService service=new ProListfenjiServiceImpl();
    			//接收传入的id
    			int id=Integer.parseInt(request.getParameter("id"));
    			boolean flag = service.del(id);
    			if(flag){
    				//转向serlvet
    				request.getRequestDispatcher("/servlet/ProListfenjiServlet?action=fenji").forward(request, response);
    			}
    		}
            
   }
            
            
           
    		
    	  
		
	}


