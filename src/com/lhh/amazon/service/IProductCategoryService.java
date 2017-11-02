package com.lhh.amazon.service;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.ProductCategory;

public interface IProductCategoryService {
	// 查找全部的
	public List<ProductCategory> findCategory() throws ServiceException;
}
