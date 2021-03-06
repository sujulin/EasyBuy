package cn.easybuy.service.impl;

import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.ProListfenjiDao;
import cn.easybuy.dao.RegisterinfoDao;
import cn.easybuy.dao.impl.ProListfenjiDaoimpl;
import cn.easybuy.dao.impl.RegisterinfoDaoimpl;
import cn.easybuy.entity.ProListfenji;
import cn.easybuy.service.ProListfenjiService;

public class ProListfenjiServiceImpl extends BaseDao implements ProListfenjiService{
	ProListfenjiDao dao=new ProListfenjiDaoimpl();
	public List<ProListfenji> findAll() throws Exception {
		return dao.findAll();
	}
	public List<ProListfenji> findPart(int id) throws Exception {
		
		return dao.findPart(id);
	}
	public List<ProListfenji> getOneDate(int pageindex, int pagesize)
			throws Exception {
		// TODO Auto-generated method stub
		return dao.getOneDate(pageindex, pagesize);
	}
	public int totalRecord() throws Exception {
		// TODO Auto-generated method stub
		return dao.totalRecord();
	}
	public List<ProListfenji> findSecond() throws Exception {
		// TODO Auto-generated method stub
		return dao.findSecond();
	}
	public boolean add(ProListfenji pfj) throws Exception {
		// TODO Auto-generated method stub
		return dao.add(pfj);
	}
	public boolean del(int id) {
		// TODO Auto-generated method stub
		return dao.del(id);
	}

}
