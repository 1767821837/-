package com.model.shoppDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.model.userDao.User;

import cn.itcast.jdbc.TxQueryRunner;

public class order_Dao {
	QueryRunner qr = new TxQueryRunner();
	public void addorder(User users,order_ ord,Products pro) {
		
		String sqll="select * from user where id=?";
		Object [] ob= {users.getId()};
		User user=null ;
		try {
			user = qr.query(sqll, new BeanHandler<User>(User.class),ob);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sqlss="select * from order_";
		List<order_> list=null;
		try {
		  list=	qr.query(sqlss, new BeanListHandler<order_>(order_.class));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
System.out.println(ord.getStatus());
		System.out.println(list.get(list.size()-1).getId()+1);
		String sql="insert  into order_ (id,orderCode,address,post,receiver,mobile,userMessage,"
				+ "createDate,payDate,deliveryDate,confirmDate,uid,status,number,name,price,money) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	Object []obj= {list.get(list.size()-1).getId()+1,ord.getOrderCode(),user.getAddress(),user.getPost(),user.getReceiver(),user.getMobile(),ord.getUserMessage(),
			ord.getCreateDate(),ord.getPayDate(),ord.getDeliveryDate(),ord.getConfirmDate(),ord.getUid(),ord.getStatus(),ord.getNumber(),ord.getName(),ord.getPrice(),ord.getMoney()};
			try {
				
				qr.update(sql, obj);
			
				if(ord.getStatus().equals("下单成功")) {
					String prodsql="update product set stock=? where name=?";
					Object[] stock= {pro.getStock()-ord.getNumber(),ord.getName()};
					
						qr.update(prodsql, stock);
						}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		

	}
	//查询购物车
	public List<order_> finduserordercar(User user,String str) {
		String sql="select * from order_ where uid=? and status=?";
		Object[] obj= {user.getId(),str};
		try {
		return	qr.query(sql, new BeanListHandler<order_>(order_.class),obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public List<order_> finduserorder(User user) {
		String sql="select * from order_ where uid=? and status!=?";
		Object[] obj= {user.getId(),"购物车"};
		try {
		return	qr.query(sql, new BeanListHandler<order_>(order_.class),obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void deleteordercar(order_ order) {
		System.out.println(order.getName()+"     "+order.getUid()+"     "+order.getStatus());
		String sql="delete from order_ where name=? and uid=? and status=?";
		Object []obj= {order.getName(),order.getUid(),order.getStatus()};
		try {
			qr.update(sql, obj);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public List<Products> adminfindallgoods(){
	String 	sql="select * from product";
	try {
	return	qr.query(sql, new BeanListHandler<Products>(Products.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
		
	}
public List<order_> adminlookorder(){
	String sql="select * from order_ where status!=?";
	try {
	return	qr.query(sql, new BeanListHandler<order_>(order_.class),"购物车");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}
public void updateuserorder(order_ ord) {
	String sql="update order_ set status=?, deliveryDate=? where ordercode=?";
	Object[] obj= {ord.getStatus(),ord.getDeliveryDate(),ord.getOrderCode()};
	try {
		qr.update(sql, obj);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public List<viewer> findview() {
	String sql="select * from review";
	try {
	return	qr.query(sql, new BeanListHandler<viewer>(viewer.class));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}
} 
