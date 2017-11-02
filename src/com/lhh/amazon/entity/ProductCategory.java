package com.lhh.amazon.entity;

import java.util.ArrayList;
import java.util.List;

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
	
	private List<ProductCategory> list = new ArrayList<ProductCategory>();

	public ProductCategory(Long categoryID, String categoryName, Long parentCategoryID, List<ProductCategory> list) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.parentCategoryID = parentCategoryID;
		this.list = list;
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

	public List<ProductCategory> getList() {
		return list;
	}

	public void setList(List<ProductCategory> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ProductCategory [categoryID=" + categoryID + ", categoryName=" + categoryName + ", parentCategoryID="
				+ parentCategoryID + ", list=" + list + "]";
	}

}
