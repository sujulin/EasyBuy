package cn.easybuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.entity.OrderDetail;
import cn.easybuy.entity.OrderInfo;

public interface OrderDetailDao {

	public List<OrderDetail> SelectDetail() throws Exception;
	
	public OrderDetail getDetailById(int id);
	
}
