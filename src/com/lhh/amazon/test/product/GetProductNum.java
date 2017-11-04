package com.lhh.amazon.test.product;

import java.util.ArrayList;
import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.ProductServicempl;

public class GetProductNum {
	public static void main(String[] args) {
		IProductService ips = new ProductServicempl();
		Long id = 22L;
		// 写条件
		List<String> conditions = new ArrayList<String>();
		conditions.add("hpc_child_id = " + id);
		//conditions.add("hpc_id = " + id);
		int page;
		List<Product> list;
		try {
			list = ips.showProduct(conditions);
			page = ips.totalPage(conditions);
			for (Product product : list) {
				System.out.println(product);
			}
			System.out.println("一共有:" + page + "页");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
