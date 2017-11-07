package com.lhh.amazon.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 订单子项实体类
 * 
 * @author 46512
 *
 */
public class OrderDetail {
	private Long orderDetailID;// 子订单ID
	private Order order = new Order();// 订单ID，外键
	private Product product = new Product();// 产品ID，外键
	private int quantity;// 数量
	private double cost;// 总价

	private List<Product> pList = new ArrayList<Product>();

	public OrderDetail(Long orderDetailID, Order order, Product product, int quantity, double cost,
			List<Product> pList) {
		super();
		this.orderDetailID = orderDetailID;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.cost = cost;
		this.pList = pList;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public List<Product> getpList() {
		return pList;
	}

	public void setpList(List<Product> pList) {
		this.pList = pList;
	}

	@Override
	public String toString() {
		return "OrderDetail [orderDetailID=" + orderDetailID + ", order=" + order.getOrderID() + ", product=" + product.getProductID()
				+ ", quantity=" + quantity + ", cost=" + cost + ", pList=" + pList + "]";
	}

}
