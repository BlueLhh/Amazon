package com.lhh.amazon.entity;

import java.util.Date;

/**
 * 
 * 订单实体类
 * 
 * @author 46512
 *
 */
public class Order {
	private Long orderID;// 订单ID
	private User userID;// 用户ID 外键
	private String username;// 用户名
	private String userAddress;// 用户地址
	private Date createTime;// 订单创建时间
	private double cost;// 总价
	private int status;// 状态
	private int type;// 类型

	public Order(Long orderID, User userID, String username, String userAddress, Date createTime, double cost,
			int status, int type) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.username = username;
		this.userAddress = userAddress;
		this.createTime = createTime;
		this.cost = cost;
		this.status = status;
		this.type = type;
	}

	public Order() {
		super();
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
