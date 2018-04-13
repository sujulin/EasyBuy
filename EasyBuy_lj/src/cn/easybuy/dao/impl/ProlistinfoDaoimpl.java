package cn.easybuy.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.ProlistinfoDao;
import cn.easybuy.entity.Prolist;
import cn.easybuy.util.MyTool;

public class ProlistinfoDaoimpl extends BaseDao implements ProlistinfoDao{

	
	@Test
	public void say(){
		try {
			List<Prolist>list=findByName("苹果 iPhone 6s 128G");
			for (Prolist item:list) {
				System.out.println(item.getPname());
				
			}
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Prolist> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Prolist> list=new ArrayList<Prolist>();
		String sql="select * from easybuy_lj_prolist_info";
		ResultSet rs=executeQuery(sql);
		while(rs.next()){
			Prolist pro=new Prolist();
			pro.setPid(rs.getInt("pid"));
			pro.setPimage(rs.getString("pimage"));
			pro.setPprice(rs.getString("pprice"));
			pro.setPname(rs.getString("pname"));
			list.add(pro);
		}
		return list;
	}
	public List<Prolist> findByName(String name) throws Exception {
		String sql="SELECT * FROM easybuy_lj_prolist_info WHERE pname LIKE ?";
		Object [] obj={"%"+name+"%"};
		ResultSet rs=executeQuery(sql,obj);
		List<Prolist> list=new ArrayList<Prolist>();
		while(rs.next()){
			Prolist pro=new Prolist();
			pro.setPid(rs.getInt("pid"));
			pro.setPimage(rs.getString("pimage"));
			pro.setPprice(rs.getString("pprice"));
			pro.setPname(rs.getString("pname"));
			list.add(pro);
		}
		return list;
	}

	
}
