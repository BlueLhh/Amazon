package com.lhh.amazon.entity;

/**
 * 购物车类
 * 
 * @author 46512
 *
 */
public class Cart {
	private Long cartID;// 购物车ID
	private Long productID;// 产品ID
	private int quantity;// 数量
	private Long userID;// 用户ID

	public Cart(Long cartID, Long productID, int quantity, Long userID) {
		super();
		this.cartID = cartID;
		this.productID = productID;
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

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
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

}
