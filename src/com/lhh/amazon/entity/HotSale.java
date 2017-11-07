package com.lhh.amazon.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 热卖实体类
 * 
 * @author 46512
 *
 */
public class HotSale {
	private Product product = new Product();
	private int quantity;
	private List<Product> list = new ArrayList<Product>();

	public HotSale(Product product, int quantity, List<Product> list) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.list = list;
	}

	public HotSale() {
		super();
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

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "HotSale [product=" + product.getProductID() + ", quantity=" + quantity + ", list=" + list + "]";
	}

}
