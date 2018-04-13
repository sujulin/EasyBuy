package cn.easybuy.dao;

import java.util.List;


import cn.easybuy.entity.VipUser;

public interface VipUserDao {

	public List<VipUser> SelectUser() throws Exception;
	
	public VipUser SelectById(int id) ;
	
}
