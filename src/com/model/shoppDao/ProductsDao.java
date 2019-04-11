package com.model.shoppDao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;

public class ProductsDao {
	QueryRunner qr = new TxQueryRunner();
	     //模糊查询  
	 public  List AllGoods(String str) {
		 String s="%"+str+"%";
			String sql="select * from product where name like ?";
			List<Products> obj=null;
			Object []obje= {s};
			try {
			return obj=	qr.query(sql, new BeanListHandler<Products>(Products.class),obje);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return null;	
			}
	 //种类
	 public List<categroy> categroy() {
		 String sql="select * from category";
		 List<categroy> obj=null;
			try {
			return obj=	qr.query(sql, new BeanListHandler<categroy>(categroy.class));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return null;
	 }
	
	public static void main(String[] args) {
		 ProductsDao pr=new ProductsDao();
			List<Products> pro= pr.AllGoods("");
		System.out.println(pro.size());

	for(int i1=0;i1<pro.size();i1++) {
		Products ps=pro.get(i1);
	System.out.println(ps.getId()+"  "+ps.getName());
		}
	}
	 public Products findgoods(String str){
		 String sql="select * from product where name=?";
		 try {
		return	qr.query(sql, new BeanHandler<Products>(Products.class),str);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		 
	 }
	 public void upteproduct(Products pro) {
		 String sql="update  product set  name=?,subtitle=?,originalprice=?,promoteprice=?,stock=?,createdate=? where id=?";
		Object[] obj= {pro.getName(),pro.getSubtitle(),pro.getOriginalprice(),pro.getPromoteprice(),pro.getStock(),pro.getCreateDate(),pro.getId()}; 
		 try {
			qr.update(sql, obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public void addproduct(Products pro) {
		 String sql="select * from product";
		 List<Products> listpro = null;
		 try {
		 listpro=	qr.query(sql, new BeanListHandler<Products>(Products.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql1="insert into product set id=?,name=? ,subtitle=?,originalprice=?,promoteprice=?,stock=?,createdate=?,cid=? ";
		Object []obj= {listpro.get(listpro.size()-1).getId()+1,pro.getName(),pro.getSubtitle(),pro.getOriginalprice(),pro.getPromoteprice(),pro.getStock(),pro.getCreateDate(),pro.getCid()};
		try {
			qr.update(sql1, obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public void addcategory(categroy cat) {
		 ProductsDao prodao=new ProductsDao();
		 List<categroy> List = prodao.categroy();
		 String sql="insert into category set id=? ,name=?";
		 Object []obj = {List.get(List.size()-1).getId()+1,cat.getName()};
		 try {
			qr.update(sql, obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void deleteproduct(String id) {
		 String sql="update product set stock=0 where name=?";
		 
		 try {
			qr.update(sql, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
	