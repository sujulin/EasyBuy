package cn.easybuy.service;

import java.util.List;

import cn.easybuy.entity.OrderInfo;
import cn.easybuy.entity.VipUser;

public interface OrderInfoService {

	public List<OrderInfo> Select() throws Exception;
	
	public OrderInfo getItemsById(int id) ;
	
	
	
}
