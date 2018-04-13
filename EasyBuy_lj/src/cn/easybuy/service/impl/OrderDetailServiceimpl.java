package cn.easybuy.service.impl;

import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.OrderDetailDao;
import cn.easybuy.dao.OrderInfoDao;
import cn.easybuy.dao.impl.OrderDetailDaoimpl;
import cn.easybuy.dao.impl.OrderInfoDaoimpl;
import cn.easybuy.entity.OrderDetail;
import cn.easybuy.service.OrderDetailService;
import cn.easybuy.service.OrderInfoService;

public class OrderDetailServiceimpl extends BaseDao implements OrderDetailService{
	OrderDetailDao dao=new OrderDetailDaoimpl();
	public List<OrderDetail> SelectDetail() throws Exception {
		// TODO Auto-generated method stub
		return dao.SelectDetail();
	}

	public OrderDetail getDetailById(int id) {
		// TODO Auto-generated method stub
		return dao.getDetailById(id);
	}

}
