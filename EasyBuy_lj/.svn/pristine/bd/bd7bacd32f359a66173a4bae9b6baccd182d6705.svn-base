package cn.easybuy.dao.impl;




import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.RegisterinfoDao;
import cn.easybuy.entity.Userinfo;
import cn.easybuy.util.MD5Tools;

public class RegisterinfoDaoimpl extends BaseDao implements RegisterinfoDao {

	
	
	
	
	public boolean register(Userinfo reg) throws Exception {
		boolean flag=false;
        String sql="insert into easybuy_lj_user_info (loginName,password,email,mobile) VALUES (?,?,?,?)";
        Object [] obj={reg.getLoginName(),MD5Tools.MD5(reg.getPassword()),reg.getEmail(),reg.getMobile()};
        int count=executeUpdate(sql,obj);
        if(count>0){
        	flag=true;
        	
        }
        return flag;
	}

	
}
