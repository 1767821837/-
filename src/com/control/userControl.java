package com.control;

import com.model.userDao.User;
import com.model.userDao.userDao;
import com.util.MD5;

public class userControl  {
	static userDao userdao=new userDao();
	public static boolean VerificationId(User user) {
		if(userdao.findUser(user)==null) {

			return true;
		}
			return false;	
		}

	public static boolean VerificationVipName(User user) {
		if(userdao.findvipName(user)==null) {
		
			return true;
		}
			return false;	
		}
	public static User validateLogon(User user) {
		if(userdao.validateLogon(user)!=null) {
			return userdao.validateLogon(user);
		}
		return null;
		
	}
	public static User userInformation(User user) {
		if(userdao.findUser(user)==null) {

			return user;
		}
		return null;
		
	}
	public void lastVerification(User user) {
		System.out.println(user.toString());
		userdao.addUser(user);
	}
	public static User findpasswordCon(User user,User updatauser) {
		User returnuser=userdao.findpassword(user);
		if(returnuser!=null) {
			userdao.userupdatapasswrd(updatauser);
		}
		return returnuser;
	}
	public static boolean checkanswer(User user) {
		if(userdao.findanswer(user)!=null) {
			return true;
		}
		
		return false;
	}
	public static void uppasswordcon(User user) {
		userdao.userupdatapasswrd(user);
		
	}
	public static boolean setnewloginpassword(User user,String str) {
		if(userdao.validateLogon(user)!=null) {
			System.out.println("111");
			user.setLoginpassword(str);
			userdao.userupdatapasswrd(user);
			return true;
		}
		return false;
	}

	public static boolean setnewpaypassword(User user,String str) {
		if(userdao.finoldpaypassword(user)!=null) {
			System.out.println("111");
			user.setPaypassword(str);
			userdao.updatapaypasswrd(user);
			return true;
		}
		return false;
	}

	
	}
	
	
		

