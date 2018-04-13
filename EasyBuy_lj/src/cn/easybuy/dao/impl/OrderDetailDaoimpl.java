package cn.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.OrderDetailDao;
import cn.easybuy.entity.OrderDetail;
import cn.easybuy.entity.OrderInfo;

public class OrderDetailDaoimpl extends BaseDao implements OrderDetailDao {

	

	public List<OrderDetail> SelectDetail() throws Exception  {
		
		List<OrderDetail> list=new ArrayList<OrderDetail>();
		String sql="select * from easybuy_lj_order_detail";
		ResultSet rs=executeQuery(sql);
		while(rs.next()){
			OrderDetail info=new OrderDetail();
			
			
			info.setId(rs.getInt("id"));
			info.setOrderId(rs.getInt("orderId"));
			info.setProductId(rs.getInt("productId"));
			info.setCost(rs.getFloat("cost"));
			info.setQuantity(rs.getInt("quantity"));
			
			
			
			
			list.add(info);
		}
		return list;
	}
	
	
	
	// 根据编号获得资料
		public OrderDetail getDetailById(int id) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conn = BaseDao.getConnection();
				String sql = "select * from easybuy_lj_order_detail where id=?;"; // SQL语句
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, id);
				rs = stmt.executeQuery();
				if (rs.next()) {
					OrderDetail info=new OrderDetail();
					
					
					info.setId(rs.getInt("id"));
					info.setOrderId(rs.getInt("orderId"));
					info.setProductId(rs.getInt("productId"));
					info.setCost(rs.getFloat("cost"));
					info.setQuantity(rs.getInt("quantity"));
					
					
					
					return info;
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
}
