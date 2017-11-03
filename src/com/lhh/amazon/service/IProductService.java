package com.lhh.amazon.service;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Product;

public interface IProductService {
	// 差查找全部的商品
	public List<Product> allProduct() throws ServiceException;

	// 根据ID来查找
	public Product findProduct(Long id) throws ServiceException;
}
