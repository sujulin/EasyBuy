package cn.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.ProlistinfoDao;
import cn.easybuy.dao.VipUserDao;
import cn.easybuy.entity.OrderInfo;
import cn.easybuy.entity.VipUser;

public class VipUserDaoimpl extends BaseDao implements VipUserDao {

	
	public VipUser SelectById(int id) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = BaseDao.getConnection();
			String sql = "select * from easybuy_lj_vip_info where aId=?;"; // SQL语句
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				VipUser info=new VipUser();
				

				info.setaID(rs.getInt("aID"));
				info.setaName(rs.getString("aName"));
				info.setZone(rs.getString("zone"));
				info.setSite(rs.getString("site")); 
				info.setZip(rs.getString("zip"));
				info.setPhone(rs.getString("phone"));
					
				
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
	//获取用户信息
			public List<VipUser> SelectUser() throws Exception {
				
				List<VipUser> list=new ArrayList<VipUser>();
				String sql="select * from easybuy_lj_vip_info";
				ResultSet rs=executeQuery(sql);
				while(rs.next()){
					VipUser info=new VipUser();
					
					info.setaID(rs.getInt("aID"));
					info.setaName(rs.getString("aName"));
					info.setZone(rs.getString("zone"));
					info.setSite(rs.getString("site")); 
					info.setZip(rs.getString("zip"));
					info.setPhone(rs.getString("phone"));
						
					
					
					
					list.add(info);
				}
				return list;
			}
		
		
}
