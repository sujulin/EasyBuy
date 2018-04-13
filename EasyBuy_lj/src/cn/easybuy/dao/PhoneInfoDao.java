package cn.easybuy.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.entity.Phoneinfo;

public interface PhoneInfoDao {

	
	public Phoneinfo getItemsById(int pid);
	public ArrayList<Phoneinfo> getAllItems();
	public ArrayList<Phoneinfo> getViewList(String list);
	
	
	
	
	 public List<Phoneinfo> getOnePageData(int pageIndex, int pageSize) ;
	 
	 public int getTotalCount() throws SQLException;
	 public List<Phoneinfo> getOnePage(int pageIndex,int pageSize);
	 
	
}
