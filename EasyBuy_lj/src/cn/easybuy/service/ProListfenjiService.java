package cn.easybuy.service;

import java.util.List;

import cn.easybuy.entity.ProListfenji;

public interface ProListfenjiService {
	public List<ProListfenji> findAll() throws Exception;
	
	public List<ProListfenji> findPart(int id) throws Exception;
	public List<ProListfenji> getOneDate(int pageindex, int pagesize)throws Exception;
	public int totalRecord() throws Exception;
	public List<ProListfenji> findSecond() throws Exception;
	public boolean add(ProListfenji pfj) throws Exception;
	//删除分类
		public boolean del(int id);
}
