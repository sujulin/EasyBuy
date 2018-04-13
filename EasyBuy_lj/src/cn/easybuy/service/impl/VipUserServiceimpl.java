package cn.easybuy.service.impl;

import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.ProListfenjiDao;
import cn.easybuy.dao.VipUserDao;
import cn.easybuy.dao.impl.ProListfenjiDaoimpl;
import cn.easybuy.dao.impl.VipUserDaoimpl;
import cn.easybuy.entity.VipUser;
import cn.easybuy.service.ProlistinfoService;
import cn.easybuy.service.VipUserService;

public class VipUserServiceimpl extends BaseDao implements VipUserService {
	VipUserDao dao=new VipUserDaoimpl();
	public List<VipUser> SelectUser() throws Exception {
		// TODO Auto-generated method stub
		return dao.SelectUser();
	}

	public VipUser SelectById(int id) {
		// TODO Auto-generated method stub
		return dao.SelectById(id);
	}

}
