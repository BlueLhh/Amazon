package com.lhh.amazon.test.product;

import java.util.ArrayList;
import java.util.List;

import com.lhh.amazon.common.ServiceException;
import com.lhh.amazon.entity.Product;
import com.lhh.amazon.service.IProductService;
import com.lhh.amazon.service.impl.ProductServicempl;

// 查询是否收藏的订单
public class FindCollProduct {
	public static void main(String[] args) {
		IProductService ips = new ProductServicempl();
		List<Product> list;
		List<String> condition = new ArrayList<String>();
		byte status = 1;
		condition.add("hp_status = " + status);
		try {
			list = ips.showProduct(condition);
			for (Product product : list) {
				System.out.println(product);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
