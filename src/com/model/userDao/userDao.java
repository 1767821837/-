package com.model.userDao;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.model.shoppDao.Products;
import com.util.*;
import cn.itcast.jdbc.TxQueryRunner;

public class userDao {
//	
 QueryRunner qr = new TxQueryRunner();
 //查询id
 
public User findUser(User user) {
	String sql="select id from user where id=? ";
	Object[] params = {user.getId()};
	try {
		return qr.query(sql, new BeanHandler<User>(User.class),params);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
}
//注册
public void addUser(User user) {
	String sql="insert into user (id,loginpassword,vipname,paypassword,realname,answer,security,admin) values(?,?,?,?,?,?,?,?)";
	Object [] params = {user.getId(),MD5.MD5(user.getLoginpassword()),user.getVipname(),MD5.MD5(user.getPaypassword())
			,user.getRealname(),user.getAnswer(),user.getSecurity(),"否"};
	try {
		qr.update(sql, params);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//查询会员名
public User findvipName(User user) {
	String sql="select * from user where vipname=?";
	Object[] params = {user.getVipname()};
	try {
		return qr.query(sql, new BeanHandler<User>(User.class),params);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}

}
//登录
public User validateLogon(User user) {
	String sql="select * from user where id=? and loginpassword=?";
	Object[] params = {user.getId(),MD5.MD5(user.getLoginpassword())};
	System.out.println(user.toString());
	try {
		return qr.query(sql, new BeanHandler<User>(User.class),params);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	return null;
	
}

}
//
public User findpassword(User user) {
	String sql="select id,answer,security from user where id=?";
	Object[] obj= {user.getId()}; 
	try {
	return	qr.query(sql, new BeanHandler<User>(User.class),obj);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}
//改密码
public void userupdatapasswrd(User user) {
	String sql="update user set loginpassword=? where id=? ";
	Object[] obj= {MD5.MD5(user.getLoginpassword()),user.getId()};
	try {
		qr.update(sql, obj);
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
}
//验证密保和答案
public User findanswer(User user){
	String sql="select * from user where id=? and security=? and answer=?";
	Object[] obj= {user.getId(),user.getSecurity(),user.getAnswer()};
	try {
		return qr.query(sql,new BeanHandler<User>(User.class),obj);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
//查询旧密码
public User finoldpaypassword(User user) {
	String sql="select * from user where id=? and paypassword=?";
	Object[] obj= {user.getId(),MD5.MD5(user.getPaypassword())};
	try {
		return	qr.query(sql,new BeanHandler<User>(User.class),obj);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
//修改支付密码
public void updatapaypasswrd(User user) {
	String sql="update user set paypassword=? where id=? ";
	Object[] obj= {MD5.MD5(user.getPaypassword()),user.getId()};
	try {
		qr.update(sql, obj);
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
}
public static void main(String[] args) {
	userDao u=new userDao();
	u.asdf();
}
public  void asdf() {
		String sql="select * from product";
		List<Products> obj=null;
		try {
		 obj=	qr.query(sql, new BeanListHandler<Products>(Products.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
		for(Products list:obj) {
		
			System.out.println(list.getCid()+"   "+list.getName());
			i++;
		}
		System.out.println(i);
	
}
//修改收货信息
public void updateaddress(User user) {
	String sql="update user set mobile=?,address=?,post=?,receiver=? where id=?";
	Object []obj= {user.getMobile(),user.getAddress(),user.getPost(),user.getReceiver(),user.getId()};
	try {
		qr.update(sql, obj);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public User Verificationpaypassword(User user) {
	String sql="select * from user where id=? and paypassword=?";
	Object [] obj= {user.getId(),MD5.MD5(user.getPaypassword())};
	try {
	return	qr.query(sql, new BeanHandler<User>(User.class),obj);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
//查找所有用户
public List<User> findallusers(){
	String sql="select *from user";
	try {
	return	qr.query(sql, new BeanListHandler<User>(User.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}


}
