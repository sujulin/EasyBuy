package cn.easybuy.service;

import java.util.List;

import cn.easybuy.entity.VipUser;

public interface VipUserService {


	public List<VipUser> SelectUser() throws Exception;
	
	public VipUser SelectById(int id) ;
}
