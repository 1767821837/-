package com.model.userDao;

public class User {
	private long id;//账号
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	

	private String loginpassword; //登录密码
	private String vipname;//会员名
	private String realname;//真实姓名
	private String security;//密保
	private String answer;//答案
	private String paypassword;//支付密码
	private String address;//地址
	private String mobile;//电话
	private String post;//邮编
	private String receiver;//收获人信息
	private String admin;
/**
	 * @return the security
	 */
	

	/**
	 * @return the admin
	 */
	public String getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(String admin) {
		this.admin = admin;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the post
	 */
	public String getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(String post) {
		this.post = post;
	}

	/**
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * @return the paypassword
	 */
	public String getPaypassword() {
		return paypassword;
	}

	/**
	 * @return the security
	 */
	public String getSecurity() {
		return security;
	}

	/**
	 * @param security the security to set
	 */
	public void setSecurity(String security) {
		this.security = security;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @param paypassword the paypassword to set
	 */
	public void setPaypassword(String paypassword) {
		this.paypassword = paypassword;
	}

/**
	 * @return the realname
	 */
	public String getRealname() {
		return realname;
	}

	/**
	 * @param realname the realname to set
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}

/**
	 * @return the vipname
	 */
	public String getVipname() {
		return vipname;
	}

	/**
	 * @param vipname the vipname to set
	 */
	public void setVipname(String vipname) {
		this.vipname = vipname;
	}




	/**
	 * @return the loginpassword
	 */
	public String getLoginpassword() {
		return loginpassword;
	}

	
	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */


	

	public void setId(long id) {
		// TODO Auto-generated method stub
		this.id = id/10;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", loginpassword=" + loginpassword + ", vipname=" + vipname + ", realname=" + realname
				+ ", security=" + security + ", answer=" + answer + ", paypassword=" + paypassword + ", address="
				+ address + ", mobile=" + mobile + ", post=" + post + ", receiver=" + receiver + "]";
	}








}
