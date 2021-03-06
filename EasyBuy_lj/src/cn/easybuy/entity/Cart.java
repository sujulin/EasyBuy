package cn.easybuy.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cart {

	//购买商品的集合
	private HashMap<Phoneinfo,Integer> goods;
	

	//购物车的总金额
	private double totalPrice;

	//构造方法
	public Cart()
	{
		goods = new HashMap<Phoneinfo,Integer>();
		totalPrice = 0.0;
	}
	
	
	public HashMap<Phoneinfo, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Phoneinfo, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	//添加商品进购物车的方法
	public boolean addGoodsInCart(Phoneinfo item ,int number)
	{
		if(goods.containsKey(item))
		{
			goods.put(item, goods.get(item)+number);
		}
		else
		{
			goods.put(item, number);	
		}
		calTotalPrice(); //重新计算购物车的总金额
		return true;
	}
	
	//删除商品的方法
	public boolean removeGoodsFromCart(Phoneinfo item)
	{
		goods.remove(item);
		calTotalPrice(); //重新计算购物车的总金额
		return true;
	}
	
	//统计购物车的总金额
	public double calTotalPrice()
	{
		double sum = 0.0;
		Set<Phoneinfo> keys = goods.keySet(); //获得键的集合
		Iterator<Phoneinfo> it = keys.iterator(); //获得迭代器对象
	    while(it.hasNext())
	    {
	    	Phoneinfo i = it.next();
	    	sum += Integer.parseInt(i.getPrice())* goods.get(i);
	    }
	    this.setTotalPrice(sum); //设置购物车的总金额
	    return this.getTotalPrice();
	}
}
