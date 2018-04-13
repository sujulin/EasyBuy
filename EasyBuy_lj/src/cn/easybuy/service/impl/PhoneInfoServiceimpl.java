package cn.easybuy.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.PhoneInfoDao;
import cn.easybuy.dao.impl.PhoneInfoDaoimpl;
import cn.easybuy.entity.Phoneinfo;
import cn.easybuy.service.PhoneInfoService;

public class PhoneInfoServiceimpl extends BaseDao implements PhoneInfoService{
	 PhoneInfoDao  dao=new PhoneInfoDaoimpl();
	/*public boolean Select(Phoneinfo info) throws Exception {
		
	
	}*/

	




	public Phoneinfo getItemsById(int pid) {
		// TODO Auto-generated method stub
		return dao.getItemsById(pid);
	}






	public ArrayList<Phoneinfo> getAllItems() {
		// TODO Auto-generated method stub
		return dao.getAllItems();
	}






	public ArrayList<Phoneinfo> getViewList(String list) {
		// TODO Auto-generated method stub
		return dao.getViewList(list);
	}






	public List<Phoneinfo> getOnePageData(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getOnePage(pageIndex, pageSize);
	}






	public int getTotalCount() throws SQLException {
		// TODO Auto-generated method stub
		return dao.getTotalCount();
	}






	public List<Phoneinfo> getOnePage(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getOnePage(pageIndex, pageSize);
	}
	
	
	
	

}
