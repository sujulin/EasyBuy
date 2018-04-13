package cn.easybuy.service;

import java.util.List;

import cn.easybuy.entity.OrderDetail;

public interface OrderDetailService {

	
	public List<OrderDetail> SelectDetail() throws Exception;
	
	public OrderDetail getDetailById(int id);
}
