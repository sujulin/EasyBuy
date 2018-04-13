package cn.easybuy.service.impl;

import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.OrderInfoDao;
import cn.easybuy.dao.ProlistinfoDao;
import cn.easybuy.dao.impl.OrderInfoDaoimpl;
import cn.easybuy.dao.impl.ProlistinfoDaoimpl;
import cn.easybuy.entity.OrderInfo;
import cn.easybuy.entity.VipUser;
import cn.easybuy.service.OrderInfoService;
import cn.easybuy.service.PhoneInfoService;

public class OrderInfoServiceimpl extends BaseDao implements OrderInfoService {
	OrderInfoDao dao=new OrderInfoDaoimpl();
	VipUser dao1 = new VipUser();
	public List<OrderInfo> Select() throws Exception {
		// TODO Auto-generated method stub
		return dao.Select();
	}
	public OrderInfo getItemsById(int id) {
		// TODO Auto-generated method stub
		return dao.getItemsById(id);
	}
	
}
