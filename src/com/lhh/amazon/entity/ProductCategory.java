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
	private Long childID;// 父级分类

	private List<ProductCategory> list = new ArrayList<ProductCategory>();

	public ProductCategory(Long categoryID, String categoryName, Long childID, List<ProductCategory> list) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.childID = childID;
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

	public Long getChildID() {
		return childID;
	}

	public void setChildID(Long childID) {
		this.childID = childID;
	}

	public List<ProductCategory> getList() {
		return list;
	}

	public void setList(List<ProductCategory> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "ProductCategory [categoryID=" + categoryID + ", categoryName=" + categoryName + ", childID=" + childID
				+ ", list=" + list + "]";
	}

}
