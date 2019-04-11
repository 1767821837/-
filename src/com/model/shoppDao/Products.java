package com.model.shoppDao;

import java.sql.Date;

public class Products {
private int id;
private String name ;
private String subtitle;
private double originalprice;
private double promoteprice;
private int stock;
private int cid;
private String createDate;
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
 * @return the subtitle
 */
public String getSubtitle() {
	return subtitle;
}
/**
 * @param subtitle the subtitle to set
 */
public void setSubtitle(String subtitle) {
	this.subtitle = subtitle;
}
/**
 * @return the originalprice
 */
public double getOriginalprice() {
	return originalprice;
}
/**
 * @param originalprice the originalprice to set
 */
public void setOriginalprice(double originalprice) {
	this.originalprice = originalprice;
}
/**
 * @return the promoteprice
 */
public double getPromoteprice() {
	return promoteprice;
}
/**
 * @param promoteprice the promoteprice to set
 */
public void setPromoteprice(double promoteprice) {
	this.promoteprice = promoteprice;
}
/**
 * @return the stock
 */
public int getStock() {
	return stock;
}
/**
 * @param stock the stock to set
 */
public void setStock(int stock) {
	this.stock = stock;
}
/**
 * @return the cid
 */
public int getCid() {
	return cid;
}
/**
 * @param cid the cid to set
 */
public void setCid(int cid) {
	this.cid = cid;
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
}
