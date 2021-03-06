package cn.easybuy.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import org.junit.Test;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.ProListfenjiDao;
import cn.easybuy.entity.ProListfenji;
import cn.easybuy.util.MyTool;


public class ProListfenjiDaoimpl extends BaseDao implements ProListfenjiDao {

	public List<ProListfenji> findAll() throws Exception {
	    String sql="SELECT * FROM easybuy_product_category WHERE TYPE=1";
	    ResultSet rs=executeQuery(sql);
	    List<ProListfenji>list= MyTool.tool(rs,ProListfenji.class);
		return list;
	}

	public List<ProListfenji> findPart(int id) throws Exception {
		 String sql="SELECT * FROM easybuy_product_category WHERE parentId=? ORDER BY id";
		 Object[] paras = {id};
		 ResultSet rs=executeQuery(sql,paras);
		 List<ProListfenji>list= MyTool.tool(rs,ProListfenji.class);
		 return list;
	}

	public List<ProListfenji> getOneDate(int pageindex, int pagesize)throws Exception {
		String sql="select * from easybuy_product_category limit ?,?";
		Object[] paras = {(pageindex-1)*pagesize,pagesize };
		ResultSet rs=executeQuery(sql,paras);
		List<ProListfenji>list= MyTool.tool(rs, ProListfenji.class);  
		return list;
	}
 
	@Test
	public void say() throws Exception{
		List<ProListfenji>list=	getOneDate(1,5);
		for (ProListfenji proListfenji : list) {
			System.out.println(proListfenji.getName());
		}
	}
	
	
	public int totalRecord() throws Exception {
		String sql="select count(1) as count from easybuy_product_category";
		ResultSet rs=executeQuery(sql);
		int count=0;
		if(rs.next()){
		   count=rs.getInt("count");
		}
		return count;
	}

	public List<ProListfenji> findSecond() throws Exception {
		 String sql="SELECT * FROM easybuy_product_category WHERE TYPE=2";
		    ResultSet rs=executeQuery(sql);
		    List<ProListfenji>list= MyTool.tool(rs,ProListfenji.class);
			return list;
	}

	public boolean add(ProListfenji pfj) throws Exception {
		boolean flag=false;
		String sql="INSERT INTO easybuy_product_category (NAME,parentId,TYPE) VALUES(?,?,?)";
		Object[]obj={pfj.getName(),pfj.getParentId(),pfj.getType()};
		int count=executeUpdate(sql,obj);
		if(count>0){
			flag=true;
		}
		return flag;
	}

	public boolean del(int id) {
		boolean flag=false;
		String sql="delete from easybuy_product_category where id=?";
		int count = executeUpdate(sql, id);
		if (count>0) {
			flag=true;
		}
		return flag;
	}

}
