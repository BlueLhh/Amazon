package com.lhh.amazon.test.category;

import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.ProductCategory;
import com.lhh.amazon.service.IProductCategoryService;
import com.lhh.amazon.service.impl.ProductCategoryServiceImpl;

/**
 * 
 * 查找商品分类的信息
 * 
 * @author 46512
 *
 */
public class FindProductCategory {
	public static void main(String[] args) {
		IProductCategoryService pcs = new ProductCategoryServiceImpl();
		List<ProductCategory> list = null;
		try {
			list = pcs.findCategory();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if (list.size() > -1) {
			System.out.println("显示所有的信息");
			for (ProductCategory productCategory : list) {
				System.out.println(productCategory);
			}
		} else {
			System.out.println("查询失败");
		}
	}
}
