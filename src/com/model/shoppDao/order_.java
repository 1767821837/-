package com.model.shoppDao;

import java.util.Date;

public class order_ {
/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

private int id;
private String orderCode;
private String address;
private String post;
private String receiver;
private String mobile;
private String userMessage;
private String createDate;
private String payDate;
private String deliveryDate;
private String confirmDate;
private String name;
private int number;
private double price;
private double money;
/**
 * @return the price
 */
public double getPrice() {
	return price;
}
/**
 * @param d the price to set
 */
public void setPrice(double d) {
	this.price = d;
}
/**
 * @return the money
 */
public double getMoney() {
	return money;
}
/**
 * @param d the money to set
 */
public void setMoney(double d) {
	this.money = d;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return the number
 */
public int getNumber() {
	return number;
}
/**
 * @param number the number to set
 */
public void setNumber(int number) {
	this.number = number;
}
/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the orderCode
 */
public String getOrderCode() {
	return orderCode;
}
/**
 * @param orderCode the orderCode to set
 */
public void setOrderCode(String orderCode) {
	this.orderCode = orderCode;
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
 * @return the userMessage
 */
public String getUserMessage() {
	return userMessage;
}
/**
 * @param userMessage the userMessage to set
 */
public void setUserMessage(String userMessage) {
	this.userMessage = userMessage;
}

/**
 * @return the createDate
 */
public String getCreateDate() {
	return createDate;
}
/**
 * @param createDate the createDate to set
 */
public void setCreateDate(String createDate) {
	this.createDate = createDate;
}
/**
 * @return the payDate
 */
public String getPayDate() {
	return payDate;
}
/**
 * @param payDate the payDate to set
 */
public void setPayDate(String payDate) {
	this.payDate = payDate;
}
/**
 * @return the deliveryDate
 */
public String getDeliveryDate() {
	return deliveryDate;
}
/**
 * @param deliveryDate the deliveryDate to set
 */
public void setDeliveryDate(String deliveryDate) {
	this.deliveryDate = deliveryDate;
}
/**
 * @return the confirmDate
 */
public String getConfirmDate() {
	return confirmDate;
}
/**
 * @param confirmDate the confirmDate to set
 */
public void setConfirmDate(String confirmDate) {
	this.confirmDate = confirmDate;
}
/**
 * @return the status
 */
public String getStatus() {
	return status;
}
/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}
/**
 * @return the uid
 */
public String getUid() {
	return uid;
}
/**
 * @param uid the uid to set
 */
public void setUid(String uid) {
	this.uid = uid;
}
private String status;
private String uid;
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "order_ [id=" + id + ", orderCode=" + orderCode + ", address=" + address + ", post=" + post + ", receiver="
			+ receiver + ", mobile=" + mobile + ", userMessage=" + userMessage + ", createDate=" + createDate
			+ ", payDate=" + payDate + ", deliveryDate=" + deliveryDate + ", confirmDate=" + confirmDate + ", name="
			+ name + ", number=" + number + ", status=" + status + ", uid=" + uid + "]";
}

 
}
