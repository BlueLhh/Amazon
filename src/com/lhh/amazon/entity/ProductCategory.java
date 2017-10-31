package com.lhh.amazon.entity;

/**
 * 
 * 产品分类实体类
 * 
 * @author 46512
 *
 */
public class ProductCategory {
	private Long categoryID; // 分类ID
	private String categoryName;// 分类名
	private Long parentCategoryID;// 父级分类

	public ProductCategory(Long categoryID, String categoryName, Long parentCategoryID) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.parentCategoryID = parentCategoryID;
	}

	public ProductCategory() {
		super();
	}

	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getParentCategoryID() {
		return parentCategoryID;
	}

	public void setParentCategoryID(Long parentCategoryID) {
		this.parentCategoryID = parentCategoryID;
	}

}
