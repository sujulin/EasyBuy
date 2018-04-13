package cn.easybuy.entity;

import java.util.List;



public class Page {
	private int pageindex;
	private int pagesize;
	private int totalrecord;
	private int totalpage;
	private List<ProListfenji> list;
	private List<Phoneinfo> list1;
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public List<ProListfenji> getList() {
		return list;
	}
	public void setList(List<ProListfenji> list) {
		this.list = list;
	}
	public void setList1(List<Phoneinfo> list1) {
		this.list1=list1;
		
	}
}
