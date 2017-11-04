package com.lhh.amazon.test.product;

import java.util.ArrayList;
import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.ProductServicempl;

/**
 * 条件查询测试
 * 
 * @author 46512
 *
 */
public class ConditionFindProduct {
	public static void main(String[] args) {
		IProductService ips = new ProductServicempl();
		Long id = 14L;
		// 写条件
		List<String> conditions = new ArrayList<String>();
		// 查询的是父分类的ID
		//conditions.add("hpc_id = " + id);
		//查询子分类的ID
		conditions.add("hpc_child_id = " + id);
		List<Product> list;
		try {
			list = ips.showProduct(conditions);
			for (Product product : list) {
				System.out.println(product);
			}
			System.out.println("一共有：" + list.size() + "条记录");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
