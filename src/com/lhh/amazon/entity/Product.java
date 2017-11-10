package com.lhh.amazon.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 产品实体类
 * 
 * @author 46512
 *
 */
public class Product {
	private Long productID;// 产品ID
	private String productName;// 产品名称
	private String description;// 产品说明
	private double price;// 产品价格
	private int stock;// 产品库存
	private ProductCategory categoryID = new ProductCategory();// 产品分类ID
	private ProductCategory childID = new ProductCategory();// 子项ID
	private String fileName;// 文件名字
	private byte status;// 状态 判断是否收藏

	private List<OrderDetail> list = new ArrayList<OrderDetail>();

	public Product(Long productID, String productName, String description, double price, int stock,
			ProductCategory categoryID, ProductCategory childID, String fileName, byte status, List<OrderDetail> list) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.categoryID = categoryID;
		this.childID = childID;
		this.fileName = fileName;
		this.status = status;
		this.list = list;
	}

	public Product() {
		super();
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public ProductCategory getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(ProductCategory categoryID) {
		this.categoryID = categoryID;
	}

	public ProductCategory getChildID() {
		return childID;
	}

	public void setChildID(ProductCategory childID) {
		this.childID = childID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public List<OrderDetail> getList() {
		return list;
	}

	public void setList(List<OrderDetail> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + ", stock=" + stock + ", categoryID=" + categoryID.getCategoryID() + ", childID="
				+ childID.getChildID() + ", fileName=" + fileName + ",status" + status + ", list=" + list + "]";
	}

}
