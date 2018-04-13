package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.Address;
import cn.easybuy.entity.Userinfo;



public interface UserinfoDao {
	//判断用户是否登陆
public boolean islogin(Userinfo info)throws Exception;
    //判断管理员是否登录
public boolean login(Userinfo info)throws Exception;
    //修改用户密码
public int updatePassword(Userinfo info)throws Exception;
    //查询所有管理员
public List<Userinfo>findAll()throws Exception;
    //删除管理员
public boolean Deladmin(int id)throws Exception;
    //修改管理员
public boolean Updateadmin(Userinfo info)throws Exception;
    //根据用户名查询用户填的送货地址
public List<Address> findAddressByName(String name)throws Exception;
}
