package cn.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.PhoneInfoDao;
import cn.easybuy.entity.Phoneinfo;
import cn.easybuy.util.MyTool;







public class PhoneInfoDaoimpl extends BaseDao implements PhoneInfoDao{
/*
	  @Test
	  public void test(){
		  
		  Map<String, Phoneinfo> list = new HashMap<String, Phoneinfo>();
		  list.put("1", (Phoneinfo) list);
		  for (Map.Entry<String, Phoneinfo> newsEntity : list.entrySet()) {
			System.out.println(newsEntity.getValue());
		}
	  }*/
	
	
	
	
	// 获得所有的商品信息
		public ArrayList<Phoneinfo> getAllItems() {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<Phoneinfo> list = new ArrayList<Phoneinfo>(); // 商品集合
			try {
				conn = BaseDao.getConnection();
				String sql = "select * from easybuy_lj_phone_info;"; // SQL语句
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while (rs.next()) {
					/*Phoneinfo item = new Phoneinfo();
					item.setId(rs.getInt("id"));
					item.setName(rs.getString("name"));
					item.setCity(rs.getString("city"));
					item.setNumber(rs.getInt("number"));
					item.setPrice(rs.getInt("price"));
					item.setPicture(rs.getString("picture"));
					*/
					Phoneinfo item = new Phoneinfo();
					item.setPid(rs.getInt("pid"));
					item.setName(rs.getString("name"));
					item.setDescription(rs.getString("description"));
					item.setNumber(rs.getInt("number"));
					item.setPrice(rs.getString("price"));
					item.setCount(rs.getInt("count"));
					item.setFilename(rs.getString("filename"));
					list.add(item);// 把一个商品加入集合
				}
				return list; // 返回集合。
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			} finally {
				// 释放数据集对象
				if (rs != null) {
					try {
						rs.close();
						rs = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// 释放语句对象
				if (stmt != null) {
					try {
						stmt.close();
						stmt = null;
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}

		}

	
	
	
	

	// 根据商品编号获得商品资料
	public Phoneinfo getItemsById(int pid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from easybuy_lj_phone_info where pid=?;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pid);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Phoneinfo item = new Phoneinfo();
				item.setPid(rs.getInt("pid"));
				item.setName(rs.getString("name"));
				item.setDescription(rs.getString("description"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getString("price"));
				item.setCount(rs.getInt("count"));
				item.setFilename(rs.getString("filename"));
				return item;
			} else {
				return null;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		}
	}
	
	
	/*
	public List<Phoneinfo> Select(int pid) {
		
		System.out.println("ha");
		
		List<Phoneinfo> list = new ArrayList<Phoneinfo>();
		//String sql = "select * from easybuy_lj_phone_info where pid='" + pid + "'";
		String sql = "SELECT * FROM easybuy_lj_phone_info,easybuy_lj_prolist_info WHERE easybuy_lj_prolist_info.pid=easybuy_lj_phone_info.pid";
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Phoneinfo info = new Phoneinfo();
				//info.setPid(rs.getInt(1));
				info.setPid(rs.getInt("pid"));
				
				info.setName(rs.getNString("name"));
				
				info.setDescription(rs.getNString("description"));
				
				info.setNumber(rs.getInt("number"));
				
				info.setCount(rs.getInt("count"));
				
				info.setPrice(rs.getNString("price"));
				
		

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}
	*/
/*	public boolean Select(Phoneinfo info) throws Exception {
		boolean flag=false;
		String sql="select * from easybuy_lj_phone_info where pid = ?";
		Object[] obj={info.getDescription(),info.getCount(),info.getName(),info.getNumber(),info.getPrice(),info.getFilename()};
		ResultSet rs=executeQuery(sql,obj);
		if(rs.next()){
			int count=rs.getInt("count");
			if(count>0){
				flag=true;
			}
		}
		return flag;
	}

	*/
	
	
	
	//获取最近浏览的前五条商品信息
		public ArrayList<Phoneinfo> getViewList(String list)
		{
			System.out.println("list:"+list);
			ArrayList<Phoneinfo> itemlist = new ArrayList<Phoneinfo>();
			int iCount=5; //每次返回前五条记录
			if(list!=null&&list.length()>0)
			{
			    String[] arr = list.split(",");
			    System.out.println("arr.length="+arr.length);
			    //如果商品记录大于等于5条
			    if(arr.length>=5)
			    {
			       for(int i=arr.length-1;i>=arr.length-iCount;i--)
			       {
			    	  itemlist.add(getItemsById(Integer.parseInt(arr[i])));  
			       }
			    }
			    else
			    {
			    	for(int i=arr.length-1;i>=0;i--)
			    	{
			    		itemlist.add(getItemsById(Integer.parseInt(arr[i])));
			    	}
			    }
			    return itemlist;
			}
			else
			{
				return null;
			}
			
		}

	
	
		
		
		
		
		
		
		
		//分页
		
		 public List<Phoneinfo> getOnePage(int pageIndex,int pageSize){
			  
			  String sql="select * from easybuy_lj_phone_info limit ?,?";
			  
			  Object[] paras = {(pageIndex-1)*pageSize,pageSize};
			  ResultSet rs = executeQuery(sql,paras);
			  List<Phoneinfo> list = MyTool.tool(rs,Phoneinfo.class);
			  
			  
			  
			return list;
	
			  
		  }
		
		 
		 public int getTotalCount() throws SQLException {
				String sql="select count(1) as count from easybuy_lj_phone_info";
				ResultSet rs = executeQuery(sql);
				int count=0;
				if(rs.next()){
					count=rs.getInt("count");
				}
				
				return count;
			}

		
		 public List<Phoneinfo> getOnePageData(int pageIndex, int pageSize) {
				String sql="select * from easybuy_lj_phone_info where pid=? limit ?,?";
				Object[] paras={(pageIndex-1)*pageSize,pageSize};
				ResultSet rs = executeQuery(sql, paras);
				List<Phoneinfo> list = MyTool.tool(rs, Phoneinfo.class);
				return list;
			}
		
	
	
	
	
}
