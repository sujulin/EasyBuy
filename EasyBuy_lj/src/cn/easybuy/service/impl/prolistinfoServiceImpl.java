package cn.easybuy.service.impl;

import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.ProlistinfoDao;
import cn.easybuy.dao.impl.ProlistinfoDaoimpl;
import cn.easybuy.entity.Prolist;
import cn.easybuy.service.ProlistinfoService;

public class prolistinfoServiceImpl extends BaseDao implements ProlistinfoService{

	ProlistinfoDao dao=new ProlistinfoDaoimpl();
	public List<Prolist> findAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	public List<Prolist> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

}
