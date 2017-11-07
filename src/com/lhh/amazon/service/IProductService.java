package com.lhh.amazon.service;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Product;

public interface IProductService {
	// 差查找全部的商品
	public List<Product> allProduct() throws ServiceException;

	// 根据ID来查找
	public Product findProduct(Long id) throws ServiceException;

	// 按条件显示分页商品
	public List<Product> showProduct(List<String> condition, int page) throws ServiceException;

	// 条件查询
	public List<Product> showProduct(List<String> condition) throws ServiceException;

	// 按条件查找商品的总页数
	public int totalPage(List<String> condition) throws ServiceException;

	// 更新库存
	public void updateStock(Long id, int stock) throws ServiceException;
}
