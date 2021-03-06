package cn.easybuy.service;

import java.util.List;

import cn.easybuy.entity.Address;
import cn.easybuy.entity.Userinfo;

public interface UserinfoService {
	public boolean islogin(Userinfo info) throws Exception;
	
	public int updatePassword(Userinfo info) throws Exception;
	public boolean login(Userinfo info) throws Exception;
	public List<Userinfo> findAll() throws Exception;
	public boolean Deladmin(int id) throws Exception;
	public boolean Updateadmin(Userinfo info) throws Exception;
	public List<Address> findAddressByName(String name) throws Exception;
}
