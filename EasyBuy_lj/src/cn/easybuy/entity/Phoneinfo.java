package cn.easybuy.entity;



public class Phoneinfo {
	private int pid;
		public Phoneinfo()
	{
		
	}
	
	public Phoneinfo(int id,String name,String description,String price,int number,int count)
	{
		this.pid = id;
		this.name = name;
		this.description = description;
		this.count =count;
		this.price = price;
		this.number = number;
		
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	private String name;//�ֻ��ͺ�
	private String description;//�ֻ�����
	private int number;//�ֻ���                                                                                                                                                                                                                                                 
	private int count;//��������
	private String price;//�ֻ��
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}                                                                                        
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	private String filename;
	
	
	
	
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.getPid()+this.getName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this==obj)
		{
			return true;
		}
		if(obj instanceof Phoneinfo)
		{
			Phoneinfo i = (Phoneinfo)obj;
			if(this.getPid()==i.getPid()&&this.getName().equals(i.getName()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	

	
	
}
