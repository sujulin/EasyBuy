package cn.easybuy.service;

import java.util.List;

import cn.easybuy.entity.Prolist;

public interface ProlistinfoService {
	public List<Prolist> findAll() throws Exception;
	
	public List<Prolist> findByName(String name) throws Exception;
}
