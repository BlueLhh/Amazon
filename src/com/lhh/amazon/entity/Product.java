package com.lhh.amazon.entity;

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
	private ProductCategory categoryID;// 产品分类ID
	private String fileName;// 文件名字

	public Product(Long productID, String productName, String description, double price, int stock,
			ProductCategory categoryID, String fileName) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.categoryID = categoryID;
		this.fileName = fileName;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
