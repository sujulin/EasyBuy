package cn.easybuy.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import org.junit.Test;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.UserinfoDao;
import cn.easybuy.entity.Address;
import cn.easybuy.entity.Userinfo;
import cn.easybuy.util.MyTool;


public class UserinfoDaoimpl extends BaseDao implements UserinfoDao {

	//�жϵ�½�ķ���
	public boolean islogin(Userinfo info) throws Exception {
		boolean flag=false;
		String sql="select count(1) as count from easybuy_lj_user_info where loginName=? and password=?";
		Object[] obj={info.getLoginName(),info.getPassword()};
		ResultSet rs=executeQuery(sql,obj);
		if(rs.next()){
			int count=rs.getInt("count");
			if(count>0){
				flag=true;
			}
		}
		return flag;
	}

	public int updatePassword(Userinfo info) throws Exception {
		String sql = "UPDATE easybuy_lj_user_info SET PASSWORD=? WHERE loginName=?";
		Object[] paras = {info.getPassword(),info.getLoginName()};
		int count = executeUpdate(sql, paras);
		if (count > 0) {
			System.out.println("修改成功");
		}
		return count;
		
		
	}

	public boolean login(Userinfo info) throws Exception {
		boolean flag=false;
		String sql="SELECT count(1) as count FROM easybuy_lj_user_info WHERE 1=(SELECT TYPE FROM easybuy_lj_user_info WHERE loginName=?) AND PASSWORD=? ";
		Object[] paras = {info.getLoginName(),info.getPassword()};
		ResultSet rs=executeQuery(sql,paras);
		if(rs.next()){
			int count=rs.getInt("count");
			if(count>0){
				flag=true;
			}
		}
		return flag;
	}

	public List<Userinfo> findAll() throws Exception {
		String sql="SELECT * FROM easybuy_lj_user_info WHERE TYPE=1";
		ResultSet rs= executeQuery(sql);
		 List<Userinfo>list=MyTool.tool(rs, Userinfo.class);
		return list;
	}

	public boolean Deladmin(int id) throws Exception {
		boolean flag=false;
		String sql="DELETE FROM easybuy_lj_user_info WHERE id=?";
		int count = executeUpdate(sql, id);
		if (count > 0) {
			flag=true;
		}
		return flag;
	}

	public boolean Updateadmin(Userinfo info) throws Exception {
		boolean flag=false;
		String sql="UPDATE easybuy_lj_user_info SET loginName=? , PASSWORD=? ,email=?,mobile=? WHERE id=?";
		Object []obj={info.getLoginName(),info.getPassword(),info.getEmail(),info.getMobile(),info.getId()};
		int count = executeUpdate(sql, obj);
		if (count > 0) {
			flag=true;
		}
		return flag;
	}

	@Test
	public void say() throws Exception{
		List<Address> list=findAddressByName("1");
		for (Address address : list) {
			System.out.println(address.getSite());
		}
	}
	public List<Address> findAddressByName(String name) throws Exception {
		String sql="SELECT * FROM easybuy_lj_vip_info WHERE aName=?";
		ResultSet rs=executeQuery(sql,name);
		List<Address>list=MyTool.tool(rs, Address.class);
		return list;
	}

	

}
