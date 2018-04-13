package cn.easybuy.service.impl;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.RegisterinfoDao;

import cn.easybuy.dao.impl.RegisterinfoDaoimpl;

import cn.easybuy.entity.Userinfo;
import cn.easybuy.service.RegisterinfoService;

public class RegisterinfoServiceImpl extends BaseDao implements RegisterinfoService{

	RegisterinfoDao dao=new RegisterinfoDaoimpl();
	public boolean register(Userinfo reg) throws Exception {
		// TODO Auto-generated method stub
		return dao.register(reg);
	}

	
}
