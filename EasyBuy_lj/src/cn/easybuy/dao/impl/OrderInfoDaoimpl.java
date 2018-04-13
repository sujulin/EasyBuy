package cn.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.OrderInfoDao;
import cn.easybuy.dao.ProlistinfoDao;
import cn.easybuy.entity.OrderInfo;
import cn.easybuy.entity.Phoneinfo;
import cn.easybuy.entity.Prolist;
import cn.easybuy.entity.VipUser;

public class OrderInfoDaoimpl extends BaseDao implements OrderInfoDao {

	
	
	public List<OrderInfo> Select() throws Exception {
		
		List<OrderInfo> list=new ArrayList<OrderInfo>();
		String sql="select * from easybuy_lj_userorder";
		ResultSet rs=executeQuery(sql);
		while(rs.next()){
			OrderInfo info=new OrderInfo();
			info.setId(rs.getInt("id"));
			info.setUserId(rs.getInt("userId"));
			info.setLoginName(rs.getString("loginName"));
			info.setUserAddress(rs.getInt("userAddress"));
			
			info.setCreateTime(rs.getDate("createTime"));
			info.setCost(rs.getFloat("cost"));
			info.setSerialNumber(rs.getString("serialNumber"));
			info.setPayType(rs.getString("payType"));
			
			
			list.add(info);
		}
		return list;
	}
	
	
	
	// 根据编号获得资料
		public OrderInfo getItemsById(int id) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				conn = BaseDao.getConnection();
				String sql = "select * from easybuy_lj_userorder where userAddress=?;"; // SQL语句
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, id);
				rs = stmt.executeQuery();
				if (rs.next()) {
					OrderInfo info=new OrderInfo();
					info.setId(rs.getInt("id"));
					info.setUserId(rs.getInt("userId"));
					info.setLoginName(rs.getString("loginName"));
					info.setUserAddress(rs.getInt("userAddress"));
					
					info.setCreateTime(rs.getDate("createTime"));
					info.setCost(rs.getFloat("cost"));
					info.setSerialNumber(rs.getString("serialNumber"));
					info.setPayType(rs.getString("payType"));
					
					
					
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
