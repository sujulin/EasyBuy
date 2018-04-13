package cn.easybuy.service.impl;

import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.UserinfoDao;
import cn.easybuy.dao.impl.UserinfoDaoimpl;
import cn.easybuy.entity.Address;
import cn.easybuy.entity.Userinfo;
import cn.easybuy.service.UserinfoService;



public class UserinfoServiceImpl extends BaseDao implements UserinfoService {

	private UserinfoDao dao=new UserinfoDaoimpl();
	public boolean islogin(Userinfo info) throws Exception {
		
		return dao.islogin(info);
	}
	public int updatePassword(Userinfo info) throws Exception {
		// TODO Auto-generated method stub
		return dao.updatePassword(info);
	}
	public boolean login(Userinfo info) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(info);
	}
	public List<Userinfo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	public boolean Deladmin(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.Deladmin(id);
	}
	public boolean Updateadmin(Userinfo info) throws Exception {
		// TODO Auto-generated method stub
		return dao.Updateadmin(info);
	}
	public List<Address> findAddressByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.findAddressByName(name);
	}

}
