package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.OrderInfo;
import cn.easybuy.entity.VipUser;

public interface OrderInfoDao {
	public List<OrderInfo> Select() throws Exception;
	public OrderInfo getItemsById(int id) ;
	
	
	
}
