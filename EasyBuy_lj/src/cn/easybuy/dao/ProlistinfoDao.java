package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.Prolist;

public interface ProlistinfoDao {
   public List<Prolist> findAll() throws Exception;
   
   public List<Prolist> findByName(String name) throws Exception;
}
