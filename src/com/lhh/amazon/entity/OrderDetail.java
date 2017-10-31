package com.lhh.amazon.entity;

/**
 * 
 * 订单子项实体类
 * 
 * @author 46512
 *
 */
public class OrderDetail {
	private Long orderDetailID;// 子订单ID
	private Order orderID;// 订单ID，外键
	private Product productID;// 产品ID，外键
	private int quantity;// 数量
	private double cost;// 总价

	public OrderDetail(Long orderDetailID, Order orderID, Product productID, int quantity, double cost) {
		super();
		this.orderDetailID = orderDetailID;
		this.orderID = orderID;
		this.productID = productID;
		this.quantity = quantity;
		this.cost = cost;
	}

	public OrderDetail() {
		super();
	}

	public Long getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(Long orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public Order getOrderID() {
		return orderID;
	}

	public void setOrderID(Order orderID) {
		this.orderID = orderID;
	}

	public Product getProductID() {
		return productID;
	}

	public void setProductID(Product productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
