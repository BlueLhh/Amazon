package com.lhh.amazon.entity;

/**
 * 购物车类
 * 
 * @author 46512
 *
 */
public class Cart {
	private Long cartID = -1L;// 购物车内每一条商品的ID
	private Product product = new Product();// 产品ID
	private int quantity;// 数量
	private Long userID;// 用户ID

	public Cart(Long cartID, Product product, int quantity, Long userID) {
		super();
		this.cartID = cartID;
		this.product = product;
		this.quantity = quantity;
		this.userID = userID;
	}

	public Cart() {
		super();
	}

	public Long getCartID() {
		return cartID;
	}

	public void setCartID(Long cartID) {
		this.cartID = cartID;
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

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "Cart [cartID=" + cartID + ", product=" + product + ", quantity=" + quantity + ", userID=" + userID
				+ "]";
	}

}
